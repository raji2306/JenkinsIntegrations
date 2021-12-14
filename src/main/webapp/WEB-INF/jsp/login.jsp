<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
<link rel="preconnect" href="https://fonts.googleapis.com"> 
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin> 
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@200;400&display=swap" rel="stylesheet">
<style>

body {
	font-family: 'Montserrat', sans-serif;
	background-image:
		url(https://venngage-wordpress.s3.amazonaws.com/uploads/2018/09/Monochrome-Type-Simple-Background-Image.jpg);
	background-repeat: no-repeat;
	overflow: hidden;
	background-size: cover;
}

.container {
	width: 380px;
	margin: auto;
	border-radius: 25px;
	background-color: rgba(0, 0, 0, 0.1);
	box-shadow: 0 0 17px #fff;
}

.navbar {
	width : 75%;
	margin : auto;
	padding: 30px 0;
	display: flex;
	align-items: center;
	justify-content: space-between;
}

.logo {
	width: 50px;
	cursor:pointer;
}

.navbar ul li {
	list-style: none;
	display: inline-block;
	margin: 0 20px;
}

.navbar ul li {
	list-style: none;
	display: inline-block;
	margin: 0 20px;
	position:relative;
}
.navbar ul li .nav-list{
	text-decoration: none;
	color:#fff;
	text-transform: uppercase;
}

.navbar ul li::after {
	content: '';
	height: 3px;
	width: 0;
	background: #009688;
	position: absolute;
	left: 0;
	bottom: -10px;
	transition: 0.5s;
}

.navbar ul li:hover::after {
	width :100%;
}

.header {
	text-align: center;
	padding-top: 75px;
}

.header h1 {
	color: #fff;
	font-size: 45px;
	margin-bottom: 80px;
}

.main {
	text-align: center;
}

.main input, .btn {
	width: 300px;
	height: 40px;
	border: none;
	outline: none;
	padding-left: 40px;
	box-sizing: border-box;
	font-size: 15px;
	color: #333;
	margin-bottom: 40px;
}

.main .btn {
	padding-left: 0;
	background-color: #7b9cac;
	letter-spacing: 1px;
	font-weight: bold;
	margin-bottom: 70px;
}

.main .btn:hover {
	box-shadow: 2px 2px 5px #555;
	background-color: #7799d4;
}

.main input:hover {
	box-shadow: 2px 2px 5px #555;
	background-color: #ddd;
}

.main span {
	position: relative;
}

.main i {
	position: absolute;
	left: 15px;
	color: #333;
	font-size: 16px;
	top: 2px;
}
</style>
<!------ Include the above in your HEAD tag -->

<div class="navbar">
		<img
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgN2Nov5Yw4BPAXCEbGcwi-l-mab5SAd3lEQ&usqp=CAU" alt="logopic"
			class="logo">
		<ul>
			<li><a class="nav-list" href="/">Home</a></li>
		</ul>
	</div>

<div class="container">

	<div class="header">
		<h1>login</h1>
		<p style="color: red;">${error}</p>
		<p style="color: blue;">${message}</p>
	</div>
	<div class="main">
		<form method="post" th:action="@{/signin}" role="form">
			<span> <em class="fa fa-user"></em> <input type="text"
				placeholder="Username" name="username">
			</span><br> <span> <em class="fa fa-lock"></em> <input
				type="password" placeholder="password" name="password">
			</span><br> <input type="submit" name="submit" class="btn"
				value="submit" />

		</form>
	</div>
</div>

<!-- 
 
 *{
	margin: 0;
	padding 0;
	font-family:sans-serif;
}
.container{
	width: 100%;
	height: 100vh;
	background-image: url(https://venngage-wordpress.s3.amazonaws.com/uploads/2018/09/Monochrome-Type-Simple-Background-Image.jpg);
	background-size: cover;
	background-position: center;
}


 
  -->

