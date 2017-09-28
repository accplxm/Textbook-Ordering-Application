package com.example.springStarter.Utility;

import javax.swing.JOptionPane;

public  class   helperClass {

	
	
public static void infoBox(String infoMessage,String titleBar){
	
	
	
	JOptionPane.showMessageDialog(null, infoMessage,"InfoBox: " + titleBar,JOptionPane.INFORMATION_MESSAGE);
}
	
}
