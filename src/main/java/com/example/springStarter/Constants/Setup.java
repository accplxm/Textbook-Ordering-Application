package com.example.springStarter.Constants;

public  final class Setup {
  public static final String CLIENT_ID = "1057193750796-g5f00lio8es15uulbfq4rs864a34nmsn.apps.googleusercontent.com";
  public static final String CLIENT_SECRET = "LQZYvwxVAR4psGsq77FURmng";
  public static final String REDIRECT_URL = "https://textbook-ordering-application.herokuapp.com/oauth2callback";
  public static final String GOOGLE_AUTH_URL="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri="+REDIRECT_URL+"&response_type=code&client_id="+CLIENT_ID+"&approval_prompt=force";
  public static final String SENDGRID_USERNAME = "app79996334@heroku.com";
  public static final String SENDGRID_PASSWORD = "oqdadj3k3024";

}
