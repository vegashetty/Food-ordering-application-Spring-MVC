<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  <%
//get the category list
        com.foodapp.spring.dao.CuisineDAO cuisinedao = new com.foodapp.spring.dao.CuisineDAO();
        java.util.List cuisineList = cuisinedao.list();
        pageContext.setAttribute("cuisines", cuisineList);
%>  
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
   <link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
      <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
      <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
      
      <script>  $(function() {
          $( "#accordion-1" ).accordion();
      });
</script>
<style>
 #accordion-1{width: 600px;
 height : 600px;
         	}
         	#accordion-1 .ui-accordion-content{
  font-size:14px;
  background-color:#222;

}
table, th, td {
  
    padding: 5px;
    border-spacing: 15px;
}
	
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



		<div class="jumbotron fixed text-center">
			<div class="container"><br><br><br><br><br>
				<h1 style="color:white;">Welcome Chef ${sessionScope.chefName}</h1>
				<h3 style="color:black;">Get started and add your recipe below!</h3>
	</div>
	</div>	
	<div class="row menu" id="menu">
    <div class="container">
            <div class="col-sm-12">
            <div id="accordion-1">
    <h1>Add cuisine</h1>
    <div>
<%--        <form:form action="addcuisine.htm" commandName="cuisine" method="post"> --%>
<form action="addcuisine.htm" method="post">

<table>
<tr>
    <td>Cuisine Name:</td>
    <td><input type="text" name="cuisine_name" size="30" required/></td>
</tr>
<tr>
    <td colspan="2"><input type="submit" value="Add Cuisine" /></td>
</tr>
</table>
</form>
</div>
   <h1>Add recipe</h1>
    <div>
     <form:form action="addrecipe.htm" commandName="recipe" method="post" enctype="multipart/form-data">

<table>

<tr>
    <td>
<FONT COLOR="#FFFFFF"> Select Photo (Max size : 5 MB) </FONT><td><form:input path="photo" type="file"/>
 </td>
</tr>  
<br><br>
 <tr>
    <td><FONT COLOR="#FFFFFF">Recipe Name:</FONT></td>
    <td><form:input path="recipeName" size="30" required="required"/></td>
</tr>  
<br><br>
<tr>
    <td><FONT COLOR="#FFFFFF">Description</FONT></td>
    <td><form:input path="description" size="30" required="required" /> </td>
</tr>

<br><br>
<tr>
    <td><FONT COLOR="#FFFFFF">Price :</FONT></td>
    <td><form:input path="price" size="30" required="required"/> </font></td>
</tr>
<br><br>
  <tr> 
  <td><FONT COLOR="#FFFFFF">Cuisine:</FONT></td>
                    <td><form:select path="cuisine_name">
                            <c:forEach var="cuisine" items="${cuisines}">
                                <form:option value="${cuisine.cuisine_name}"/>
                            </c:forEach>
                        </form:select></td></tr>

 
<br><br>
<tr>
    <td><FONT COLOR="#FFFFFF">Distance radius for delivery :</FONT></td>
    <td><form:input path="distanceDelivery" size="30" required="required"/> </td>
</tr>
<tr>
    <td><FONT COLOR="#FFFFFF">Posted by :</FONT></td>
    <td><form:input path="postedBy" size="30" value="${sessionScope.chefName}"/> </td>
</tr>
<tr>
    <td colspan="2"><input type="submit" value="Add Recipe" /></td>
</tr>
</table>
  
</form:form>   
     </div>
    </div>
    
    </div></div></div>
    
</body>
</html>