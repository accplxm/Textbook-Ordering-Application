<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>

<meta charset="utf-8">
<meta http-eqiv="X-UA-Compatible" content="IE-edge">
<meta http-eqiv="Pragma" content="no-cache">
<meta http-eqiv="Cache-Control" content="no-cache">
<meta http-eqiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">


<title>Textbook ordering application</title>

<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript"
	src="static/js/activeselection.js"></script>

	<script type="text/javascript"
	src="static/js/validatefirstLoginForm.js"></script>




</head>

<body>



	<div class="container text-center">
		<h3> Edit Profile of ${user.emailid} </h3>
		<c:if test="${not empty status}">
<h3 class="text-center text-primary"> ${status}</h3>
</c:if>

		<hr>
		<form class="form-horizontal" method="POST" action="edit-profile" name="firstLoginDataForm" onsubmit="return validateFirstLoginDataForm()">
			<input type="hidden" name="user_id" value="${user.user_id}" />
			<input type="hidden" name="isadmin" value="${user.isadmin}" />
			<input type="hidden" name="role" value="${user.role}" />
			<input type="hidden" name="emailid" value="${user.emailid}" />
			<label class="control-label" id= "error" style="color:red; font-size:20px; text-align: left;"></label>
			<div class="form-group">
			<label class="control-label col-md-3"> Select Department </label>
			<div class= "col-md-7">
			<select class ="form-control" name="department">
        <c:forEach var="department" items="${departments}">
            <option  value="${department.department_id}"   ${user.department.department_id == department.department_id ? 'selected' : ''}>
                <c:out value="${department.departmentname}"/>
            </option>
        </c:forEach>
    </select>
			</div>
			</div>

			<div class="form-group">
				<label class="control-label col-md-3"> Initials</label>

				<div class= "col-md-7">
				<input	type="text" class="form-control" name="initials" value="${user.initials}" />
			</div>
			</div>



			<div class="form-group">
				<label class="control-label col-md-3"> First Name</label>
				<div class= "col-md-7">
				 <input
					type="text" class="form-control" name="firstname"
					value="${user.firstname}" />
			</div>
			</div>


			<div class="form-group">
				<label class="control-label col-md-3"> Last Name</label>
				<div class= "col-md-7">
				 <input
					type="text" class="form-control" name="lastname"
					value="${user.lastname}" />
			</div>
			</div>
			<div class="form-group">
			<input type="checkbox" name="authorize" id= "authorize" checked disabled="disabled"> Clicking this will authorize usage of your initials as your electronic signature <br>
			</div>


			<div class="form-group">

				<input type="submit" class="btn btn-primary" value="Update" onclick="return confirm('Are you sure to proceed?')"/>
			</div>




		</form>

	</div>






	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>

</body>



</html>