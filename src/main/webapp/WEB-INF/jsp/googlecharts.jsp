<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="layout" content="main" />
  <script type="text/javascript" src="https://www.google.com/jsapi"></script>
  <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script>

    // Load the Visualization API and the piechart package.
    google.load('visualization', '1.1', {'packages':['corechart']});

    // Set a callback to run when the Google Visualization API is loaded.
    google.setOnLoadCallback(drawChart);
alert("drawing chart");
    function drawChart() {
      var jsonData = $.ajax({
        url: '/getCoursesInDepartment',
        dataType: "json",
        async: true
      }).responseText;
alert("drawing chart response text"+responseText);
      // Create our data table out of JSON data loaded from server.
      var data = new google.visualization.DataTable(jsonData);

      // Instantiate and draw our chart, passing in some options.
      var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
      chart.draw(data, {width: 400, height: 240});
    }
  </script>
</head>
<body>


<div id="chart_div"></div>



</body>
</html>