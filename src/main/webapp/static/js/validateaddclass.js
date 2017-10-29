



function validateAddClassForm() {

	var valid= true;
	var finalError="";
	var i =0;
	var isStillPresent=true;



			 if (document.addclassform.elements["classname"].value == "" || !isNaN(document.addclassform.elements["classname"].value)) {
				 finalError = finalError + "*Class Name field cannot be empty and numeric<br/>";
				 valid =false;
				 }



			 if (document.addclassform.elements["class"].value == "" || !isNaN(document.addclassform.elements["class"].value)) {
				 finalError = finalError + "*Class Abbreviation cannot be empty and numeric<br/>";
				 valid =false;
				 }



	 $("#error").html(finalError);

	  return valid;
	}
