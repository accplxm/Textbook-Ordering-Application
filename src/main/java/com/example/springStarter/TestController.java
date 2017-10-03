package com.example.springStarter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.springStarter.Constants.Setup;
import com.example.springStarter.googleAuthorization.MailingConfig;
import com.example.springStarter.model.ClassOrder;
import com.example.springStarter.model.Course;
import com.example.springStarter.model.Order;
import com.example.springStarter.model.Order.status;
import com.example.springStarter.model.Task;
import com.example.springStarter.model.Textbook;
import com.example.springStarter.model.User;
import com.example.springStarter.model.User.role;
import com.example.springStarter.service.ClassOrderService;
import com.example.springStarter.service.CourseService;
import com.example.springStarter.service.DepartmentService;
import com.example.springStarter.service.OrderService;
import com.example.springStarter.service.TaskService;
import com.example.springStarter.service.TermService;
import com.example.springStarter.service.TextbookService;
import com.example.springStarter.service.UserService;




@Controller
public class TestController {

    @Autowired
    public TaskService taskService;
    @Autowired
    public DepartmentService departmentService;
    @Autowired
    public UserService userService;

    @Autowired
    public ClassOrderService classOrderService;

    @Autowired
    public CourseService courseService;

    @Autowired
    public OrderService orderService;

    @Autowired
    public TermService termService;

    @Autowired
    public TextbookService textbookService;

    @Autowired
    public helperClass helperClass;

    @Autowired
    private MailingConfig mailingConfig;





     private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static boolean isInvalidLogIn=false;

    @RequestMapping("/welcome.html")
    public ModelAndView firstPage(){
        return new ModelAndView("welcome");
    }


    @RequestMapping("/oauth2callback")
    public ModelAndView RedirectPage(HttpServletRequest request){
        request.setAttribute("mode", "MODE_HOME");
        isInvalidLogIn= false;

        request.setAttribute("redirect_URL", Setup.GOOGLE_AUTH_URL);
        return new ModelAndView("google");
    }


    @RequestMapping("/logInPage.html")
    public ModelAndView LogInPage(HttpServletRequest request){
//		request.setAttribute("mode", "MODE_HOME");
//
//		request.setAttribute("redirect_URL", Setup.GOOGLE_AUTH_URL);
        logger.info("Entered login page maaping method");
        if(request.getAttribute("isInvalidLogIn")!=null)
        request.setAttribute("isInvalidLogIn", (boolean) request.getAttribute("isInvalidLogIn"));
        request.setAttribute("redirect_URL", Setup.GOOGLE_AUTH_URL);
        return new ModelAndView("loginPage");
    }


    @RequestMapping("/landingPage")
    public ModelAndView LandingPageRedirect(HttpServletRequest request){

        return new ModelAndView("redirect:/landingPage.html");
    }



    @RequestMapping("/landingPage.html")
    public ModelAndView LandingPage(HttpServletRequest request){
//		request.setAttribute("mode", "MODE_HOME");
//
//		request.setAttribute("redirect_URL", Setup.GOOGLE_AUTH_URL);


        request.setAttribute("page", "PAGE_HOME");
        request.getSession().setAttribute("userid", 3);
        if((request.getSession().getAttribute("userid")!=null) && checkifRegisteredUser(request,(int)request.getSession().getAttribute("userid"))){
        request.setAttribute("redirect_URL", Setup.GOOGLE_AUTH_URL);
        User user =userService.finduserById((int)request.getSession().getAttribute("userid"));
        if(helperClass.checkIfUserIsChair(user) || helperClass.checkIfUserIsDean(user) || helperClass.checkIfUserIsProvost(user))request.setAttribute("isAdmin", "ADMIN");
        return new ModelAndView("landingPage");
        }
        return new ModelAndView("redirect:/logInPage.html");
    }

    @RequestMapping("/ordertextbook")
    public ModelAndView OrderTextbookPage(HttpServletRequest request){

        logger.info("Clicked order textbook button");
        request.setAttribute("page", "PAGE_ORDERTEXTBOOK");
        if((request.getSession().getAttribute("userid")!=null) && checkifRegisteredUser(request,(int)request.getSession().getAttribute("userid"))){
        	User user =userService.finduserById((int)request.getSession().getAttribute("userid"));
            if(helperClass.checkIfUserIsChair(user) || helperClass.checkIfUserIsDean(user) || helperClass.checkIfUserIsProvost(user))request.setAttribute("isAdmin", "ADMIN");
        	request.setAttribute("redirect_URL", Setup.GOOGLE_AUTH_URL);
        request.setAttribute("user",userService.finduserById((int)request.getSession().getAttribute("userid")));
        request.setAttribute("courses",courseService.findAll() );
        request.setAttribute("textbooks",textbookService.findAll() );
        request.setAttribute("terms",termService.findAll() );

        return new ModelAndView("landingPage");
        }
        return new ModelAndView("redirect:/logInPage.html");
    }



