<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>

<link rel="stylesheet"
	href="static/css/bootstrap.min.css">
	<link href="static/css/style.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="static/js/activeselection.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<link href="static/css/style.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript" src="static/js/activeselection.js"></script>
<script type="text/javascript"
	src="static/js/validateapprovedapplications.js"></script>


</head>

<body>
<h1></h1>
<div class= "text-center">
<label class="control-label" id= "error" style="color:red; font-size:20px; text-align: center;"></label>
</div>
<form class="form-horizontal" method="POST" action="reloadPageAfterSelection" name="approvedapplicationsform" onsubmit="return validateApprovedApplicationsForm()">

		<div class = "form-group">
			<label class="control-label col-md-3"> Select Term</label>

			<div class="col-md-7 selectContainer">
				<select class = "form-control" name="term">
				<option>
								--Select Value ----
							</option>
					<c:forEach var="term" items="${terms}">
						<option value="${term.term_id}">
							<c:out value="${term.semester}- ${term.year}" />
						</option>
					</c:forEach>
				</select>


			</div>
		</div>



		<div class = "form-group">
			<label class="control-label col-md-3"> Select Department</label>

			<div class="col-md-7 selectContainer">
					<select class = "form-control" name="department">
					<option >
								--Select Value ----
							</option>
						<c:forEach var="department" items="${departments}">
							<option  value="${department.department_id}">
								<c:out value="${department.departmentname}" />
							</option>
						</c:forEach>
					</select>


				</div>
		</div>
	<div class=" control-label   form-group container">

				<input type="submit" class="btn btn-primary" value="Find Courses" />
			</div>
			</form>
			<h1></h1>

			<c:if test="${not empty selecteddepartment}">
			<c:if test="${empty approvedcourses}">
<div class="container text-center">
			<h3>No Courses for selected selection or there was a wrong selection</h3>
			</div>
			</c:if>
			</c:if>

			<c:if test="${not empty approvedcourses}">



			<div class="container text-center panel-group">
			<h3>Textbook orders for selected department "${selecteddepartment.departmentname}" and term "${selectedterm.semester}- ${selectedterm.year}" </h3>
				<div class="row panel panel-danger">
					<c:forEach items="${approvedcourses}" var="course" varStatus = "status">
						<div class="col-sm-6 panel-body thumbnail">
							<a href="finalapplication?course=${course.class_id}&term=${selectedterm.term_id}&order=${approvedorders[status.index].order_id}" target="_blank">
								${course.classname} (ordered by ${approvedorders[status.index].user.firstname} ${approvedorders[status.index].user.lastname})</a>
						</div>
					</c:forEach>

				</div>
			</div>
			</c:if>





</body>
</html>