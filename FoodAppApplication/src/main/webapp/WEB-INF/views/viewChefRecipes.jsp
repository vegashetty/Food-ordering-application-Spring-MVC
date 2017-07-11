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
  <center>
<br> <br>

<h2>Hi ${sessionScope.chefName} View your recipes below!</h2>

 <table border="1" cellpadding="5" cellspacing="5">
            <tr>
            <th><b>Photo</b></th>
                <th><b>Recipe Name</b></th>
                <th><b>Description</b></th>
              <th><b>Price</b></th>
                <th><b>Distance of Delivery</b></th>
                 <th>Update</th>
                               <th>Delete</th>
                
             
            </tr>
            <c:forEach var="rec" items="${recipeList}" begin="0" varStatus="status">
            <c:set var="i" value="${status.index}"/>
                <tr id ="row" value="${rec}">
                  <td> <img height="150" width="150" src="${rec.photoName}" /></td>
                    <td><input type="text" id="recipeName" value="${rec.recipeName}"/></td>
                    <td><input type="text" id="description${i}" value="${rec.description}"/></td>
                  <script>
              var b = ${i};
                  var a = document.getElementById("description"+ b).value;
               
                  </script>
               
 <td><input type="text" id="price${i}" value="${rec.price}"/></td>
   <script>
             
                  var c = document.getElementById("price"+ b).value;
               
                  </script>
 
                      <td><input type="text" id="distanceDelivery" value="${rec.distanceDelivery}"/></td>
                <script>
document.write('<td><a href = "delete.htm?id=${rec.id}&action=update&desc=' + a + '&price='+ c +'">Update </a></td>');
</script>
          <%--            <td><a href="delete.htm?id=${rec.id}&action=update&desc=" + > Update </a></td> --%>
                   
            <!--        onclick="location.href=this.href+'&desc='<script>a;</script>return false;"> -->
                    <td> <a href="delete.htm?id=${rec.id}&action=delete"> Delete</a></td>
                                      
                    
                </tr>
            </c:forEach>
                        
            
        </table>


</body>
</html>