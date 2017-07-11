

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
        
        <%
//get the category list
        com.foodapp.spring.dao.CuisineDAO cuisinedao = new com.foodapp.spring.dao.CuisineDAO();
        java.util.List cuisineList = cuisinedao.list();
        pageContext.setAttribute("cuisines", cuisineList);
      //get the category list
 
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
<style>

#page-top{
background-image: url("images/12.jpg");
background-repeat: no-repeat;
 background-size: cover;

}
table, th, td {
  
    padding: 5px;
    border-spacing: 15px;
   
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
        <a class="page-scroll" href="viewCartItems.htm">View Cart</a> 
         
        </li>
 <li>
        <a class="page-scroll" href="logout.htm">Logout</a> 
         
        </li>
        </ul>
      </div>
    </div>
  </nav>
  <br><br><br><br>
<center>
 
                                    
  <table border="1" cellpadding="5" cellspacing="5">
            <tr>
            <td><b>Photo</b></td>
                <td><b>Recipe Name</b></td>
                <td><b>Description</b></td>
              <td><b>Price</b></td>
                
                <td><b>Distance of Delivery</b></td>
                                <td><b>Posted by</b></td>
                                    <td><b>Add to Cart</b></td>
                
             
            </tr>
            <c:forEach var="rec" items="${dish}">
                <tr>
                 <td> <img height="150" width="150" src="${rec.photoName}" /></td>
                    <td>${rec.recipeName}</td>
                    <td>${rec.description}</td>
                  <td>${rec.price}</td>
             
             
                    <td>${rec.distanceDelivery}</td>
                                        <td>${rec.chef.firstName}</td>
                                        
 <td><a href="addtocart.htm?id=${rec.id}&action=addtocart">Add to Cart</a></td>                    
                </tr>
            </c:forEach>
        </table>
  
</body>
</html>