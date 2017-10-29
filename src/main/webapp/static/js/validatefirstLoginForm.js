



function validateFirstLoginDataForm() {

	var valid= true;
	var finalError="";

	 if (document.firstLoginDataForm.initials.value == "" || !isNaN(document.firstLoginDataForm.initials.value)) {

	 finalError = "* Intitials field cannot be null and numeric<br/>";

		 valid =false;

	 }
	 if (document.firstLoginDataForm.firstname.value == ""|| !isNaN(document.firstLoginDataForm.firstname.value)) {
		 finalError = finalError + "* First name field cannot be empty and numeric<br/>";
		 valid =false;
		 }
	 if (document.firstLoginDataForm.lastname.value == ""|| !isNaN(document.firstLoginDataForm.lastname.value)) {
		 finalError = finalError + "* Last name field cannot be empty and numeric<br/>";
		 valid =false;
		 }

	 if (! $("#authorize").is(":checked")) {
		 finalError = finalError + "* Authorize initials to continue<br/>";
		 valid =false;
		 }

	 $("#error").html(finalError);

	  return valid;


    }

