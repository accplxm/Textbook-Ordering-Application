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

<title>Boot Sample| Home</title>

<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
</head>

<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="#" class="navbar-brand">Bootsample</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-task">Manage Task</a></li>
					<li><a href="all-tasks">All Task</a></li>
					<li><a href="${redirect_URL}">Log In using Google Id</a></li>
					
				</ul>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${mode == 'MODE_HOME'}">
		<div class="container " id="homeDiv">
		<div class="jumbotron text-center">
			<h1>Welcome to Task Manager</h1>
		</div>
	</div>
		</c:when>
		<c:when test="${mode == 'MODE_TASKS'}">
		<div class="container text-center " id="tasksDiv">

		<h3>My Tasks</h3>
		<hr>
		<div class="table-responsive">
			<table class="table table-striped table-bordered text-left">
				<thead>

					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Description</th>
						<th>Date Created</th>

						<th>Finished</th>
						<th></th>
						<th></th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="task" items="${tasks}">
						<tr>
							<td>${task.id}</td>
							<td>${task.name}</td>
							<td>${task.description}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${task.dateCreated}"/></td>
							<td>${task.finished}</td>
							<td><a href="delete-task?id=${task.id}"><span class= "glyphicon glyphicon-trash"></</span></a>
							<td><a href="update-task?id=${task.id}"><span class= "glyphicon glyphicon-pencil"></</span></a>
							


						</tr>
					</c:forEach>


				</tbody>


			</table>
		</div>
	</div>
		
		</c:when>
		<c:when test="${mode == 'MODE_NEW'|| mode=='MODE_UPDATE'}">
		
		
	
	<div class="container text-center">
		<h3>Mange Task</h3>
		<hr>
		<form class="form-horizontal" method="POST" action="save-task">
			<input type="hidden" name="id" value="${task.id}" />
			<div class="form-group">
				<label class="control-label col-md-3"> Name</label> 
				
				<div class= "col-md-7">
				<input	type="text" calss="form-control" name="name" value="${task.name}" />
			</div>
			</div>



			<div class="form-group">
				<label class="control-label col-md-3"> Description</label>
				<div class= "col-md-7">
				 <input
					type="text" calss="form-control" name="Description"
					value="${task.description}" />
			</div>
			</div>
			

			<div class="form-group">
				<label class="control-label col-md-3"> Finished</label>
				<c:choose>
				<c:when test="${task.finished}"> 
				<div class="col-md-7">
					<input type="radio" class="col-sm-1" name="finished" value="true"
						text="Yes" checked />
				<div class="col-sm-1"> Yes</div>
						 <input type="radio" class="col-sm-1" name="finished"
						value="false" text="No" />
				<div class="col-sm-1"> No</div>
				</div>
				</c:when>
				<c:otherwise> 
				<div class="col-md-7">
					<input type="radio" class="col-sm-1" name="finished" value="true"
						text="Yes" />
				<div class="col-sm-1"> Yes</div>
						 <input type="radio" class="col-sm-1" name="finished"
						value="false" text="No" checked />
				<div class="col-sm-1"> No</div>
				</div>
			</div>
			</c:otherwise>
			</c:choose>

			<div class="form-group">

				<input type="submit" class="btn btn-primary" value="Save"/>
			</div>




		</form>

	</div>
		
		
		</c:when>

		
	</c:choose>

	



	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>

</body>



</html>