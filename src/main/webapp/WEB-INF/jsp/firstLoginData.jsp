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
</head>

<body>



	<div class="container text-center">
		<h3>Hello ${user.firstname} please give more details about you ${user.emailid} </h3>
		<hr>
		<form class="form-horizontal" method="POST" action="save-user">
			<input type="hidden" name="id" value="${user.user_id}" />
			<input type="hidden" name="emailid" value="${user.emailid}" />

			<div class="form-group">
			<label class="control-label col-md-3"> Select Department </label>
			<div class= "col-md-7">
			<select class ="form-control" name="department">
        <c:forEach var="department" items="${departments}">
            <option  value="${department.department_id}">
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

				<input type="submit" class="btn btn-primary" value="Save"/>
			</div>




		</form>

	</div>






	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>

</body>



</html>