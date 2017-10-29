



function validateAddDepartmentForm() {

	var valid= true;
	var finalError="";
	var i =0;
	var isStillPresent=true;



			 if (document.adddepartmentform.elements["departmentname"].value == "" || !isNaN(document.adddepartmentform.elements["departmentname"].value)) {
				 finalError = finalError + "*Department Name field cannot be empty and numeric<br/>";
				 valid =false;
				 }



			 if (document.adddepartmentform.elements["department"].value == "" || !isNaN(document.adddepartmentform.elements["department"].value)) {
				 finalError = finalError + "*Department Abbreviation cannot be empty and numeric<br/>";
				 valid =false;
				 }



	 $("#error").html(finalError);

	  return valid;
	}
