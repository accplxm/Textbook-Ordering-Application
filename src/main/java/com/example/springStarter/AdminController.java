package com.example.springStarter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
import com.example.springStarter.model.Department;
import com.example.springStarter.model.Order;
import com.example.springStarter.model.Order.status;
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
public class AdminController {




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

    @Autowired
    private TestController testController;





     private final Logger logger = LoggerFactory.getLogger(this.getClass());






     @RequestMapping("/admin")
     public ModelAndView Admin(HttpServletRequest request){

         logger.info("Clicked admin button");
         request.setAttribute("page", "PAGE_ADMIN");
         if((request.getSession().getAttribute("userid")!=null) && testController.checkifRegisteredUser(request,(int)request.getSession().getAttribute("userid"))){

             User user =userService.finduserById((int)request.getSession().getAttribute("userid"));
             helperClass.setRequestVariablesForAdmin(user,request);
             //if(helperClass.checkIfUserIsChair(user) || helperClass.checkIfUserIsDean(user) || helperClass.checkIfUserIsProvost(user))request.setAttribute("isAdmin", "ADMIN");

             request.setAttribute("user", user);request.setAttribute("redirect_URL", Setup.GOOGLE_AUTH_URL);
         return new ModelAndView("landingPage");
         }
         return new ModelAndView("redirect:/logInPage.html");
     }





     @RequestMapping("/updateuser")
     public ModelAndView UpdateUser(HttpServletRequest request){

         logger.info("Clicked update user hyper link");
         request.setAttribute("page", "PAGE_USERUPDATE");
         if((request.getSession().getAttribute("userid")!=null) && testController.checkifRegisteredUser(request,(int)request.getSession().getAttribute("userid"))){

             User user =userService.finduserById((int)request.getSession().getAttribute("userid"));
             if(user.getIsadmin()){
             helperClass.setRequestVariablesForAdmin(user,request);
             List<String> roles = new ArrayList<String>();
             for(int i=0;i<role.values().length;i++){
             roles.add(role.values()[i].toString());
             }
             request.setAttribute("roles", roles);
             request.setAttribute("users", userService.findAll());
             //if(helperClass.checkIfUserIsChair(user) || helperClass.checkIfUserIsDean(user) || helperClass.checkIfUserIsProvost(user))request.setAttribute("isAdmin", "ADMIN");

             request.setAttribute("user", user);request.setAttribute("redirect_URL", Setup.GOOGLE_AUTH_URL);
         return new ModelAndView("updateuserconfiguration");
             }
         }
         return new ModelAndView("redirect:/logInPage.html");
     }


     @RequestMapping("/updateuserroles")
     public ModelAndView UpdateUserROles(HttpServletRequest request){

         logger.info("Clicked update user role submitted link");
         request.setAttribute("page", "PAGE_USERROLEUPDATE");
         if((request.getSession().getAttribute("userid")!=null) && testController.checkifRegisteredUser(request,(int)request.getSession().getAttribute("userid"))){

             User user =userService.finduserById((int)request.getSession().getAttribute("userid"));
             if(user.getIsadmin()){
             helperClass.setRequestVariablesForAdmin(user,request);
             List<String> roles = new ArrayList<String>();
             for(int i=0;i<role.values().length;i++){
             roles.add(role.values()[i].toString());
             }
             request.setAttribute("roles", roles);
             request.setAttribute("users", userService.findAll());

             //save user
             User selectedUser = userService.finduserById(Integer.parseInt(request.getParameter("user")));
             selectedUser.setRole((String) request.getParameter("role"));
             selectedUser.setIsadmin(Boolean.parseBoolean(request.getParameter("isadmin")));
            selectedUser= userService.save(selectedUser);

            request.setAttribute("status", "User '"+selectedUser.getFirstname()+" "+ selectedUser.getLastname() + "' is updated to role '"+ selectedUser.getRole()+"' ");

             //if(helperClass.checkIfUserIsChair(user) || helperClass.checkIfUserIsDean(user) || helperClass.checkIfUserIsProvost(user))request.setAttribute("isAdmin", "ADMIN");

             request.setAttribute("user", user);request.setAttribute("redirect_URL", Setup.GOOGLE_AUTH_URL);
         return new ModelAndView("updateuserconfiguration");
             }
         }
         return new ModelAndView("redirect:/logInPage.html");
     }

     //add department


