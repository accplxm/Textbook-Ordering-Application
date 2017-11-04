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
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<link href="static/css/style.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript" src="static/js/activeselection.js"></script>
<script type="text/javascript"
	src="static/js/validateaddclass.js"></script>
<title>MSU Textbook-Ordering Application</title>
</head>

<body>
<div class="container">
<div class="text-center">
<h1>Add Class</h1>
<label class="control-label" id= "error" style="color:red; font-size:20px; text-align: center;"></label>
</div>
<c:if test="${not empty status}">
<h3 class="text-center text-primary"> ${status}</h3>
</c:if>

<form class="form-horizontal" method="POST" action="addclassform" name= "addclassform"  onsubmit="return validateAddClassForm()">

<div class = "mt-2 form-group" style = "margin-top:30px;">
<label class="control-label col-xs-4"> Select Department</label>

<div class= "col-xs-6">
<select class="form-control" name="department">
						<c:forEach var="department" items="${departments}">
							<option  value="${department.department_id}">
								<c:out value="${department.department}" />
							</option>
						</c:forEach>
					</select>

</div>

 </div>

 <div class = "mt-2 form-group" style = "margin-top:30px;">
<label class="control-label col-xs-4">Class name</label>

<div class= "col-xs-6">
<input	type="text" class="form-control" name="classname" />

</div>

 </div>

 <div class = "mt-2 form-group" style = "margin-top:30px;">
<label class="text-right col-xs-4"> Class abbreviation</label>

<div class="col-xs-6">

				<input	type="text" class="form-control" name="class" />


 </div>
 </div>

 <div class="mt-10 form-group text-center" style = "margin-top:30px;">

				<input type="submit" class="btn btn-primary" value="Add" onclick="return confirm('Are you sure to proceed?')" />
			</div>
</form>
</div>
</body>


</html>