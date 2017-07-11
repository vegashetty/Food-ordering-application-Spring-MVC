<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
           <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
       
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
	
 background-image: url(images/food2.jpg); 
background-size: cover;

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
       
        <li >      <a class="page-scroll" href="viewrecipe.htm" style="font-size:16px">Menu</a> 
        
        </li> 
  <li>
        <a class="page-scroll" href="searchrecipe.htm"  target="contents" > Search</a> 
         
        </li>
 <li>
        <a class="page-scroll" href="logout.htm">Logout</a> 
         
        </li>
        </ul>
      </div>
    </div>
  </nav>



		<div class="jumbotron fixed text-center">
			<div class="container"><br><br><br><br><br>
				<h1 style="color:white;">Welcome ${login.username}</h1>
				<h3 style="color:black;">Get started and Order from the menu below!</h3>
				

   <b>  Get Started! </b> <a href="viewrecipe.htm"> Click here to view our dishes !</a> 
	</div>
	</div>	
	<div class="row menu" id="menu">
    <div class="container">
            <div class="col-sm-12">
    <h1>Menu</h1>
    
    <h2><b>  Get Started! </b> <a href="searchrecipe.htm"> Click here to view our dishes !</a> </h2>

  
    
    </div></div></div>
    
</body>
</html>