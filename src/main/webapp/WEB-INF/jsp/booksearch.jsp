<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="static/css/bootstrap.min.css">

  <link rel="stylesheet" href="static/js/mystyle.css"/>
</head>
<body >
<div class="container text-center">
	<div id="search" class="#f5f5f5 grey lighten-4 z-depth-5" style="padding-top: 20px;">
		<form id="myform">
			<div class="input-field">
			<div class= "col-md-5 text-right"><label for="search">Type any string and search Books: </label></div>
				<div class= "col-md-4 text-center" ><input type="search" id="books" placeholder='Title or ISBN number'>
</div>
<div class= "col-md-3 text-left">
<button class="  btn btn-success">Search Books</button>
</div>
			</div>


		</form>
	</div>
	<div id="result">

	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<script src="myscript.js"></script>
	</div>
</body>

</html>