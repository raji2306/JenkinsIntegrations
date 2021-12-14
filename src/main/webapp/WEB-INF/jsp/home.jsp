<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="preconnect" href="https://fonts.googleapis.com"> 
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin> 
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@200;400&display=swap" rel="stylesheet">
<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@200;400&display=swap');
     *{
     	font-family: 'Montserrat', sans-serif;
     }
     
*{

	margin: 0;
	padding 0;
	font-family: 'Montserrat', sans-serif;
}

.banner{
	width: 100%;
	height: 100vh;
	background-image: url(https://venngage-wordpress.s3.amazonaws.com/uploads/2018/09/Monochrome-Type-Simple-Background-Image.jpg);
	background-size: cover;
	background-position: center;
}

.navbar {
	width : 85%;
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

.content {
	width: 100%;
	position: absolute;
	top: 30%;
	transform: translateY(-50);
	text-align: center;
	color: #fff;
	
}

.content h1{
	font-size: 70px;
	margin-top: 80px;
}

.content p {
	margin: 20px auto;
	font-weight: 100px;
	line-height: 25px;
}

button {
	width:200px;
	padding: 15px 0;
	text-align: center;
	margin-top:400px;
	margin-left:350px;
	border-radius: 25px;
	font-weight: bold;
	border: 2px solid #009688;
	background: transparent;
	color:#fff;
	cursor: pointer;
	position: relative;
	overflow: hidden;
}


</style>
</head>
<body>
	<div class="banner">	
		<div class="navbar">
			<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgN2Nov5Yw4BPAXCEbGcwi-l-mab5SAd3lEQ&usqp=CAU" alt="logopic" class="logo">
			<ul>
				<li><a class="nav-list" href="/">Home</a></li>
				<li><a class="nav-list" href="/admin/dashboard">Admin</a></li>
				<li><a class="nav-list" href="/student/dashboard">Student</a></li>
				<li><a class="nav-list" href="#">About</a></li>
				<li><a class="nav-list" href="#">Contact</a></li>
			</ul>
		</div>
		<div class="content">
			<h1>FEES MANAGEMENT SYSTEM</h1>
			<p>Applicable to view the the fees details provided by the administrator of the 
			organization and <br>student can edit his personal and pay the fees which can be viewed by the administrator</p>
			
		</div>
			<a href="/student/dashboard"><button type="button" ><span></span>STUDENT</button></a>
			<a href="/admin/dashboard"><button type="button"><span></span>ADMIN</button></a>
	</div>
     
</body>
</html>