    @RequestMapping("/create-order")
    public ModelAndView CreateTextbookAndPlaceOrder(HttpServletRequest request){
        int i=0;
        Textbook textbook=null;
        ClassOrder classOrder = null ;
        List<Textbook> textbooks = new ArrayList<Textbook>();
        User currentUser =null;

        if((request.getSession().getAttribute("userid")!=null) && checkifRegisteredUser(request,(int)request.getSession().getAttribute("userid"))){

        if(Boolean.parseBoolean(request.getParameter("textbookRequired"))){


        while (request.getParameter("title"+i)!=null){
            textbook =new Textbook();
            textbook.setTitle((String) request.getParameter("title"+i));
            textbook.setAuthor((String) request.getParameter("author"+i));
            textbook.setEdition((String) request.getParameter("edition"+i));
            textbook.setCopyright((String) request.getParameter("copyright"+i));
            textbook.setPublisher((String) request.getParameter("publisher"+i));
            textbook.setIsbn((String) request.getParameter("isbn"+i));
            textbook.setIscoderequired((boolean) Boolean.parseBoolean(request.getParameter("iscoderequired"+i)));
            textbook.setIsebooksok((boolean) Boolean.parseBoolean(request.getParameter("isebooksok"+i)));
            textbook = textbookService.save(textbook);
            logger.debug("Created Textbook : " +textbook.getTextbook_id());
            textbooks.add(textbook);


            i++;
        }
        }

        //set order
        Order order =new Order();
        currentUser= userService.finduserById((int)request.getSession().getAttribute("userid"));
       order.setUser(currentUser);
        order.setTerm(termService.findtermById(Integer.parseInt(request.getParameter("term"))));
        order.setComments("sdsd");
       order.setStatus(status.chair.toString());
        order.setIstextusedlater("No");
        order.setOrderdate(new Date());
        order= orderService.save(order);
        logger.debug("Created Order : " +order.getOrder_id());
        //Create class_order with each textbook and order_id
        logger.debug("Number of textbooks present: "+textbooks.size());
        Course course = courseService.findCourseById(Integer.parseInt(request.getParameter("course")));
        for(int orderTextBook =0; orderTextBook<textbooks.size();orderTextBook++){
        	classOrder =new ClassOrder();
        	classOrder.setComments("sdsdsd");
        	 classOrder.setCourse(course);
        	 classOrder.setOrder(order);
        	 classOrder.setTextbook(textbooks.get(orderTextBook));
        	 classOrder = classOrderService.save(classOrder);
        	 logger.debug("Created class_order : " +classOrder.getClass_order_id());
        }

        logger.info("Clicked order textbook button");


        request.setAttribute("redirect_URL", Setup.GOOGLE_AUTH_URL);
        request.setAttribute("user",userService.finduserById((int)request.getSession().getAttribute("userid")));
        request.setAttribute("courses",courseService.findAll() );
        try {
        	//get department chair person address and name for sending the mail.

        	User departmentChair = (userService.finduserByDepartmentAndRole(currentUser.getDepartment(), role.chair.toString()).get(0));


			mailingConfig.sendEmail(departmentChair.getFirstname()+departmentChair.getLastname(),departmentChair.getEmailid(),"Textbook order waiting for your approval",course.getClassname(),currentUser.getFirstname()+currentUser.getLastname());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new ModelAndView("redirect:/orderstatus");
        }
//        request.setAttribute("page", "PAGE_ORDERSTATUS");
        return new ModelAndView("redirect:/logInPage.html");
    }






    @RequestMapping("/orderstatus")
    public ModelAndView OrderStatus(HttpServletRequest request){

        logger.info("Clicked order status button");
        request.setAttribute("page", "PAGE_ORDERSTATUS");
        if((request.getSession().getAttribute("userid")!=null) && checkifRegisteredUser(request,(int)request.getSession().getAttribute("userid"))){

        	User user =userService.finduserById((int)request.getSession().getAttribute("userid"));
            if(helperClass.checkIfUserIsChair(user) || helperClass.checkIfUserIsDean(user) || helperClass.checkIfUserIsProvost(user))request.setAttribute("isAdmin", "ADMIN");
        request.setAttribute("redirect_URL", Setup.GOOGLE_AUTH_URL);
        request.setAttribute("user",userService.finduserById((int)request.getSession().getAttribute("userid")));
        request.setAttribute("orders",orderService.findAllByUser(userService.finduserById((int)request.getSession().getAttribute("userid"))));
        return new ModelAndView("landingPage");
        }
        return new ModelAndView("redirect:/logInPage.html");
    }

    @RequestMapping("/approvals")
    public ModelAndView Approvals(HttpServletRequest request){

        logger.info("Clicked approvals button");
        request.setAttribute("page", "PAGE_APPROVALS");
        if((request.getSession().getAttribute("userid")!=null) && checkifRegisteredUser(request,(int)request.getSession().getAttribute("userid"))){
        	User user =userService.finduserById((int)request.getSession().getAttribute("userid"));
      if(helperClass.checkIfUserIsChair(user) || helperClass.checkIfUserIsDean(user) || helperClass.checkIfUserIsProvost(user))request.setAttribute("isAdmin", "ADMIN");
      request.setAttribute("user",userService.finduserById((int)request.getSession().getAttribute("userid")));
      request.setAttribute("orders", orderService.findUserByDepartmentAndUserRole(user.getDepartment().getDepartment_id(),user.getRole()));

        	request.setAttribute("redirect_URL", Setup.GOOGLE_AUTH_URL);
        return new ModelAndView("landingPage");
        }
        return new ModelAndView("redirect:/logInPage.html");
    }

    @RequestMapping("/profile")
    public ModelAndView Profile(HttpServletRequest request){

        logger.info("Clicked profile button");
        request.setAttribute("page", "PAGE_PROFILE");
        if((request.getSession().getAttribute("userid")!=null) && checkifRegisteredUser(request,(int)request.getSession().getAttribute("userid"))){

        	User user =userService.finduserById((int)request.getSession().getAttribute("userid"));
            if(helperClass.checkIfUserIsChair(user) || helperClass.checkIfUserIsDean(user) || helperClass.checkIfUserIsProvost(user))request.setAttribute("isAdmin", "ADMIN");

        	request.setAttribute("redirect_URL", Setup.GOOGLE_AUTH_URL);
        return new ModelAndView("landingPage");
        }
        return new ModelAndView("redirect:/logInPage.html");
    }


    private boolean checkifRegisteredUser(HttpServletRequest request,int userid) {

        logger.debug("checking the userid exists in session or not for :"+ userid);

        if (userService.finduserById(userid) == null) {
            logger.debug("userid does not exist returning false as user session expired ");
            //return false;
            request.getSession().setAttribute("userid", 3);
        }

        return true;


    }


    @RequestMapping("/log-out")
    public ModelAndView Logout(HttpServletRequest request){

        try {
            request.logout();

        request.getSession().invalidate();
        request.setAttribute("redirect_URL", Setup.GOOGLE_AUTH_URL);
        request.getSession().removeAttribute("userid");
        logger.debug("logging out so setting userid to null in session variable :"+ request.getSession().getAttribute("userid"));

        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ModelAndView("loginPage");
    }


    @RequestMapping("/firstLoginData.html")
    public ModelAndView FirstLoginData(HttpServletRequest request){

        if ((String) request.getAttribute("email")!=null){
        request.setAttribute("mode", "MODE_TASKS");
        User user=new User();
        user.setEmailid((String) request.getAttribute("email"));
        user.setFirstname((String) request.getAttribute("name"));
        request.setAttribute("departments",departmentService.findAll() );
        request.setAttribute("user", user);
        return new ModelAndView("firstLoginData");
        }
        return new ModelAndView("redirect:/logInPage.html");
    }


    @RequestMapping("/save-user")
    public ModelAndView saveUser(@ModelAttribute User user,BindingResult bindingResult,HttpServletRequest request){
        request.getAttribute("department");

        User savedUser= userService.save(user);
        request.getSession().setAttribute("userid", savedUser.getUser_id());
//		request.setAttribute("mode", "MODE_TASKS");
//		request.setAttribute("tasks", taskService.findAll());
        return new ModelAndView("redirect:/landingPage.html");
    }


    @RequestMapping("/index.html")
    public ModelAndView secondPage(HttpServletRequest request){
        request.setAttribute("mode", "MODE_HOME");

        request.setAttribute("redirect_URL", Setup.GOOGLE_AUTH_URL);
        return new ModelAndView("index");
    }

    @RequestMapping("/all-tasks")
    public ModelAndView allTasks(HttpServletRequest request){
        request.setAttribute("mode", "MODE_TASKS");
        request.setAttribute("tasks", taskService.findAll());
        return new ModelAndView("index");
    }

    @RequestMapping("/new-task")
    public ModelAndView newTask(HttpServletRequest request){
        request.setAttribute("mode", "MODE_NEW");
        request.setAttribute("tasks", taskService.findAll());
        return new ModelAndView("index");
    }

    @RequestMapping("/save-task")
    public ModelAndView saveTask(@ModelAttribute Task task,BindingResult bindingResult,HttpServletRequest request){
        task.setDateCreated(new Date());
        taskService.save(task);
        request.setAttribute("mode", "MODE_TASKS");
        request.setAttribute("tasks", taskService.findAll());
        return new ModelAndView("index");
    }

    @RequestMapping("/update-task")
    public ModelAndView updateTask(@RequestParam int id,HttpServletRequest request){
        request.setAttribute("task", taskService.findTask(id));
        request.setAttribute("mode", "MODE_UPDATE");
        return new ModelAndView("index");
    }


    @RequestMapping("/update-order")
    public ModelAndView updateOrder(@RequestParam int id, @RequestParam String userRole,HttpServletRequest request){
        helperClass.approveOrder(id, userRole);
       
        
        
        return new ModelAndView("redirect:/approvals");
    }
    @RequestMapping("/delete-task")
    public ModelAndView deleteTask(@RequestParam int id,HttpServletRequest request){
        taskService.delete(id);
        request.setAttribute("mode", "MODE_TASKS");
        request.setAttribute("tasks", taskService.findAll());
        return new ModelAndView("index");
    }

}
