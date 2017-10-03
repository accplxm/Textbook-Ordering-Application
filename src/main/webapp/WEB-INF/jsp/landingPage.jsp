<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="static/css/bootstrap.min.css">
	<link href="static/css/style.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="static/js/activeselection.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	padding-right:100px;
	padding-left:100px;
	border-radius: 0;
}



/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>

	<div class="row">
		<div class="col-lg-12 bordermargin borderpadding">
			<img class="img-responsive borderpadding"
				style="vertical-align: middle"
				src="static/images/LandingPage_Image.png">
		</div>
		<!-- </div>
<div class= "col-lg-8 text-left bordermargin borderpadding" style="vertical-align:middle" >
<h1> Text book ordering Application</h1>
</div> -->
	</div>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">

				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="landingPage"><span
					class="glyphicon glyphicon-home"></span></a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class= <c:if test="${page == 'PAGE_HOME'}">"active"</c:if>><a href="landingPage" id="first_tab">Home</a></li>
					<li class= <c:if test="${page == 'PAGE_ORDERTEXTBOOK'}">"active"</c:if>><a href="ordertextbook" id="third_tab">Order Textbook</a></li>
					<li class = <c:if test="${page == 'PAGE_ORDERSTATUS'}">"active"</c:if>><a href="orderstatus"  id="fourth_tab">Order Status</a></li>
					<c:if test="${isAdmin == 'ADMIN'}"><li class = <c:if test="${page == 'PAGE_APPROVALS'}">"active"</c:if>><a href="approvals" id="fifth_tab">Approvals</a></li></c:if>
					<li class = <c:if test="${page == 'PAGE_PROFILE'}">"active"</c:if>><a href="profile" id="fifth_tab">Profile</a></li>

				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="log-out"><span
							class="glyphicon glyphicon-log-out"></span> Log out</a></li>
				</ul>
			</div>
		</div>
	</nav>


<c:choose>
		<c:when test="${page == 'PAGE_HOME'}">

	<div class="container-fluid text-center">
		<div class="row content">

			<div class="col-sm-1 sidenav"></div>
			<div class="col-sm-10 text-left">
				<h1>Welcome</h1>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
					enim ad minim veniam, quis nostrud exercitation ullamco laboris
					nisi ut aliquip ex ea commodo consequat. Excepteur sint occaecat
					cupidatat non proident, sunt in culpa qui officia deserunt mollit
					anim id est laborum consectetur adipiscing elit, sed do eiusmod
					tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
					minim veniam, quis nostrud exercitation ullamco laboris nisi ut
					aliquip ex ea commodo consequat.</p>
				<hr>
				<h3>Test</h3>
				<p>Lorem ipsum...</p>
			</div>
			<div class="col-sm-1 sidenav"></div>
		</div>
	</div>
</c:when>
<c:when test="${page == 'PAGE_ORDERTEXTBOOK'}">
<jsp:include page="ordertextbook.jsp"></jsp:include>
</c:when>
<c:when test="${page == 'PAGE_ORDERSTATUS'}">
<jsp:include page="orderstatus.jsp"></jsp:include>
</c:when>
<c:when test="${page == 'PAGE_APPROVALS'}">
<jsp:include page="approvals.jsp"></jsp:include>
</c:when>
<c:when test="${page == 'PAGE_PROFILE'}">
<jsp:include page="profile.jsp"></jsp:include>
</c:when>

		</c:choose>


	<footer class="container-fluid text-center">
		<p>Footer Text</p>
	</footer>

</body>
</html>
