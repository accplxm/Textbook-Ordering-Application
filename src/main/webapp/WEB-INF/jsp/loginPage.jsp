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

<div class= "container h-100 d-flex justify-content-center">
<div class= "col-lg-12 bordermargin" align ="center" >
<img  class= "img-responsive borderpadding" src = "https://upload.wikimedia.org/wikipedia/commons/2/2c/MSU_Logo.png">
</div>

<div class= "col-lg-12 bordermargin" align ="center" >
<h1>Welcome to text book ordering Application </h1>
</div>
<c:choose>
<c:when test="${isInvalidLogIn}"> 
<div class= "col-lg-12 bordermargin" align ="center" ><font color="red">
<h4>    Invalid log-in. Try log-in using only 'murraystate.edu' email-Id.</h4></font>
</div>
</c:when>
</c:choose>
<div class= "col-lg-12 bordermargin" align ="center" >
<a href="${redirect_URL}" role= "button" class ="btn btn-info borderpadding"><span class="glyphicon glyphicon-log-in"></span> Login using google account</a>
</div>

	</div>


	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>

</body>



</html>