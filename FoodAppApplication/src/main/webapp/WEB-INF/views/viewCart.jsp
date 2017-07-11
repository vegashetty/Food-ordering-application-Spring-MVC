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
table, th, td {
  
    padding: 5px;
    border-spacing: 15px;
   
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
        <li >      <a class="page-scroll" href="viewrecipe.htm" style="font-size:16px">Menu</a> 
        
        </li> 
  <li>
        <a class="page-scroll" href="searchrecipe.htm"  target="contents" > Search</a> 
         
        </li>
         <li>
        <a class="page-scroll" href="logout.htm?action=logout">Logout</a> 
         
        </li>

        </ul>
      </div>
    </div>
  </nav>

<%-- 
        <c:choose>
            <c:when test="${!empty sessionScope.customerId}">
                <jsp:include page="menu.jsp"/>
            </c:when>
            <c:otherwise>
                <jsp:include page="menu2.jsp"/>
            </c:otherwise>
        </c:choose> --%>
        <c:choose>
            <c:when test="${!empty sessionScope.cart}">
                <h3>Your cart contents</h3>
                <table border="1" align="center">
                    <tr>
                        <th>Name</th>
                          <th>Description</th>
                          
                        <th>Price</th>
                        
                         <th>Delete</th>
                 
                    </tr>
                    <c:forEach var="recipe" items="${sessionScope.cart}">
                        <tr>
                            <td>${recipe.recipeName}</td>
                            <td>${recipe.description}</td>
                               <td>${recipe.price}</td>
                               
                        <td> <a href="deleteItem.htm?id=${recipe.id}"> Delete</a></td>
                        </tr>
                   </c:forEach>
                    <tr><td></td><td></td></tr>
                    <tr>
                        <td colspan="3">Total</td>
                        <td>${sessionScope.total}</td>
                    </tr>
                </table>
                <br><br>
               <center> <a href="viewrecipe.htm"><< Shop More</a>&nbsp&nbsp&nbsp&nbsp&nbsp
                <a href="checkout.htm"> Checkout>></a></center>
                 
            </c:when>
            <c:otherwise>
            <br><br><br>
             <center>   <h3>Oops.. your cart is empty</h3>
                <p><a href="viewrecipe.htm">Return to shopping</a></p>
            </c:otherwise>
        </c:choose>
   

</body>
</html>