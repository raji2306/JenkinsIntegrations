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
  	
    <title>Add Student</title>
    <style>
     @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@200;400&display=swap');
     *{
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


    <div class="container">
      <h5>Add Student</h5>
      <div class="card mb-3" style="width: 80rem; height: 30rem; padding: 2px; background-color:transparent;border-radius: 25px; box-shadow: 0 0 17px #fff;">
        <br><br>
         <form:form action="/admin/saveStudent" modelAttribute = "student" method = "post" commandName="student">
          <div class="row">
            <div class="col">
				<form:input type="text" class="form-control" placeholder="First name" aria-label="First Name" path = "firstName" id = "firstName" style="background-color: transparent; border-radius: 25px; box-shadow: 0 0 17px #fff;" required = "required"/>
            </div>
            <div class="col" style="border-right: 1px solid black;">
				<form:input type="text" class="form-control" placeholder="Last name" aria-label="Last Name" path="lastName" id = "lastName" style="background-color: transparent; border-radius: 25px; box-shadow: 0 0 17px #fff;" required = "required"/>
            </div>
            <div class="col">
              <h5 style="text-align: center;">Contact Information</h5>
            </div>
          </div>

          <br>

           <div class="row">

            <div class="col-md-4">
              <form:input type="number" class="form-control" placeholder="RRN" aria-label="RRN" id = "rrn" path="rrn" style="background-color: transparent; border-radius: 25px; box-shadow: 0 0 17px #fff;" required = "required"/>
            </div>


            <div class="col">
              <div class="form-group">
                <form:select class="form-control" id="branch" path = "branch" style="background-color: transparent; border-radius: 25px; box-shadow: 0 0 17px #fff;">
                  <form:option value = "B.Tech">B.Tech</form:option>
                  <form:option value = "B.Com">B.Com</form:option>
                  <form:option value = "LLB">LLB</form:option>
                  <form:option value = "B.Arch">B.Arch</form:option>
                  <form:option value = "M.Tech">M.Tech</form:option>
                  <form:option value = "MBA">MBA</form:option>
                  <form:option value = "PHD">PHD</form:option>
                </form:select>
              </div>
              
            </div>

            
            <div class="col" style="border-right: 1px solid black;">
              <form:label path="dob">DOB</form:label>
              <form:input type="date" id = "dob" path="dob" style="background-color: transparent; border-radius: 25px; box-shadow: 0 0 17px #fff;" required = "required"/>
            </div>
            
            <div class="col-md-4">
              <form:input type="email" class="form-control" placeholder="Email" aria-label="Email" id = "email" path="email" style="background-color: transparent; border-radius: 25px; box-shadow: 0 0 17px #fff;" required = "required"/>
            </div>

          </div>

          <br>

          <div class="row">
            <div class="col">
              <form:input type="text" class="form-control" placeholder="Class" aria-label="Class" id = "uniClass" path="uniClass" style="background-color: transparent; border-radius: 25px; box-shadow: 0 0 17px #fff;" required = "required"/>
            </div>
            <div class="col" style="border-right: 1px solid black;">
              <form:input type="text" class="form-control" placeholder="Section" aria-label="Section" id = "section" path="section" style="background-color: transparent; border-radius: 25px; box-shadow: 0 0 17px #fff;" required = "required"/>
            </div>
            <div class="col">
              <form:input type="number" class="form-control" placeholder="Phone" aria-label="Phone" id = "phone" path="phone" style="background-color: transparent; border-radius: 25px; box-shadow: 0 0 17px #fff;" pattern="[1-9]{1}[0-9]{9}" required = "required"/>
            </div>
          </div>

          <br>

           <div class="row">
            <div class="col text-center">
              <h5>Gender</h5>
            </div>
             <div class="col">
              <div class="form-check">
              <form:radiobutton class="form-check-input" value = "male" path="gender" id="male"/>
              <form:label class="form-check-label" path = "gender" for="male">
                Male
              </form:label>
            </div>
            <div class="form-check">
              <form:radiobutton class="form-check-input" value = "female" path="gender" id="female" checked = "checked"/>
              <form:label class="form-check-label" path = "gender" for="female">
                Female
              </form:label>
             </div>
            </div>
             <div class="col text-center">
              <h5>Scholarship</h5>
            </div>
            <div class="col" style="border-right: 1px solid black;">
              <div class="form-check">
                <form:radiobutton class="form-check-input" value="yes" path = "scholarship" id="yes"/>
                <form:label class="form-check-label" path = "scholarship" for="yes">
                  Yes
                </form:label>
              </div>
              <div class="form-check">
                <form:radiobutton class="form-check-input" value="no" path = "scholarship"  id="no" checked = "checked"/>
                <form:label class="form-check-label" path = "scholarship" for="no">
                  No
                </form:label>
              </div>
            </div>
            <div class="col">
              <div class="form-floating">
              	  <form:textarea id="address" path = "address" style="height: 100px; width: 410px; background-color: transparent; border-radius: 10px; box-shadow: 0 0 17px #fff;" placeholder="Address" required = "required"></form:textarea> 
              </div>
            </div>
          </div> 

          <br>
           <div class="row">
            <div class="col text-center" style="margin-left: -100px">
              <h5>Facilities</h5>
            </div>
            <div class="col" style="margin-left: -115px">
              <div class="form-check">
                <form:checkbox class="form-check-input" id="hostel" path="hostel"/>
                <form:label class="form-check-label" path = "hostel" for="Hostel">
                  Hostel
                </form:label>
              </div>
              <div class="form-check">
                <form:checkbox class="form-check-input" id="transport" path="transport"/>
                <form:label class="form-check-label" path = "transport" for="Transport" >
                  Transport
                </form:label>
              </div>
              <div class="form-check">
                <form:checkbox class="form-check-input" id="canteen" path="canteen"/>
                <form:label class="form-check-label" path = "canteen" for="canteen" >
                  Canteen
                </form:label>
              </div>
            </div>
            <div class="col text-center" style="margin-left: -220px; border-right: 1px solid black;">
              <form:label class="form-check-label" path = "scholarshipPercent" for="scholarshipPercent" >
                  Scholarship Percent
              </form:label>
              <form:input type="text" class="form-control" placeholder="Type Scolarship Percent" aria-label="scholarshipPercent" id = "scholarshipPercent" path = "scholarshipPercent" style="background-color: transparent; border-radius: 25px; box-shadow: 0 0 17px #fff;"/>
            </div>
            <div class="col text-center" >
                <form:button type="Submit" class="btn btn-dark">SUBMIT</form:button>
            </div>
          </div> 
        </form:form>
      </div>
      <br><br>
      <div class="text-center">
      	<a href = "/admin/manageStudents">
    	 	<button type="button" class="btn btn-success">Go Back</button>
      	</a>
      </div>
      
    </div>
    
   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  
    
   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    
  </body>
</html>