package com.example.springStarter.googleAuthorization;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.sendgrid.SendGridProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.example.springStarter.Constants.Setup;
import com.example.springStarter.model.Course;
import com.example.springStarter.model.Order;
import com.sendgrid.SendGrid;
import com.sendgrid.SendGrid.Email;

@Configuration
  public class MailingConfig {


	@Autowired
    private JavaMailSender sender;

    @Autowired
    private VelocityEngine velocityEngine;




    @Bean
    VelocityEngine velocityEngine(){
        Properties properties = new Properties();
        try {
			properties.load(this.getClass().getResourceAsStream("/application.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new VelocityEngine(properties);
    }

    @SuppressWarnings("deprecation")
	public void sendEmail(String userName, String sentToAddress, String Subject, String courseName,String instructor ) throws Exception {
        MimeMessage message = sender.createMimeMessage();
        SendGrid sendGrid = new SendGrid(Setup.SENDGRID_USERNAME,Setup.SENDGRID_PASSWORD);
        Email email = new Email();
        email.addTo(sentToAddress);
        email.addToName("HAri");
        email.setFrom("hariharih8@gmail.com");
        email.setSubject("Heello");
        email.setText("Try");
        sendGrid.send(email);

        MimeMessageHelper helper = new MimeMessageHelper(message);

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("user", userName);
        model.put("course", courseName);
        model.put("instructor", instructor);
        String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "emailVelocity.vm", model);

        helper.setTo(sentToAddress);
        helper.setText(text, true); // set to html
        helper.setSubject(Subject);

        sender.send(message);
    }


    @SuppressWarnings("deprecation")
 	public void deadlineEmail(String userName, String sentToAddress, String Subject,List<Order> orders,String semster,String deadlineDate ) throws Exception {
         MimeMessage message = sender.createMimeMessage();

         MimeMessageHelper helper = new MimeMessageHelper(message);

         Map<String, Object> model = new HashMap<String, Object>();
         model.put("user", userName);
//         model.put("courses", courses);
         model.put("deadlinedate", deadlineDate);
         model.put("semestername", semster);
         model.put("orders", orders);
         String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "deadlineMail.vm", model);

         helper.setTo(sentToAddress);
         helper.setText(text, true); // set to html
         helper.setSubject(Subject);


         sender.send(message);

     }


    @SuppressWarnings("deprecation")
   	public void sendMailToDean(String userName, String sentToAddress, String Subject,String instructor ) throws Exception {
           MimeMessage message = sender.createMimeMessage();
           SendGrid sendGrid = new SendGrid(Setup.SENDGRID_USERNAME,Setup.SENDGRID_PASSWORD);
           Email email = new Email();
           email.addTo(sentToAddress);
           email.addToName("HAri");
           email.setFrom("hariharih8@gmail.com");
           email.setSubject("Heello");
           email.setText("Try");
           sendGrid.send(email);
           MimeMessageHelper helper = new MimeMessageHelper(message);

           Map<String, Object> model = new HashMap<String, Object>();
           model.put("user", userName);
//           model.put("course", courseName);
           model.put("instructor", instructor);
           String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "MailToDean.vm", model);

           helper.setTo(sentToAddress);
           helper.setText(text, true); // set to html
           helper.setSubject(Subject);

           sender.send(message);
       }

    @SuppressWarnings("deprecation")
   	public void sendMailToProvost(String userName, String sentToAddress, String Subject,String instructor ) throws Exception {
           MimeMessage message = sender.createMimeMessage();

           MimeMessageHelper helper = new MimeMessageHelper(message);

           Map<String, Object> model = new HashMap<String, Object>();
           model.put("user", userName);
//           model.put("course", courseName);
           model.put("instructor", instructor);
           String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "MailToProvost.vm", model);

           helper.setTo(sentToAddress);
           helper.setText(text, true); // set to html
           helper.setSubject(Subject);

           sender.send(message);
       }

    @SuppressWarnings("deprecation")
   	public void sendRejectionMail(String rejectioncooments,String userName, String sentToAddress, String Subject,String instructor,String rejectedPersonName,String courseName,String role ) throws Exception {
           MimeMessage message = sender.createMimeMessage();

           MimeMessageHelper helper = new MimeMessageHelper(message);

           Map<String, Object> model = new HashMap<String, Object>();
           model.put("user", userName);
        model.put("course", courseName);
           model.put("instructor", instructor);
           model.put("role", role);
           model.put("rejectedPersonName", instructor);
           model.put("rejectioncomments", rejectioncooments);
           String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "rejectionMail.vm", model);

           helper.setTo(sentToAddress);
           helper.setText(text, true); // set to html
           helper.setSubject(Subject);

           sender.send(message);
       }

  }
