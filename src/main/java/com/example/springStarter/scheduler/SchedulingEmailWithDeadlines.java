package com.example.springStarter.scheduler;

import java.time.Year;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.springStarter.googleAuthorization.MailingConfig;
import com.example.springStarter.model.Department;
import com.example.springStarter.model.Term;
import com.example.springStarter.model.User;
import com.example.springStarter.model.User.role;
import com.example.springStarter.service.CourseService;
import com.example.springStarter.service.DepartmentService;
import com.example.springStarter.service.OrderService;
import com.example.springStarter.service.TermService;
import com.example.springStarter.service.UserService;

@Component
public class SchedulingEmailWithDeadlines {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
    private TermService termService;
	@Autowired
	private MailingConfig mailingConfig;
	@Autowired
	private UserService userService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private CourseService courseService;

//Fall Semester --Deadline April 1st

	@Scheduled(cron = "${com.example.springStarter.textbookOrdering.fallDeadline.cronTime}")
	public void FallCronJob(){
	logger.info("entered the cron job for Fall Deadline Email");

	List<Department> departments = departmentService.findAll();

	for(Department department: departments){
		if(department.getDepartment_id()  == 2){

		 User departmentChair = (userService.finduserByDepartmentAndRole(department, role.chair.toString()).get(0));



		 Term term = termService.findtermsBySemesterAndYear(Year.now().getValue(), "FALL").get(0);
		 try {

if(departmentChair.getEmailsrequired()){

	mailingConfig.deadlineEmail(departmentChair.getFirstname()+ " " + departmentChair.getLastname(), departmentChair.getEmailid(), "Fall Deadline Coming Soon",orderService.findAllByTerm(term), "FALL "+ term.getYear(), "April 1st");
}	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}



	logger.info("Finished the cron job of sending deadline timing for FALL + "+ Year.now().getValue());

	}

	@Scheduled(cron = "${com.example.springStarter.textbookOrdering.fallDeadlineLast.cronTime}")
	public void FallLastCronJob(){
	logger.info("entered the cron job for Fall Last Day Deadline Email");

	List<Department> departments = departmentService.findAll();

	for(Department department: departments){
		if(department.getDepartment_id()  == 2){

		 User departmentChair = (userService.finduserByDepartmentAndRole(department, role.chair.toString()).get(0));



		 Term term = termService.findtermsBySemesterAndYear(Year.now().getValue(), "FALL").get(0);
		 try {


			 if(departmentChair.getEmailsrequired()){
			mailingConfig.deadlineEmail(departmentChair.getFirstname()+ " " + departmentChair.getLastname(), departmentChair.getEmailid(), "Fall Deadline Coming Soon",orderService.findAllByTerm(term), "FALL "+ term.getYear(), "April 1st");
		}
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}



	logger.info("Finished the cron job of sending deadline timing for FALL + "+ Year.now().getValue());

	}


//Winter Semster Deadline-  October -1st

	@Scheduled(cron = "${com.example.springStarter.textbookOrdering.winterDeadline.cronTime}")
	public void WinterCronJob(){
	logger.info("entered the cron job for Winter Deadline Email");

	List<Department> departments = departmentService.findAll();

	for(Department department: departments){
		if(department.getDepartment_id()  == 2){

		 User departmentChair = (userService.finduserByDepartmentAndRole(department, role.chair.toString()).get(0));



		 Term term = termService.findtermsBySemesterAndYear(Year.now().getValue(), "Winter").get(0);
		 try {

			 if(departmentChair.getEmailsrequired()){
			mailingConfig.deadlineEmail(departmentChair.getFirstname()+ " " + departmentChair.getLastname(), departmentChair.getEmailid(), "Winter Deadline Coming Soon",orderService.findAllByTerm(term), "WINTER "+ term.getYear(), "OCTOBER 1st");
		}}
			 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}



	logger.info("Finished the cron job of sending deadline timing for WINTER + "+ Year.now().getValue());

	}

	@Scheduled(cron = "${com.example.springStarter.textbookOrdering.winterDeadlineLast.cronTime}")
	public void WinterLastCronJob(){
	logger.info("entered the cron job for Winter Last Day Deadline Email");

	List<Department> departments = departmentService.findAll();

	for(Department department: departments){
		if(department.getDepartment_id()  == 2){

		 User departmentChair = (userService.finduserByDepartmentAndRole(department, role.chair.toString()).get(0));



		 Term term = termService.findtermsBySemesterAndYear(Year.now().getValue(), "Winter").get(0);
		 try {

			 if(departmentChair.getEmailsrequired()){
			mailingConfig.deadlineEmail(departmentChair.getFirstname()+ " " + departmentChair.getLastname(), departmentChair.getEmailid(), "Winter Deadline Coming Soon",orderService.findAllByTerm(term), "Winter "+ term.getYear(), "October 1st");
		}
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}



	logger.info("Finished the cron job of sending deadline timing for Winter + "+ Year.now().getValue());

	}


	//Spring Semster Deadline-  October -15st

		@Scheduled(cron = "${com.example.springStarter.textbookOrdering.springDeadline.cronTime}")
		public void SpringCronJob(){
		logger.info("entered the cron job for Spring Deadline Email");

		List<Department> departments = departmentService.findAll();

		for(Department department: departments){
			if(department.getDepartment_id()  == 2){

			 User departmentChair = (userService.finduserByDepartmentAndRole(department, role.chair.toString()).get(0));



			 Term term = termService.findtermsBySemesterAndYear(Year.now().getValue(), "Spring").get(0);
			 try {

				 if(departmentChair.getEmailsrequired()){
				mailingConfig.deadlineEmail(departmentChair.getFirstname()+ " " + departmentChair.getLastname(), departmentChair.getEmailid(), "Spring Deadline Coming Soon",orderService.findAllByTerm(term), "SPRING "+ term.getYear(), "OCTOBER 15st");
			}
			 }catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}



		logger.info("Finished the cron job of sending deadline timing for Spring + "+ Year.now().getValue());

		}

		@Scheduled(cron = "${com.example.springStarter.textbookOrdering.springDeadlineLast.cronTime}")
		public void SpringLastCronJob(){
		logger.info("entered the cron job for Spring Deadline Email");

		List<Department> departments = departmentService.findAll();

		for(Department department: departments){
			if(department.getDepartment_id()  == 2){

			 User departmentChair = (userService.finduserByDepartmentAndRole(department, role.chair.toString()).get(0));



			 Term term = termService.findtermsBySemesterAndYear(Year.now().getValue(), "Spring").get(0);
			 try {

				 if(departmentChair.getEmailsrequired()){
				mailingConfig.deadlineEmail(departmentChair.getFirstname()+ " " + departmentChair.getLastname(), departmentChair.getEmailid(), "Spring Deadline Coming Soon",orderService.findAllByTerm(term), "SPRING "+ term.getYear(), "OCTOBER 15st");
			}
			 }catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}



		logger.info("Finished the cron job of sending deadline timing for Spring + "+ Year.now().getValue());

		}

		//Summer Semster Deadline-  March -10th

			@Scheduled(cron = "${com.example.springStarter.textbookOrdering.summerDeadline.cronTime}")
			public void SummerCronJob(){
			logger.info("entered the cron job for Summer Deadline Email");

			List<Department> departments = departmentService.findAll();

			for(Department department: departments){
				if(department.getDepartment_id()  == 2){

				 User departmentChair = (userService.finduserByDepartmentAndRole(department, role.chair.toString()).get(0));



				 Term term = termService.findtermsBySemesterAndYear(Year.now().getValue(), "Summer").get(0);
				 try {

					 if(departmentChair.getEmailsrequired()){
					mailingConfig.deadlineEmail(departmentChair.getFirstname()+ " " + departmentChair.getLastname(), departmentChair.getEmailid(), "Summer Deadline Coming Soon",orderService.findAllByTerm(term), "Summer "+ term.getYear(), "MARCH 10th");

					 }} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}



			logger.info("Finished the cron job of sending deadline timing for Summer + "+ Year.now().getValue());

			}


			@Scheduled(cron = "${com.example.springStarter.textbookOrdering.summerDeadlineLast.cronTime}")
			public void SummerLastCronJob(){
			logger.info("entered the cron job for Summer Last Day Deadline Email");

			List<Department> departments = departmentService.findAll();

			for(Department department: departments){
				if(department.getDepartment_id()  == 2){

				 User departmentChair = (userService.finduserByDepartmentAndRole(department, role.chair.toString()).get(0));



				 Term term = termService.findtermsBySemesterAndYear(Year.now().getValue(), "Summer").get(0);
				 try {

					 if(departmentChair.getEmailsrequired()){
					mailingConfig.deadlineEmail(departmentChair.getFirstname()+ " " + departmentChair.getLastname(), departmentChair.getEmailid(), "Summer Deadline Coming Soon",orderService.findAllByTerm(term), "Summer "+ term.getYear(), "MARCH 10th");
				}}
					 catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}



			logger.info("Finished the cron job of sending deadline timing for Summer + "+ Year.now().getValue());

			}



}

