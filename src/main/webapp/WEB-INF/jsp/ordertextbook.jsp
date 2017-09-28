<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>



<link href="static/css/style.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript"
	src="static/js/activeselection.js"></script>


</head>

<body>



	<div class="container text-center">
		<h3>You are ordering a textbook for class present in department
			"${user.department.departmentname}"</h3>
		<hr>
		<form class="form-horizontal" method="POST" action="create-order">

			<input type="hidden" name="user_id" value="${user.user_id}" />
			<input type="hidden" name="department_id" value="${user.department}" />

			<div class="form-group">
				<label class="control-label col-md-3"> Select course</label>

				<div class="col-md-7 selectContainer">
					<select class="form-control" name="course">
						<c:forEach var="course" items="${courses}">
							<option  value="${course.class_id}">
								<c:out value="${course.courseId}" />
							</option>
						</c:forEach>
					</select>


				</div>
			</div>

			<div class="form-group">
				<div class="row clearfix">
					<div class="col-md-12 column">
						<table class="table table-bordered table-hover" id="tab_logic">
							<thead>
								<tr>
									<th class="text-center">Serial Number</th>
									<th class="text-center">Title</th>
									<th class="text-center">Author</th>
									<th class="text-center">Copyright</th>
									<th class="text-center">Edition</th>
									<th class="text-center">ISBN</th>
									<th class="text-center">Publisher</th>
									<th class="text-center">Code Required</th>
									<th class="text-center">Ebook Required</th>
								</tr>
							</thead>
							<tbody>
								<tr id='textbook0'>
									<td>1</td>
									<td><input type="text" name='title0' placeholder='Title'
										class="form-control" /></td>
									<td><input type="text" name='author0' placeholder='Author'
										class="form-control" /></td>
									<td><input type="text" name='copyright0'
										placeholder='Copyright' class="form-control" /></td>
									<td><input type="text" name='edition0'
										placeholder='Edition' class="form-control" /></td>
									<td><input type="text" name='isbn0' placeholder='ISBN'
										class="form-control" /></td>
									<td><input type="text" name='publisher0' placeholder='ISBN'
										class="form-control" /></td>
									<td><input type="text" name='iscoderequired0'
										placeholder='CODE Required' class="form-control" /></td>
									<td><input type="text" name='isebooksok0'
										placeholder='Are Ebooks Ok' class="form-control" /></td>
								</tr>
								<tr id='textbook1'></tr>
							</tbody>
						</table>
					</div>
				</div>
				<a id="add_row" class="btn btn-default pull-left">Add Row</a> <a
					id='delete_row' class="pull-right btn btn-default">Delete Row</a>
			</div>



			<div class="form-group">

				<input type="submit" class="btn btn-primary" value="order" />
			</div>




		</form>

	</div>




</body>
</html>