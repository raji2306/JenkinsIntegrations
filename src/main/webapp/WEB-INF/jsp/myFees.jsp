<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page isELIgnored="false"%>

<!doctype html>
<html lang="en">
<head>

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

<title>Manage Students</title>

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

</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<!-- Brand -->
		<a class="navbar-brand" href="#"><img
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgN2Nov5Yw4BPAXCEbGcwi-l-mab5SAd3lEQ&usqp=CAU"
			alt="" width="50" height="44"
			class="d-inline-block align-text-center"> ABC COLLEGE</a>

		<!-- Links -->
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link"
				href="/student/dashboard">HOME</a></li>

			<li class="nav-item"><a class="nav-link"
				th:href="@{'/student/myFees/' + ${student.studId}}">MY FEES</a></li>
		</ul>
		<div class="navbar-collapse collapse dropdown">
			<ul class="navbar-nav ms-auto ">
				<li class="nav-item "><a class="nav-link dropdown-toggle"
					id="navbardrop" data-toggle="dropdown" href="#">
						${student.firstName} </a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="/logout">LOGOUT</a>
					</div></li>
			</ul>
		</div>
	</nav>

	<br>
	<br>

	<div class="container text-center">
		<h3>Pending Fees</h3>
		<br>
		<h3 style="text-align: right">Pending Fee Amount to be Paid :
			${amount}</h3>
		<br>
		<br>
		<table class="table">
		<caption hidden></caption>
			<thead class="table-dark">
				<tr>
					<th scope="col">Fee Name</th>
					<th scope="col">Branch</th>
					<th scope="col">Amount</th>
					<th scope="col">Due Date</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${feelist}" var="fees">
					<tr>

						<td>${fees.key.feeName}</td>
						<td>${fees.key.branch}</td>
						<td>${fees.value}</td>
						<td>${fees.key.dueDate}</td>
						<td><a
							href="/student/payment/${student.studId}/${fees.key.feeId}">
								<button type="button" class="btn btn-success">PAY</button>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<br>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>


</body>
</html>