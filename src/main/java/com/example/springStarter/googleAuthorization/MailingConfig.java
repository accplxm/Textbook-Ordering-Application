package com.example.springStarter.googleAuthorization;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

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
   	public void sendMailToDean(String userName, String sentToAddress, String Subject,String instructor ) throws Exception {
           MimeMessage message = sender.createMimeMessage();

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

  }
