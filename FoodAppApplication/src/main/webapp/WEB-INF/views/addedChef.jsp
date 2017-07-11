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
	
 background-image: url(images/chef1.png); 
background-size: cover;

 min-height: 450px;  
   margin-top: -60px;
   margin-left: -20px;
   margin-right: -20px;

   -webkit-background-size: 100% 100%;
    -moz-background-size: 100% 100%;
    -o-background-size: 100% 100%;
    background-size: 100% 100%; 
}
.menu{

 background-image: url(images/chef.jpg); 
background-size: cover;
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
        <a class="page-scroll" href="addcustomer.htm"  target="contents" > Sign up</a> 
         
        </li>
        <li >      <a class="page-scroll" href="addcustomer.htm#menu" style="font-size:16px">Menu</a> 
        
        </li> 
 

        </ul>
      </div>
    </div>
  </nav>



		<div class="jumbotron fixed text-center">
			<div class="container"><br><br><br><br><br>
				<h1 style="color:white;">Welcome Chef ${chef.firstName}</h1>
				<h3 style="color:black;">Get started and add your recipe below!</h3>
	</div>
	</div>	
	<div class="row menu" id="menu">
    <div class="container">
            <div class="col-sm-12">
    <h1>Menu</h1>
        <form:form action="addcuisine.htm" command="cuisine" method="post">

<table>
<tr>
    <td>Cuisine Name:</td>
    <td><form:input path="name" size="30" /><font color="red"><form:errors path="name"/></font></td>
</tr>
<tr>
    <td colspan="2"><input type="submit" value="Add Cuisine" /></td>
</tr>
</table>
</form:form> --%>
    <%-- <form:form action="addrecipe.htm" commandName="recipe" method="post">

<table>
<tr>
    <td>Recipe Name:</td>
    <td><form:input path="recipeName" size="30" /></td>
</tr>
<br><br>
<tr>
    <td>Description</td>
    <td><form:input path="description" size="30" /> </td>
</tr>

<br><br>
<tr>
    <td>Price :</td>
    <td><form:input path="price" size="30" /> </td>
</tr>
<br><br>
<tr>
    <td>Cuisine:</td>
    <td><form:input path="cuisine" size="30" /></td>
</tr>

 
<br><br>
<tr>
    <td colspan="2"><input type="submit" value="Add Recipe" /></td>
</tr>
</table>
  
</form:form>
     --%>
    
    
    </div></div></div>
    
</body>
</html>