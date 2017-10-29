



function validateApprovedApplicationsForm() {

	var valid= true;
	var finalError="";
	var i =0;
	var isStillPresent=true;



			 if (document.approvedapplicationsform.term.value == "--Select Value ----" ) {
				 finalError = finalError + "*Select a term<br/>";
				 valid =false;
				 }



			 if (document.approvedapplicationsform.department.value == "--Select Value ----") {
				 finalError = finalError + "*Select a department<br/>";
				 valid =false;
				 }



	 $("#error").html(finalError);

	  return valid;
	}
