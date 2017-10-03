package com.example.springStarter.googleAuthorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.springStarter.TestController;
import com.example.springStarter.Constants.Setup;
import com.example.springStarter.model.User;
import com.example.springStarter.service.DepartmentService;
import com.example.springStarter.service.UserService;
import com.google.gson.Gson;



@RestController
@RequestMapping("/oauth2callback")
public class OAuth2Callback
  extends HttpServlet
{

	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
  private static final long serialVersionUID = 1L;
  static String className = "com.sl.Oauth2callback";
  ModelMap model;
  @Autowired
	public UserService userService;
  @Autowired
	public DepartmentService departmentService;


  @RequestMapping(method=RequestMethod.GET)
  protected ModelAndView get(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    try
    {
      String code = request.getParameter("code");
      String urlParameters = "code=" +
        code +
        "&client_id=" + Setup.CLIENT_ID +
        "&client_secret=" + Setup.CLIENT_SECRET +
        "&redirect_uri=" + Setup.REDIRECT_URL +
        "&grant_type=authorization_code";
      URL url = new URL("https://accounts.google.com/o/oauth2/token");
      URLConnection conn = url.openConnection();
      conn.setDoOutput(true);
      OutputStreamWriter writer = new OutputStreamWriter(
        conn.getOutputStream());
      writer.write(urlParameters);
      writer.flush();
      String line1 = "";
      BufferedReader reader = new BufferedReader(new InputStreamReader(
        conn.getInputStream()));
      String line;
      while ((line = reader.readLine()) != null)
      {
        line1 = line1 + line;
      }
      String s = GsonUtility.getJsonElementString("access_token", line1);

      url = new URL(
        "https://www.googleapis.com/oauth2/v1/userinfo?access_token=" +
        s);
      conn = url.openConnection();
      line1 = "";
      reader = new BufferedReader(new InputStreamReader(
        conn.getInputStream()));
      while ((line = reader.readLine()) != null) {
        line1 = line1 + line;
      }
      GooglePojo data = (GooglePojo)new Gson().fromJson(line1, GooglePojo.class);
      writer.close();
      reader.close();
      if(!(data.getEmail().split("@")[1].equals("murraystate.edu"))){

    	  //JOptionPane.showMessageDialog(null, "Invalid log-in user.\\n Have to be logged in only using 'murraystate.edu' mail-Id");
    	  //helperClass.infoBox("Invalid log-in user.\\n Have to be logged in only using 'murraystate.edu' mail-Id", "Invalid Log-In");
    	  //model.addAttribute("attribute","redirectWithRedirectPrefix");
    	  TestController.isInvalidLogIn=true;
    	  request.setAttribute("isInvalidLogIn", true);
    	  return new ModelAndView("forward:/logInPage.html");
      }else{

      request.setAttribute("auth", data);
      //model.addAttribute("attribute","redirectWithRedirectPrefix");
      request.setAttribute("googleAuthData", data);

      java.util.List<User> users = userService.finduserByEmail(data.getEmail());
      if (users.isEmpty()){

    	  request.setAttribute("email", data.getEmail());
    	  request.setAttribute("name", data.getGiven_name());

    	  return new ModelAndView("forward:/firstLoginData.html");

      }else{

    	  logger.info("The Userid retrieved and set for session variable is :"+ users.get(0).getUser_id());
    	  request.getSession().setAttribute("userid", users.get(0).getUser_id());


	  return new ModelAndView("redirect:/landingPage.html");
      }
      }
     // request.getRequestDispatcher("/google.jsp").forward(request, response);
    }
    catch (MalformedURLException e)
    {
      e.printStackTrace();
    }
    catch (ProtocolException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
	return null;
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {}
}
