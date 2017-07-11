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

  background-image: url(images/food1.jpg); 
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
         <li>
        <a class="page-scroll" href="addcustomer.htm"  target="contents" > Sign up</a> 
         
        </li>

        </ul>
      </div>
    </div>
  </nav>
  <script type="text/javascript">  
          $(document).ready(function(){  
              $(".uname").change(function(){  
                  var uname = $(this).val();  
                  if(uname.length >= 3){  
                       $.ajax({  
                          type: "POST",  
                          url: "/addcustomer.htm",
						  //url: "isUserNameUnique.htm"
                          data: "username="+ uname,  
                          success: function(msg){  
  
                              $(".status").ajaxComplete(function(event, request, settings){  
                                     
                                  $(".status").html(msg);  
  
                              });  
                          }  
                      });   
                  }  
                  else{  
                         
                      $(".status").html("<font color=red>Username should be <b>3</b> character long.</font>");  
                  }  
                    
              });  
          });  
        </script>  
  <center><br><br><br>
<h2 style="color:LightGrey;">Register a New User</h2>
    <div class="row register">
    <div class="container">
            <div class="col-sm-12">
    
     <form:form action="addcustomer.htm" commandName="customer" method="post">

<table>
<tr>
    <td>First Name:</td>
    <td><form:input path="firstName" size="30" /> <font color="red"><form:errors path="firstName"/></font></td>
</tr>
<br><br>
<tr>
    <td>Last Name:</td>
    <td><form:input path="lastName" size="30" /> <font color="red"><form:errors path="lastName"/></font></td>
</tr>

<br><br>
<tr>
    <td>User Name:</td>
    <td><form:input path="username"  class="uname" size="30" /> <span class="status"></span><font color="red"><form:errors path="username"/></font></td>
</tr>
<br><br>
<tr>
    <td>Password:</td>
    <td><form:password path="password" size="30" /> <font color="red"><form:errors path="password"/></font></td>
</tr>

  <tr>
    <td>Email Id:</td>
    <td><form:input path="email" size="30" /> <font color="red"><form:errors path="email"/></font></td>
</tr> 
  <tr>
    <td>Address:</td>
    <td><form:input path="address" size="30" /> <font color="red"><form:errors path="address"/></font></td>
</tr>
  <tr>
    <td>Number:</td>
    <td><form:input path="number" size="30" value="" pattern="[0-9]{10}" required="required" /> <font color="red"><form:errors path="number"/></font></td>
</tr>

<br><br>
<tr>
    <td colspan="2"><input type="submit" value="Create User" /></td>
</tr>
</table>
  
</form:form>
        </div>
</div>
</div>


</body>
</html>