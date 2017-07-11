<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>Login here</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
.jumbotron{
	
 background-image: url(images/food.jpg); 
background-size: cover;
opacity: 0.7;
 min-height: 850px;  
   margin-top: -60px;
   margin-left: -20px;
   margin-right: -20px;

   -webkit-background-size: 100% 100%;
    -moz-background-size: 100% 100%;
    -o-background-size: 100% 100%;
    background-size: 100% 100%; 
}
</style>
</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
  <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
          <span class="glyphicon glyphicon-menu-hamburger"></span>
        </button>
         
           

      </div>
      <div class="collapse navbar-collapse" id="myNavbar" >
        <ul class="nav navbar-nav navbar-right" >
        <li>
        <a class="page-scroll" href="addcustomer.htm"  target="contents" >New user? Sign up</a> 
         
        </li>
         <li >      <a class="page-scroll" href="addchef.htm" target="contents">Register as chef</a> 
        
        </li> 
   <li >      <a class="page-scroll" href="login.htm" target="contents">Login</a> 
        
        </li> 
<!--    <li >      <a class="page-scroll" href="addadmin.htm" target="contents">Admin</a> 
        
        </li>    -->
 
        </ul>
      </div>
    </div>
  </nav>



		<div class="jumbotron fixed text-center">
			<div class="container"><br><br><br><br><br>
				<h1 style="color:white;">Welcome to HomeMade Food App!</h1>
				<h3 style="color:black;">For your home made food cravings!</h3>
	</div>
	</div>	
</body>
</html>