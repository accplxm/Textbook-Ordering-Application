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

	<script type="text/javascript"
	src="static/js/activeselection.js"></script>


<script type="text/javascript"
	src="static/js/validateordertextbook.js"></script>
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

<body>



	<div class="container text-center">
		<h3>Edit Order for course ${order.classOrders[0].course.classname}</h3>
		<hr>
		<form class="form-horizontal" method="POST" action="resubmit-order"name="ordertextbookform"  onsubmit="return validateOrderTextbookForm()">

			<input type="hidden" name="order_id" value="${order.order_id}" />
			<input type="hidden" name="textbookRequiredbool" value="${textbookrequired}" />
			<input type="hidden" name="user_id" value="${order.user.user_id}" />
			<input type="hidden" name="department_id" value="${order.user.department.department_id}" />
			<label class="control-label" id= "error" style="color:red; font-size:20px; text-align: left;"></label>
			<div class="form-group">
				<label class="control-label col-md-3"> Select course</label>

				<div class="col-md-7 selectContainer">
					<select class="form-control" name="course">
						<c:forEach var="course" items="${courses}">
							<option  value="${course.class_id}"  ${course.class_id == order.classOrders[0].course.class_id ? 'selected' : ''}>
								<c:out value="${course.courseId}" />
							</option>
						</c:forEach>
					</select>


				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-md-3"> Select Term</label>

				<div class="col-md-7 selectContainer">
					<select class="form-control" name="term">
						<c:forEach var="term" items="${terms}">
							<option  value="${term.term_id}"  ${term.term_id == order.term.term_id ? 'selected' : ''} >
								<c:out value="${term.semester}- ${term.year}" />
							</option>
						</c:forEach>
					</select>


				</div>
			</div>


<div class="form-group">
				<label class="control-label col-md-3"> Comments</label>

				<div class="col-md-7 ">

				<input type="text" name='ordercommets' placeholder='Comments'
										class="form-control" value= "${order.comments}" />

				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3"> Is Textbook Required</label>
				<div class="col-md-7">
					<input type="radio" class="col-sm-1" id= "radio-textrequiredYes" name="textbookRequired" value=true
						${textbookrequired == true ? 'checked' : ''} disabled='disabled'/>
				<div class="col-sm-1"> Yes</div>
						 <input type="radio" id= "radio-textrequiredNo" class="col-sm-1" name="textbookRequired"
						value=false   ${textbookrequired == false ? 'checked' : ''} disabled='disabled'/>
				<div class="col-sm-1"> No</div>
				</div>
</div>


<div class="form-group">
				<h3> *To change number of textbooks please raise a new order*</h3>

				</div>

			<div id = "table-divison" class="form-group tableToHide" >
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
									<th class="text-center">Any Acceptable Editions</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${textbooks}" var="textbook" varStatus = "status">
								<tr id='textbook0'>
									<td>${status.index+1}</td>
									<td><input type="text" name="title${status.index}" placeholder='Title'
										class="form-control" value= "${textbook.title}" /></td>
									<td><input type="text" name='author${status.index}' placeholder='Author'
										class="form-control" value= "${textbook.author}"/></td>
									<td><input type="text" name='copyright${status.index}'
										placeholder='Copyright' class="form-control" value= "${textbook.copyright}" /></td>
									<td><input type="text" name='edition${status.index}'
										placeholder='Edition' class="form-control" value= "${textbook.edition}"/></td>
									<td><input type="text" name='isbn0' placeholder='ISBN'
										class="form-control" value= "${textbook.isbn}"/></td>
									<td><input type="text" name='publisher0' placeholder='Publisher'
										class="form-control" value= "${textbook.publisher}"/></td>
									<td>

					<div class="text-center"><input type="radio"  id= "iscoderequiredYes" name="iscoderequired0" value=true ${textbook.iscoderequired == true ? 'checked' : ''}
						 />Yes</div ><div class="text-center"><input type="radio" id= "iscoderequiredNo" name="iscoderequired0"
						value=false  ${textbook.iscoderequired == false ? 'checked' : ''}/>No</div>



									</td>
									<td><div >
					<input type="radio"  id= "isebooksokYes" name="isebooksok0" value=true
						 ${textbook.isebooksok == true ? 'checked' : ''} />
				Yes</div>
						<div> <input type="radio" id= "isebooksokNo"  name="isebooksok0"
						value=false ${textbook.isebooksok == false ? 'checked' : ''}  />
				No</div>
				</td>
				<td><input type="text" name='acceptableeditions0' placeholder='Editions'
										class="form-control" value= "${textbook.acceptableeditions}"/></td>
								</tr>
								<%-- <tr id = 'previoustextbook0'>
								<td align="center" colspan="11"> <label class="control-label col-md-3"> Select from previous textbook</label>

				<div class="col-md-7 selectContainer">
					<select class="form-control" name="previoustext0">
						<c:forEach var="textbook" items="${textbooks}">
							<option  value="${textbook.textbook_id}">
								<c:out value="${textbook.title}- ${textbook.author} - ${textbook.edition}- ${textbook.isbn}" />
							</option>
						</c:forEach>
					</select>


				</div>    </td>
								</tr> --%>
								<tr id='textbook1'></tr>
								<tr id='previoustextbook1'></tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<!-- <a id="add_row" class="btn btn-default pull-left">Add Row</a> <a
					id='delete_row' class="pull-right btn btn-default">Delete Row</a> -->
			</div>



			<div class="form-group">

				<input type="submit" class="btn btn-primary" value="Resubmit" onclick="return confirm('Are you sure to proceed?')" />
			</div>




		</form>

	</div>




</body>
</html>