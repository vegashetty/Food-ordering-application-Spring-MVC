<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add User Form</title>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<style>
#page-top{

  background-image: url(images/chef3.jpg); 
background-size: cover;

}
.jumbotron{
	
 background-image: url(images/chef.jpg); 
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
        <a class="page-scroll" href="addrecipe.htm">Add Recipes</a> 
         
        </li>
         <li>
        <a class="page-scroll" href="viewChefRecipes.htm">View Recipes</a> 
         
        </li>
          <li>
        <a class="page-scroll" href="logout.htm">Logout</a> 
         
        </li>

        </ul>
      </div>
    </div>
  </nav>
    <br><br>
  <center><h1>Recipe Added Successfully!</h1>

    <!--   <a href="addcuisine.htm"> Add cuisine !</a>  -->
   <h3><a href="addrecipe.htm"> Click here to Add Another recipe !</a>  </h3> 
   <h3>  <a href="viewChefRecipes.htm"> View Recipes !</a> </h3> </center>

</body>
</html>