<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<script>
function PrintFunction() {
    window.print();
}
</script>

<link href="static/css/style.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript" src="static/js/myscript.js"></script>
<script type="text/javascript" src="static/js/activeselection.js"></script>


</head>

<body >


<div class= "text-center" style= "border: 3px solid black; margin:30px;">
<div class= "text-center">

 <h3>Order Details for course ${order.classOrders[0].course.classname} ordered by ${order.user.lastname} ${order.user.firstname}</h3>

</div>

<div  >
<div class="row"  style= "margin:10px;">
<div class="col-xs-3 text-right">
<h4 style= "font-weight:bold; text-overflow: ellipsis;" > Semester:</h4>
</div>
<div class="col-xs-3 text-left">
<h4 style="text-decoration: underline text-overflow: ellipsis;" >
${order.term.semester} ${order.term.year}</h4>
</div>
<div class="col-xs-3 text-right">
<h4 style= "font-weight:bold; text-overflow: ellipsis;"> Date of order:</h4>
</div>
<div class="col-xs-3 text-left">
<h4 style=" text-overflow: ellipsis;" > ${order.orderdate}
</h4>
</div>
<div class = "col-md-12">
<div class ="col-xs-3 text-right">
<h4 style= "font-weight:bold; text-overflow: ellipsis;" > Department:</h4>
</div>
<div class="col-xs-9 text-left">
<h4 style=" text-overflow: ellipsis;">${order.user.department.department}
</h4>
</div>
</div>

<c:choose>
  <c:when test="${fn:length(textbooks) gt 0}">
<div id = "table-finaltextbookapplication"  >
				<div class="row">
					<div class="col-xs-12 column">
						<table class="table table-bordered table-hover" id="tab_logic">
							<thead>
								<tr>

									<th class="text-center">SL.No</th>
									<th class="text-center">AUTHOR</th>
									<th class="text-center">TITLE</th>
									<th class="text-center">COPYRIGHT</th>
									<th class="text-center">EDITION</th>
									<th class="text-center">ISBN</th>
									<th class="text-center">PUBLISHER</th>
									<th class="text-center">CODE REQUIRED</th>
									<th class="text-center">EBOOKS NOT OK</th>
									<th class="text-center">ANY ACCEPTABLE EDITIONS</th>

								</tr>
							</thead>
							<tbody>
							<c:forEach items="${textbooks}" var="textbook" varStatus = "status">
								<tr >

									<td>${status.index+1}</td>
									<td>${textbook.author} </td>
									<td>${textbook.title} </td>
									<td>${textbook.copyright}</td>
									<td>${textbook.edition}</td>
									<td>${textbook.isbn}</td>
									<td>${textbook.publisher}</td>
									<td>${textbook.iscoderequired}</td>
									<td>${textbook.isebooksok}</td>
									<td>${textbook.isebooksok}</td>


								</tr>
								 </c:forEach>
							</tbody>
						</table>
					</div>
				</div>

			</div>



</c:when>
<c:otherwise>

<div   style= "border-top: 1px solid black; border-bottom: 1px solid black; padding:30px; text-overflow: ellipsis;"class=" col-xs-12 text-center"  >
   <h3>No Text required for this class in this semester.</h3>
   </div>

  </c:otherwise>
</c:choose>


<div class ="col-xs-4 text-right">
<h4 style= "font-weight:bold; text-overflow: ellipsis;" >Will these Textbook option used later :</h4>
</div>

<div class="col-xs-8 text-left" >
<h4 style=" text-overflow: ellipsis;" >${order.istextusedlater}
</h4>
</div>

<div class ="col-xs-12" >
<div class="col-xs-4 text-right">
<h4 style= "font-weight:bold;">Additional Comments :</h4>
</div>
<div class="col-xs-8 text-left">
<h4>${order.comments}</h4>
</div>
</div>

</div>
</div>
</div>
<div class="text-center form-horizontal">

<h4 class = "col-md-6"> Approve the Order</h4>
<div class ="col-md-6">
<a class=" btn btn-info" href="update-order?id=${order.order_id}&userRole=${user.role}" onclick="return confirm('Are you sure to proceed?')">Approve</a>
</div>
</div>
<form class="form-horizontal" method="POST" action="reject-order" name="ordertextbookform"  >
<div class = "col-md-12 text-center" >
<h4 class="col-md-6"> Reject the order</h4>

<div  class="col-md-3">
<input type="text" name='rejectioncomments' placeholder='Rejection Comments'
										class="form-control" /></div>
</div>
<div class="text-right form-horizontal">
<div class="col-md-3"></div>

<div class="col-md-4 form-group text-right ">
				<label class="col-md-6 control-label "> Reject to: </label>

				<div class="selectContainer col-md-6 ">
					<select class="form-control" name="role">
						<c:forEach var="role" items="${roles}">
							<option  value="${role}">
								<c:out value="${role}" />
							</option>
						</c:forEach>
					</select>


				</div>
			</div>
<input type="hidden" name="order_id" value="${order.order_id}" />
			<input type="hidden" name="user_role" value="${user.role}" />

<div class ="col-md-4 text-left form-group">


				<input type="submit" class="btn btn-primary" value="Reject" onclick="return confirm('Are you sure to proceed?')" />

</div>

</div>
</form>
<jsp:include page="booksearch.jsp"></jsp:include>
</body>
</html>