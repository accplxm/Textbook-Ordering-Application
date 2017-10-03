package com.example.springStarter;

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

public boolean checkIfUserIsChair(User user){

	if(user.getRole().equalsIgnoreCase(role.chair.toString())){

	return true;
	}
return false;


}

public boolean checkIfUserIsDean(User user){

	if(user.getRole().equalsIgnoreCase(role.dean.toString())){

	return true;
	}
return false;


}
public boolean checkIfUserIsProvost(User user){

	if(user.getRole().equalsIgnoreCase(role.provost.toString())){

	return true;
	}
return false;


}

public boolean approveOrder(int orderId , String userRole){

	boolean isUpdated =false;
	Order order =null;
	switch(userRole) {
	case "chair":
		order = orderService.findOrderById(orderId);
		order.setStatus(status.dean.toString());
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

}
