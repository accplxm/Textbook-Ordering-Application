package com.example.springStarter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springStarter.googleAuthorization.MailingConfig;
import com.example.springStarter.model.Order;
import com.example.springStarter.model.Order.status;
import com.example.springStarter.model.User;
import com.example.springStarter.model.User.role;
import com.example.springStarter.service.OrderService;
import com.example.springStarter.service.UserService;


@Component
public class helperClass {


    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private MailingConfig mailingConfig;

private boolean checkIfUserIsChair(User user,HttpServletRequest request){

    if(user.getRole().equalsIgnoreCase(role.chair.toString())){
        setRequestVariables(request,false);
    return true;
    }
return false;


}

public void setRequestVariablesForAdmin(User user,HttpServletRequest request){
    checkIfUserIsDean(user,request);
    checkIfUserIsChair(user,request);
    checkIfUserIsProvost(user,request);

}

private boolean checkIfUserIsDean(User user,HttpServletRequest request){

    if(user.getRole().equalsIgnoreCase(role.dean.toString())){
        setRequestVariables(request,false);
    return true;
    }
return false;
}

public List<String> getRoles(String userRole,String orderedUser){
    List<String> roles  = new ArrayList<String>();
    roles.add(orderedUser);
    if(userRole.equalsIgnoreCase(status.dean.toString())){
        roles.add(status.chair.toString());
    }else if(userRole.equalsIgnoreCase(status.provost.toString())){
        roles.add(status.chair.toString());
        roles.add(status.dean.toString());
    }

    return roles;


}
private boolean checkIfUserIsProvost(User user,HttpServletRequest request){

    if(user.getRole().equalsIgnoreCase(role.provost.toString())){
        setRequestVariables(request,true);
    return true;
    }
return false;


}

private void setRequestVariables(HttpServletRequest request,boolean isProvost){

    request.setAttribute("isAdmin", "ADMIN");
    if(isProvost) request.setAttribute("isProvost", "PROVOST");

}

public boolean approveOrder(int orderId , String userRole){

    boolean isUpdated =false;
    Order order =null;
    switch(userRole) {
    case "chair":
        order = orderService.findOrderById(orderId);
        order.setStatus(status.dean.toString());
        order.setChairapproveddate(new Date());
        orderService.save(order);


        try {
            //get department dean person address and name for sending the mail.

            User departmentDean = (userService.finduserByDepartmentAndRole(order.getUser().getDepartment(), role.dean.toString()).get(0));


            mailingConfig.sendMailToDean(departmentDean.getFirstname()+departmentDean.getLastname(),departmentDean.getEmailid(),"Textbook order waiting for your approval",order.getUser().getFirstname()+order.getUser().getLastname());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        isUpdated =true;
        break;
    case "dean":
        order = orderService.findOrderById(orderId);
        order.setStatus(status.done.toString());
        order.setDeanapproveddate(new Date());
        orderService.save(order);

         try {
                //get department dean person address and name for sending the mail.

                User provost = (userService.finduserByDepartmentAndRole(order.getUser().getDepartment(), role.provost.toString()).get(0));


                mailingConfig.sendMailToProvost(provost.getFirstname()+provost.getLastname(),provost.getEmailid(),"Textbook order is Approved",order.getUser().getFirstname()+order.getUser().getLastname());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        isUpdated =true;

        break;

    }



    return isUpdated;

}

public boolean rejectOrder(int orderId , String userRole,boolean backToFaculty,String rejectionComments,String rejectedTo){

    boolean isUpdated =false;
    Order order =null;
    User rejectedToUser =null;

    order = orderService.findOrderById(orderId);
    User rejectedUser = (userService.finduserByDepartmentAndRole(order.getUser().getDepartment(), userRole).get(0));
    if(!backToFaculty){
    rejectedToUser = (userService.finduserByDepartmentAndRole(order.getUser().getDepartment(), rejectedTo).get(0));
    }
    User facultyOrdered= order.getUser();

    //order.setChairapproveddate(new Date());

    if(backToFaculty){
        order.setStatus(status.faculty.toString());
        order.setIsrejected(true);
        order.setRejectioncomments(rejectionComments);
        orderService.save(order);


        try {
            mailingConfig.sendRejectionMail(rejectionComments,facultyOrdered.getFirstname() +" " + facultyOrdered.getLastname(), facultyOrdered.getEmailid(), "Textbook Order Rejected", facultyOrdered.getFirstname() + " " + facultyOrdered.getLastname(), rejectedUser.getFirstname()+ " "+ rejectedUser.getLastname() , order.getClassOrders().get(0).getCourse().getClassname(),userRole);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        isUpdated =true;
    }else {

        order.setStatus(rejectedTo);
        order.setIsrejected(true);
        order.setRejectioncomments(rejectionComments);
        orderService.save(order);



        try {
            mailingConfig.sendRejectionMail(rejectionComments,rejectedToUser.getFirstname() +" " + rejectedToUser.getLastname(), rejectedToUser.getEmailid(), "Textbook Order Rejected", facultyOrdered.getFirstname() + " " + facultyOrdered.getLastname(), rejectedUser.getFirstname()+ " "+ rejectedUser.getLastname() , order.getClassOrders().get(0).getCourse().getClassname(),userRole);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        isUpdated =true;

    }



    return isUpdated;

}

}