     @RequestMapping("/adddepartment")
     public ModelAndView AddDepartment(HttpServletRequest request){

         logger.info("Clicked add department hyper link");
         request.setAttribute("page", "PAGE_ADDDEPARTMENT");
         if((request.getSession().getAttribute("userid")!=null) && testController.checkifRegisteredUser(request,(int)request.getSession().getAttribute("userid"))){

             User user =userService.finduserById((int)request.getSession().getAttribute("userid"));
             if(user.getIsadmin()){
             helperClass.setRequestVariablesForAdmin(user,request);

             request.setAttribute("user", user);request.setAttribute("redirect_URL", Setup.GOOGLE_AUTH_URL);
         return new ModelAndView("adddepartment");
             }
         }
         return new ModelAndView("redirect:/logInPage.html");
     }


     @RequestMapping("/adddepartmentform")
     public ModelAndView AddDepartmentForm(HttpServletRequest request){

         logger.info("Clicked add department form submitted link");
         request.setAttribute("page", "PAGE_ADDDEPARTMENT");
         if((request.getSession().getAttribute("userid")!=null) && testController.checkifRegisteredUser(request,(int)request.getSession().getAttribute("userid"))){

             User user =userService.finduserById((int)request.getSession().getAttribute("userid"));
             if(user.getIsadmin()){
             helperClass.setRequestVariablesForAdmin(user,request);

             Department department =new Department();
             department.setDepartment(request.getParameter("department"));
             department.setDepartmentname(request.getParameter("departmentname"));
             department=departmentService.save(department);


            request.setAttribute("status", "Department '"+ department.getDepartment() + "' is added succesfully");

             //if(helperClass.checkIfUserIsChair(user) || helperClass.checkIfUserIsDean(user) || helperClass.checkIfUserIsProvost(user))request.setAttribute("isAdmin", "ADMIN");

             request.setAttribute("user", user);request.setAttribute("redirect_URL", Setup.GOOGLE_AUTH_URL);
         return new ModelAndView("adddepartment");
             }
         }
         return new ModelAndView("redirect:/logInPage.html");
     }





     //add class


     @RequestMapping("/addclass")
     public ModelAndView AddClass(HttpServletRequest request){

         logger.info("Clicked add class hyper link");
         request.setAttribute("page", "PAGE_ADDCLASS");
         if((request.getSession().getAttribute("userid")!=null) && testController.checkifRegisteredUser(request,(int)request.getSession().getAttribute("userid"))){

             User user =userService.finduserById((int)request.getSession().getAttribute("userid"));
             if(user.getIsadmin()){
             helperClass.setRequestVariablesForAdmin(user,request);
             request.setAttribute("departments", departmentService.findAll());

             request.setAttribute("user", user);request.setAttribute("redirect_URL", Setup.GOOGLE_AUTH_URL);
         return new ModelAndView("addclass");
             }
         }
         return new ModelAndView("redirect:/logInPage.html");
     }


     @RequestMapping("/addclassform")
     public ModelAndView AddClassForm(HttpServletRequest request){

         logger.info("Clicked add class form submitted link");
         request.setAttribute("page", "PAGE_ADDCLASS");
         if((request.getSession().getAttribute("userid")!=null) && testController.checkifRegisteredUser(request,(int)request.getSession().getAttribute("userid"))){

             User user =userService.finduserById((int)request.getSession().getAttribute("userid"));
             if(user.getIsadmin()){
             helperClass.setRequestVariablesForAdmin(user,request);
             request.setAttribute("departments", departmentService.findAll());

             Course course =new Course();
             course.setDepartment(departmentService.finddepartmentById(Integer.parseInt(request.getParameter("department"))));
             course.setClassname((request.getParameter("classname")));
             course.setCourseId((request.getParameter("class")));
             course= courseService.save(course);


            request.setAttribute("status", "Course '"+ course.getClassname() + "' is added succesfully");

             //if(helperClass.checkIfUserIsChair(user) || helperClass.checkIfUserIsDean(user) || helperClass.checkIfUserIsProvost(user))request.setAttribute("isAdmin", "ADMIN");

             request.setAttribute("user", user);request.setAttribute("redirect_URL", Setup.GOOGLE_AUTH_URL);
         return new ModelAndView("addclass");
             }
         }
         return new ModelAndView("redirect:/logInPage.html");
     }

     @RequestMapping("/reject-order")
     public ModelAndView updateOrder(HttpServletRequest request){
    	 boolean isFaculty=true;
    	 String rejectedTo = request.getParameter("role");
   	 if(rejectedTo.equalsIgnoreCase("chair")|| rejectedTo.equalsIgnoreCase("dean")||rejectedTo.equalsIgnoreCase("provost")){
   		isFaculty=false;
    	 }
         helperClass.rejectOrder(Integer.parseInt(request.getParameter("order_id")), request.getParameter("user_role"), isFaculty, request.getParameter("rejectioncomments"), rejectedTo);

         request.getParameter("department");

         return new ModelAndView("redirect:/approvals");
     }


