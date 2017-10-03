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
		<h3>Current Order status for "${user.firstname}" "${user.lastname}" </h3>
		<hr>


			<div id = "table-orderStatus">
				<div class="row clearfix">
					<div class="col-md-12 column">
						<table class="table table-bordered table-hover" id="tab_logic">
							<thead>
								<tr>

									<th class="text-center">Order Date</th>
									<th class="text-center">Ordered By</th>
									<th class="text-center">Number of Textbooks</th>
									<th class="text-center">Department</th>
									<th class="text-center">Course Name</th>
									<th class="text-center">Order Status</th>
									<th class="text-center">Term ordered</th>
									<th class="text-center">Order Comments</th>

								</tr>
							</thead>
							<tbody>
							<c:forEach items="${orders}" var="order">
								<tr >

									<td>${order.orderdate}</td>
									<td>${order.user.lastname} ${order.user.firstname} </td>
									<td>${order.user.lastname} ${order.user.firstname} </td>
									<td>${order.user.department.department}</td>
									<td>${order.user.lastname} ${order.user.firstname}</td>
									<td>${order.user.lastname} ${order.status}</td>
									<td>${order.user.lastname} ${order.user.firstname}</td>
									<td>${order.user.lastname} ${order.user.firstname}</td>

								</tr>
								 </c:forEach>
							</tbody>
						</table>
					</div>
				</div>

			</div>


	</div>




</body>
</html>