<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri = "http://www.springframework.org/tags" prefix = "spring"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!doctype html>
<html lang="en">
  <head>
   
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  	
    <title>Add Fee</title>
    <style>
     @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@200;400&display=swap');
     *{
     	font-family: 'Montserrat', sans-serif;
     }
    </style>
    
  </head>
  <body>
     <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
 
  <a class="navbar-brand" href="#"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgN2Nov5Yw4BPAXCEbGcwi-l-mab5SAd3lEQ&usqp=CAU"
   alt="" width="50" height="44" class="d-inline-block align-text-center">  ABC COLLEGE</a>

  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="/admin/dashboard">
      	HOME
      </a>
    </li>

    <li class="nav-item">
      <a class="nav-link" href="/admin/manageStudents">
        MANAGE STUDENTS
      </a>
    </li>
    
    <li class="nav-item">
      <a class="nav-link" href="/admin/manageFees">
        MANAGE FEES
      </a>
    </li>
    
  </ul>
  
  
  <div class="navbar-collapse collapse dropdown">
		  <ul class="navbar-nav ms-auto ">
		  	<li class="nav-item ">
			      <a class="nav-link" href="/logout">
			        LOGOUT
			      </a>
		    </li>
		  </ul>
	  </div>
  
</nav>

     <br><br>


     


    <div class="container text-center">
      <h5>Add Fee</h5>
      <div class="card mb-3 text-center" style="width: 80rem; height: 30rem; padding: 2px">
        <br><br>
         <div class = "row">
	         <div class = "col-md-4" style = "margin : auto">
		         <form:form action="/admin/updateFee" modelAttribute = "fee" method = "post" commandName="fee">
					<form:input type="hidden" path="feeId" /> 
					<form:label path="feeName" style = "float : left;">Fee Name</form:label>
					<form:input type="text" class="form-control" placeholder="Fee name" aria-label="First Name" path = "feeName" id = "feeName" required = "required"/>
					<br>
		          	<form:label path="amount" style = "float : left;">Branch</form:label>
		          	<form:select class="form-control" id="branch" path = "branch">
		          		  <form:option value = "All">All</form:option>
		                  <form:option value = "B.Tech">B.Tech</form:option>
		                  <form:option value = "B.Com">B.Com</form:option>
		                  <form:option value = "LLB">LLB</form:option>
		                  <form:option value = "B.Arch">B.Arch</form:option>
		                  <form:option value = "M.Tech">M.Tech</form:option>
		                  <form:option value = "MBA">MBA</form:option>
		                  <form:option value = "PHD">PHD</form:option>
		            </form:select>
		            <br>
		            <form:label path="amount" style = "float : left;">Amount</form:label>
		            <form:input type="number" class="form-control" placeholder="Amount" aria-label="Amount" id = "amount" path="amount" required = "required"/>
		            <br>
		            <form:label path="dueDate" style = "float : left;">Due Date</form:label>
		            <form:input type="date" class="form-control" placeholder="Due Date" aria-label="Due Date" id = "dueDate" path="dueDate" required = "required"/>
		            <br>
		            <form:button type="Submit" class="btn btn-dark">SUBMIT</form:button>
		        </form:form>
	        </div>
        </div>
      </div>
      <br><br>
      <a href = "/admin/manageFees">
    	 <button type="button" class="btn btn-success">Go Back</button>
      </a>
    </div>
    
   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  
    
   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    
  </body>
</html>