     @RequestMapping("/checkorder")
     public ModelAndView finalApplication(@RequestParam int order,HttpServletRequest request){
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyy-mm-dd");

         logger.info("Clicked check order Application button");
         request.setAttribute("page", "PAGE_CHECKORDER");



         if((request.getSession().getAttribute("userid")!=null) && testController.checkifRegisteredUser(request,(int)request.getSession().getAttribute("userid"))){

             User user =userService.finduserById((int)request.getSession().getAttribute("userid"));
             helperClass.setRequestVariablesForAdmin(user,request);


             // get term and department

             Order orderRequested = orderService.findOrderById(order);

             request.setAttribute("order", orderRequested);
             request.setAttribute("textbooks", textbookService.findTextbooksByTermAndCourse(orderRequested.getTerm().getTerm_id(), orderRequested.getClassOrders().get(0).getCourse().getClass_id(), orderRequested.getOrder_id()));
            request.setAttribute("roles", helperClass.getRoles(user.getRole(), orderRequested.getUser().getFirstname() + " " + orderRequested.getUser().getLastname()  ));



             request.setAttribute("user", user);request.setAttribute("redirect_URL", Setup.GOOGLE_AUTH_URL);
         return new ModelAndView("checkorder");
         }
         return new ModelAndView("redirect:/logInPage.html");
     }


     @RequestMapping("/edit-order")
     public ModelAndView EditOrder(@RequestParam int id, @RequestParam String userRole,HttpServletRequest request){
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyy-mm-dd");

         logger.info("Clicked Edit order Application button");
         request.setAttribute("page", "PAGE_EDITORDER");



         if((request.getSession().getAttribute("userid")!=null) && testController.checkifRegisteredUser(request,(int)request.getSession().getAttribute("userid"))){

             User user =userService.finduserById((int)request.getSession().getAttribute("userid"));
             helperClass.setRequestVariablesForAdmin(user,request);


             // get term and department

             Order orderRequested = orderService.findOrderById(id);
             request.setAttribute("courses",courseService.findAll() );
             request.setAttribute("terms",termService.findAll() );
             request.setAttribute("order", orderRequested);
             List<Textbook> textbooks = textbookService.findTextbooksByTermAndCourse(orderRequested.getTerm().getTerm_id(), orderRequested.getClassOrders().get(0).getCourse().getClass_id(), orderRequested.getOrder_id());
             request.setAttribute("textbooks",textbooks);
            //request.setAttribute("roles", helperClass.getRoles(user.getRole(), orderRequested.getUser().getFirstname() + " " + orderRequested.getUser().getLastname()  ));


             if(textbooks.isEmpty()){
            	 request.setAttribute("textbookrequired", false);
             }else{
            	 request.setAttribute("textbookrequired", true);
             }



             request.setAttribute("user", user);request.setAttribute("redirect_URL", Setup.GOOGLE_AUTH_URL);
         return new ModelAndView("editorder");
         }
         return new ModelAndView("redirect:/logInPage.html");

     }



