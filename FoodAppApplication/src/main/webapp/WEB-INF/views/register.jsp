<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
         <li>
        <a class="page-scroll" href="addcustomer.htm"  target="contents" > Sign up</a> 
         
        </li>

        </ul>
      </div>
    </div>
  </nav>
  	<div class="jumbotron fixed text-center">
			<div class="container"><br><br>
				<h1 style="color:black;">Welcome to HomeMade Food App!</h1>
				<h3 style="color:white;">Join our team as a chef!</h3>
	</div>
	</div>
	 
  
	
  <center><br><br><br>
<h2>Register as Chef</h2>
    <div class="row register">
    <div class="container">
            <div class="col-sm-12">
    
     <form:form action="addchef.htm" commandName="chef" method="post">

<table>
<tr>
    <td>First Name:</td>
    <td><form:input path="firstName" size="30" /><font color="red"><form:errors path="firstName"/></font></td>
</tr>
<br><br>
<tr>
    <td>Last Name:</td>
    <td><form:input path="lastName" size="30" /> <font color="red"><form:errors path="lastName"/></font></td>
</tr>

<br><br>
<tr>
    <td>User Name:</td>
    <td><form:input path="username" size="30" /> <font color="red"><form:errors path="username"/> </font></td>
</tr>
<br><br>
<tr>
    <td>Password:</td>
    <td><form:password path="password" size="30" /><font color="red"><form:errors path="password"/> </font></td>
</tr>

  <tr>
    <td>Email Id:</td>
    <td><form:input path="email" size="30" /> <font color="red"><form:errors path="email"/></font> </td>
</tr> 
  <tr>
    <td>Address:</td>
    <td><form:input path="address" size="30" /> </td>
</tr>
  <tr>
    <td>Number:</td>
    <td><form:input path="number" size="30"  pattern="[0-9]{9}" />  <font color="red"><form:errors path="number"/></font></td>
</tr>
 <tr>
    <td>Speciality:</td>
    <td><form:input path="speciality" size="30" /> </td>
</tr>
<br><br>
<tr>
    <td colspan="2"><input type="submit" value="Register" /></td>
</tr>
</table>

</form:form>
        </div>
</div>
</div>


</body>
</html>