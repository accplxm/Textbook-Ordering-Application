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

<script type="text/javascript" src="static/js/activeselection.js"></script>


</head>

<body style= "border: 3px solid black; margin:30px;">


<div >
<div class="row"  style= " border: 1px solid black; margin:10px;">

<div class ="col-xs-8 text-center">
<h1 style= "font-weight:bold;">Textbook Ordering Application</h1>
<div class = "text-center">
<h6>This form is for a individual class </h6>
<h4> Order covers one semester only</h4>

</div>
</div>
<div class ="col-xs-4 text-right">
<h3 style= "font-weight:bold;">Submit to:</h3> <h5>Vice President for Academic Affairs</h5> <h5> 333 Wells Hall</h5>
</div></div>







</div>

<div  >
<div class="row"  style= "margin:10px;">
<div class="col-xs-3 text-right">
<h4 style= "font-weight:bold; text-overflow: ellipsis;" > Semester:</h4>
</div>
<div class="col-xs-3 text-left">
<h4 style="text-decoration: underline text-overflow: ellipsis;" >
${selectedterm.semester}- ${selectedterm.year}j</h4>
</div>
<div class="col-xs-3 text-right">
<h4 style= "font-weight:bold; text-overflow: ellipsis;"> Date of Application:</h4>
</div>
<div class="col-xs-3 text-left">
<h4 style="text-decoration: underline; text-overflow: ellipsis;" > ${todaydate}
</h4>
</div>
<div class = "col-md-12">
<div class ="col-xs-3 text-right">
<h4 style= "font-weight:bold; text-overflow: ellipsis;" > Department:</h4>
</div>
<div class="col-xs-9 text-left">
<h4 style="text-decoration: underline; text-overflow: ellipsis;"> ${course.department.departmentname}
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
<h4 style="text-decoration: underline; text-overflow: ellipsis;" >   ${order.istextusedlater}
</h4>
</div>

<div class ="col-xs-12" >
<div class="col-xs-4 text-right">
<h4 style= "font-weight:bold;">Additional Comments :</h4>
</div>
<div class="col-xs-8 text-left">
<h4>d</h4>
</div>
</div>
<div class="col-xs-12 text-center" style= "border: 1px solid black; padding:20px;" >
<h4> ${order.comments}
</h4>
</div>

<div class ="col-xs-12">
<div class ="col-xs-6 text-center">
<h5 >ordered by:</h5>
</div>

<div class ="col-xs-6 text-center" style= "text-overflow: ellipsis;">
<h5 >ordered date:</h5>
</div>

<div class ="col-xs-6 text-right" style= "text-overflow: ellipsis;">
<h3 style="text-decoration: underline">${order.user.initials}(${order.user.firstname} ${order.user.lastname})</h3>
</div>

<div class ="col-xs-6 text-right" style= "text-overflow: ellipsis;">
<h3 style="text-decoration: underline">${order.orderdate}</h3>
</div>

<div class ="col-xs-6 text-center" style= "text-overflow: ellipsis;">
<h5 >Approved by Department Chair:</h5>
</div>

<div class ="col-xs-6 text-center" style= "text-overflow: ellipsis;">
<h5 >approved date:</h5>
</div>

<div class ="col-xs-6 text-right" style= "text-overflow: ellipsis;">
<h3 style="text-decoration: underline;text-overflow: ellipsis;">${chairuser.initials}(${chairuser.firstname} ${chairuser.lastname})</h3>
</div>

<div class ="col-xs-6 text-right" style= "text-overflow: ellipsis;">
<h3 style="text-decoration: underline">${order.chairapproveddate}</h3>
</div>
<div class ="col-xs-6 text-center" style= "text-overflow: ellipsis;">
<h5 >Approved by Department Dean:</h5>
</div>

<div class ="col-xs-6 text-center">
<h5 >approved date:</h5>
</div>

<div class ="col-xs-6 text-right" style= "text-overflow: ellipsis;">
<h3 style="text-decoration: underline">${deanuser.initials}(${deanuser.firstname} ${deanuser.lastname})</h3>
</div>

<div class ="col-xs-6 text-right" style= "text-overflow: ellipsis;">
<h3 style="text-decoration: underline">${order.deanapproveddate}</h3>
</div>
<div class ="col-xs-6 text-center" style= "text-overflow: ellipsis;">
<h5 >Approved by Vice President for Academic Affairs:</h5>
</div>

<div class ="col-xs-6 text-center">
<h5 >approved date:</h5>
</div>

<div class= "col-xs-12">
<div class ="col-xs-6 text-right" style= "text-overflow: ellipsis;">
<h3 style="text-decoration: underline">${presidentuser.initials}(${presidentuser.firstname} ${presidentuser.lastname})</h3>
</div>

<div class ="col-xs-6 text-right" style= "text-overflow: ellipsis;">
<h3 style="text-decoration: underline">${order.vicepresidentapproveddate} </h3>
</div>
</div>
</div>

<div class= "col-xs-12" align="center" >

<button class= "hidden-print btn-primary" onclick="PrintFunction() " style= "padding-top:5px;padding-bottom:5px;padding-right:30px; padding-left:30px;">Print</button>
</div>

</div>


</div>



</body>
</html>