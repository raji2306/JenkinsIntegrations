<!DOCTYPE>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<title>Google Charts Example - Spring Boot</title>
<style type="text/css">
.cont2 {
	display: flex;
	margin-top: 50px;
}

#piechart {
	display: flex;
}

#barchart {
	min-height: 260px;
}
</style>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Montserrat:wght@200;400&display=swap')
	;

* {
	font-family: 'Montserrat', sans-serif;
}

body {
	font-family: 'Montserrat', sans-serif;
	background-image:
		url(https://media.istockphoto.com/photos/wood-texture-table-top-with-blur-cafe-kitchen-background-picture-id1273029499?b=1&k=20&m=1273029499&s=170667a&w=0&h=VOceO5Juz-vrWrmlv5PBCmAmryEKfZ8ac7ew0xxlk8o=);
	background-repeat: no-repeat;
	overflow: hidden;
	background-size: cover;
}
</style>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

		<a class="navbar-brand" href="#"><img
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgN2Nov5Yw4BPAXCEbGcwi-l-mab5SAd3lEQ&usqp=CAU"
			alt="" width="50" height="44"
			class="d-inline-block align-text-center"> ABC COLLEGE</a>

		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="/admin/dashboard">
					HOME </a></li>

			<li class="nav-item"><a class="nav-link"
				href="/admin/manageStudents"> MANAGE STUDENTS </a></li>

			<li class="nav-item"><a class="nav-link"
				href="/admin/manageFees"> MANAGE FEES </a></li>

		</ul>


		<div class="navbar-collapse collapse dropdown">
			<ul class="navbar-nav ms-auto ">
				<li class="nav-item "><a class="nav-link" href="/logout">
						LOGOUT </a></li>
			</ul>
		</div>

	</nav>

	<div class=cont2>
		<p id="piechart" style="height: 300px; width: 800px"></p>
		<div id="chart_div" style="height: 300px; width: 900px"></div>
		<br>
		<br>
	</div>
	<div class="row container d-flex">
		<div class="col-xs-10">
			<p
				style="font-family: 'Montserrat', sans-serif; font-size: 50px; margin-left: 490px; display: inline-block;">Total
				Students : [[${totStudents}]]</p>
		</div>
	</div>

	<script th:inline="javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawPieChart);
        var real_data = [[${chartData}]];
        var real_data1 = [[${barData}]];
       
        function drawPieChart() {
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Payment Type');
            data.addColumn('number', 'Number of Students');
            Object.keys(real_data).forEach(function(key) {
                data.addRow([ key, real_data[key] ]);
            });
            var options = {
            	backgroundColor: 'transparent',
                title : 'Payment Status',
                is3D:true,
            };
            var chart = new google.visualization.PieChart(document
                    .getElementById('piechart'));
            chart.draw(data, options);
        }
        
        $(document).ready(function() {
            google.charts.load('current', {
                packages : [ 'corechart', 'bar' ]
            });
            google.charts.setOnLoadCallback(drawColumnChart);
            google.charts.setOnLoadCallback(drawPieChart);
        });
        
        function drawColumnChart() {
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Fees');
            data.addColumn('number', 'Total Students  ');
            data.addColumn('number', 'Paid Students  ');
            
            Object.keys(real_data1).forEach(function(key) {
                data.addRow([ key, real_data1[key][0], real_data1[key][1]]);
            });
            var options = {
            		backgroundColor: 'transparent',
                title : 'Pending Fees',
                hAxis : {
                    title : 'Fees',
                },
                vAxis : {
                    title : 'Amount'
                }
            };
            var chart = new google.visualization.ColumnChart(document
                    .getElementById('chart_div'));
            chart.draw(data, options);
        }
    </script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

</body>
</html>