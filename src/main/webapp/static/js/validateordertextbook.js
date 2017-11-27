



function validateOrderTextbookForm() {

	var valid= true;
	var finalError="";
	var patt = new RegExp("^([0-9]{10}||[0-9]{13})$");
	var i =0;
	var isStillPresent=true;


	if ($("#radio-textrequiredYes").is(":checked")) {

		while(isStillPresent){

		 if (finalError=="" && document.ordertextbookform.elements["title"+i] !== undefined) {

			 if (document.ordertextbookform.course.value == "---Select Course---") {
				 finalError = finalError + "*Select a Course<br/>";
				 valid =false;
				 }



			 if (document.ordertextbookform.elements["title"+i].value == "" || !isNaN(document.ordertextbookform.elements["title"+i].value)) {
				 finalError = finalError + "*Title field cannot be empty and numeric<br/>";
				 valid =false;
				 }



			 if (document.ordertextbookform.elements["author"+i].value == "" || !isNaN(document.ordertextbookform.elements["author"+i].value)) {
				 finalError = finalError + "*Author field cannot be empty and numeric<br/>";
				 valid =false;
				 }

			 if (document.ordertextbookform.elements["copyright"+i].value == "") {
				 finalError = finalError + "*Copyright field cannot be empty<br/>";
				 valid =false;
				 }

			 if (document.ordertextbookform.elements["edition"+i].value == "") {
				 finalError = finalError + "*Edition field cannot be empty<br/>";
				 valid =false;
				 }


			 if(!patt.test(document.ordertextbookform.elements["isbn"+i].value)){
				 finalError = finalError + "*ISBN field cannot be empty and can be 10 or 13 digits numeric value<br/>";
				 valid =false;
			 }
			 if(document.ordertextbookform.elements["publisher"+i].value == "" || !isNaN(document.ordertextbookform.elements["publisher"+i].value)){
				 finalError = finalError + "*Publisher field cannot be empty and numeric<br/>";
				 valid =false;
			 }



			 }else{
				 isStillPresent =false;
			 }


i++;
	}


	 $("#error").html(finalError);

	  return valid;
	}

    }

