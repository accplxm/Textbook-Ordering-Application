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


</head>

<body>
<div class="container">
<div class="text-center">
<h1>Update User Information</h1>
</div>
<c:if test="${not empty status}">
<h3 class="text-center text-primary"> ${status}</h3>
</c:if>

<form class="form-horizontal" method="POST" action="updateuserroles">
<div class = "mt-2 form-group" style = "margin-top:30px;">
<label class="control-label col-xs-4"> Select User</label>

<div class= "col-xs-6">
<select class="form-control" name="user">
						<c:forEach var="uservar" items="${users}">
							<option  value="${uservar.user_id}">
								<c:out value="${uservar.firstname} ${uservar.lastname}" />
							</option>
						</c:forEach>
					</select>

</div>

 </div>

 <div class = "mt-2 form-group" style = "margin-top:30px;">
<label class="control-label col-xs-4"> Select Role</label>

<div class= "col-xs-6">
<select class="form-control" name="role">
						<c:forEach var="role" items="${roles}">
							<option  value="${role}">
								<c:out value="${role}" />
							</option>
						</c:forEach>
					</select>

</div>

 </div>

 <div class = "mt-2 form-group" style = "margin-top:30px;">
<label class="text-right col-xs-4"> Give Admin Rights</label>

<div class="col-xs-6">

					<input type="radio" class=" col-xs-1 form-inline" name="isadmin" value=true
						${someAttributeTrue ? 'checked' :''} />
				<div class="col-xs-2"> Yes</div>
						 <input type="radio" class="col-xs-1 form-inline" name="isadmin"
						value=false  checked />
				<div class="col-xs-2"> No</div>
				</div>



 </div>

 <div class="mt-10 form-group text-center" style = "margin-top:30px;">

				<input type="submit" class="btn btn-primary" value="Update"/>
			</div>
</form>
</div>
</body>


</html>