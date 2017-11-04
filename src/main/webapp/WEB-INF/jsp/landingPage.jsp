<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">
<head>
<title>Murray State University Textbook Ordering Application</title>
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
	src="static/js/imageslider.js"></script>

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
	<!-- <div class=container id = "imageslider">
  <a href="#" class="arrowL">&lt;</a>
  <div id="slideshow">
    <div><img src="http://unsplash.it/620/450?image=401"/></div>
    <div class="hidden"><img src="static/images/LandingPage_Image.png"/></div>
    <div class="hidden"><img src="static/images/LandingPage_Image.png"/></div>
  </div>
  <a href="#" class="arrowR">&gt;</a>
</div> -->

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
					<c:if test="${isProvost == 'PROVOST'}"><li class = <c:if test="${page == 'PAGE_APPROVEDPAGES'}">"active"</c:if>><a href="afterapprovals" id="sixth_tab">Approved Applications</a></li></c:if>
					<li class = <c:if test="${page == 'PAGE_PROFILE'}">"active"</c:if>><a href="profile" id="seventh_tab">Profile</a></li>
					<c:if test="${user.isadmin}"><li class = <c:if test="${page == 'PAGE_ADMIN'}">"active"</c:if>><a href="admin" id="eigth_tab">Admin</a></li></c:if>


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
				<h1>Welcome to textbook Ordering Application</h1>
				<p>This is application for filling out application for textbook each semester by each professor.
				This Application helps in processing the application sending reminders about the textbook order form deadlines.</p>
            <!-- <a class="twitter-timeline" width="100%"  href="https://twitter.com/search?q=%23College" data-widget-id="926561609782349824">Tweets about #College</a>
            <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+"://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>

            <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+"://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>

 -->

             <a class="twitter-timeline"  href="https://twitter.com/search?q=%23College%20textbooks" data-widget-id="926561609782349824">Tweets about #College textbooks</a>
            <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+"://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>


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
<jsp:include page="editprofile.jsp"></jsp:include>
</c:when>
<c:when test="${page == 'PAGE_APPROVEDPAGES'}">
<jsp:include page="afterapprovals.jsp"></jsp:include>
</c:when>
<c:when test="${page == 'PAGE_ADMIN'}">
<jsp:include page="admin.jsp"></jsp:include>
</c:when>

		</c:choose>




</body>
<div style = "margin-top:50px;">
<footer class="container-fluid text-center">
		<p>This the textbook ordering application</p>
	</footer>
	</div>
</html>