     @RequestMapping("/resubmit-order")
     public ModelAndView ResubmitOrder(HttpServletRequest request){
         int i=0;
         Textbook textbook=null;
         ClassOrder classOrder = null ;
         List<Textbook> textbooks = new ArrayList<Textbook>();
         User currentUser =null;
         Order order =orderService.findOrderById(Integer.parseInt(request.getParameter("order_id")));

         if((request.getSession().getAttribute("userid")!=null) && testController.checkifRegisteredUser(request,(int)request.getSession().getAttribute("userid"))){

         if(Boolean.parseBoolean(request.getParameter("textbookRequiredbool"))){


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
             textbook.setAcceptableeditions((String)request.getParameter("acceptableeditions"+i));
             List<Textbook> existingTextbooks=  textbookService.findAllByTitleAndAuthorAndCopyrightAndEditionAndIsbnAndPublisher(textbook.getTitle(), textbook.getAuthor(), textbook.getCopyright(), textbook.getEdition(), textbook.getIsbn(), textbook.getPublisher());
             if(existingTextbooks.size()>0){
             textbook= existingTextbooks.get(0);
             logger.debug("Textbook already present : " +textbook.getTextbook_id());
             }
             textbook = textbookService.save(textbook);
             logger.debug("Created Textbook : " +textbook.getTextbook_id());
             textbooks.add(textbook);


             i++;
         }
         }

         //set order
         currentUser= userService.finduserById((int)request.getSession().getAttribute("userid"));
        order.setUser(currentUser);
         order.setTerm(termService.findtermById(Integer.parseInt(request.getParameter("term"))));
         order.setComments(request.getParameter("ordercomments"));
        order.setStatus(status.chair.toString());
         order.setIstextusedlater(Boolean.parseBoolean(request.getParameter("textbookRequired")));
         //order.setOrderdate(new Date());
         order.setIsrejected(false);
         order= orderService.save(order);
         logger.debug("Resubmitting Order : " +order.getOrder_id());
         //Create class_order with each textbook and order_id
         logger.debug("Number of textbooks present: "+textbooks.size());
         Course course = courseService.findCourseById(Integer.parseInt(request.getParameter("course")));
         if(!(textbooks.size()>0)){
         textbooks.add(null);
         }
         for(int orderTextBook =0; orderTextBook<textbooks.size();orderTextBook++){
             classOrder =new ClassOrder();
             List<ClassOrder> existingclassOrders=  classOrderService.findAllByCourseAndOrderAndTextbook(course, order, textbooks.get(orderTextBook));
             if(existingclassOrders.size()>0){
            	 classOrder= existingclassOrders.get(0);
             logger.debug("Class ORder already present : " +classOrder.getClass_order_id());
             }

             classOrder.setComments("sdsdsd");
              classOrder.setCourse(course);
              classOrder.setOrder(order);
              classOrder.setTextbook(textbooks.get(orderTextBook));
              classOrder = classOrderService.save(classOrder);
              logger.debug("Recreated class_order : " +classOrder.getClass_order_id());
         }



         logger.info("Clicked order textbook button");


         request.setAttribute("user", currentUser);
         request.setAttribute("redirect_URL", Setup.GOOGLE_AUTH_URL);
         request.setAttribute("user",userService.finduserById((int)request.getSession().getAttribute("userid")));
         request.setAttribute("courses",courseService.findAll() );
         try {
             //get department chair person address and name for sending the mail.

             User departmentChair = (userService.finduserByDepartmentAndRole(currentUser.getDepartment(), role.chair.toString()).get(0));


             mailingConfig.sendEmail(departmentChair.getFirstname()+departmentChair.getLastname(),departmentChair.getEmailid(),"Textbook order resubmitted for approval",course.getClassname(),currentUser.getFirstname()+currentUser.getLastname());
         } catch (Exception e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         return new ModelAndView("redirect:/orderstatus");
         }
//         request.setAttribute("page", "PAGE_ORDERSTATUS");
         return new ModelAndView("redirect:/logInPage.html");
     }

     @RequestMapping("/devprofile")
     public ModelAndView DevProfile(HttpServletRequest request){

    	 request.setAttribute("page", "PAGE_DEVPROFILE");
         if((request.getSession().getAttribute("userid")!=null) && testController.checkifRegisteredUser(request,(int)request.getSession().getAttribute("userid"))){
         User user =userService.finduserById((int)request.getSession().getAttribute("userid"));
         helperClass.setRequestVariablesForAdmin(user,request);
         request.setAttribute("departments",departmentService.findAll() );
         request.setAttribute("user", user);request.setAttribute("redirect_URL", Setup.GOOGLE_AUTH_URL);
         return new ModelAndView("landingPage");
         }
         return new ModelAndView("redirect:/logInPage.html");
     }



     @RequestMapping("/profile")
     public ModelAndView Profile(HttpServletRequest request){

    	 request.setAttribute("page", "PAGE_PROFILE");
         if((request.getSession().getAttribute("userid")!=null) && testController.checkifRegisteredUser(request,(int)request.getSession().getAttribute("userid"))){
         User user =userService.finduserById((int)request.getSession().getAttribute("userid"));
         helperClass.setRequestVariablesForAdmin(user,request);
         request.setAttribute("departments",departmentService.findAll() );
         request.setAttribute("user", user);request.setAttribute("redirect_URL", Setup.GOOGLE_AUTH_URL);
         return new ModelAndView("landingPage");
         }
         return new ModelAndView("redirect:/logInPage.html");
     }




     @RequestMapping("/edit-profile")
     public ModelAndView FirstLoginData(@ModelAttribute User user,BindingResult bindingResult,HttpServletRequest request){

    	 request.setAttribute("page", "PAGE_PROFILE");
         if((request.getSession().getAttribute("userid")!=null) && testController.checkifRegisteredUser(request,(int)request.getSession().getAttribute("userid"))){
         User savinguser =userService.finduserById((int)request.getSession().getAttribute("userid"));
         request.setAttribute("departments",departmentService.findAll() );
         helperClass.setRequestVariablesForAdmin(user,request);
         request.setAttribute("user", user);
         user.setIsadmin(savinguser.getIsadmin());

         request.getAttribute("department");

        // user.setRole(role.faculty.toString());
         User savedUser= userService.save(user);

         request.setAttribute("status", "User '"+ savedUser.getFirstname()+ " " + savedUser.getLastname() + "' is updated succesfully");



         return new ModelAndView("landingPage");
         }
         return new ModelAndView("redirect:/logInPage.html");
     }




}
