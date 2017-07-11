<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   
<!--   <script>
   var xmlHttp;
   xmlHttp = GetXmlHttpObject();
 
function getResults() {

            if (xmlHttp == null)
            {
                alert("Your browser does not support AJAX!");
                return;
            }

            xmlHttp.onreadystatechange = function()
            {
         
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
                	
                {
                
                     document.getElementById("results").innerHTML = "";
                
                    var json = JSON.parse(xmlHttp.responseText);
                    //json = json[0];
                    //json = recipes[count]
                    //var json = JSON.stringify(xmlHttp.responseText);
                    if (json.recipes.length > 0) {
                      

                        var x = document.createElement("TABLE");
                        x.setAttribute("id", "myTable");
                        document.getElementById("results").appendChild(x);
                        var y = document.createElement("TR");
                        y.setAttribute("id", "myTr");
                        document.getElementById("myTable").appendChild(y);

                        var z = document.createElement("TH");
                        var t = document.createTextNode("Recipe Name");

                        z.appendChild(t);
                        document.getElementById("myTr").appendChild(z);

                        var z = document.createElement("TH");
                        var t = document.createTextNode("Description");
                        z.appendChild(t);
                        document.getElementById("myTr").appendChild(z);

                    	//console.log(json.recipes[0].recipeName);

                        for (var count = 0; count < json.recipes.length; count++) {
                        
                           
                            var y = document.createElement("TR");
                            y.setAttribute("id", "myTr" + count);
                            document.getElementById("myTable").appendChild(y);
							var test = json.recipes[count];
							
                            var z = document.createElement("TD");
                            
                            var t = document.createTextNode(json.recipes[count].recipeName);
                            z.appendChild(t);
                            document.getElementById("myTr" + count).appendChild(z);

                            var z = document.createElement("TD");
                            var t = document.createTextNode(json.recipes[count].description);
                            z.appendChild(t);
                            document.getElementById("myTr" + count).appendChild(z);
                            
                            var z = document.createElement("TD");
                            var a = document.createElement('a');
                            var id = json.recipes[count].recipeid;
                            var rowID = "myTr" + count;
                            var linkText = document.createTextNode("Approve");
                            a.appendChild(linkText);
                            a.title = "Approve";
                            a.onclick = (function (rowID) {
                                return function () {
                                    approveRow(rowID);
                                }
                            })(id, rowID);
                            z.appendChild(a);
                            document.getElementById("myTr" + count).appendChild(z);
                        
                         
                        }
                    } else {
                        document.getElementById("results").innerHTML="Nothing Found";
                    }
                } 
            };
            xmlHttp.open("GET", "listrecipes.htm", true);
            //xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlHttp.send();
            return false;
        }

   

        function GetXmlHttpObject()
        {
            var xmlHttp = null;
            try
            {
                // Firefox, Opera 8.0+, Safari
                xmlHttp = new XMLHttpRequest();
            } catch (e)
            {
                // Internet Explorer
                try
                {
                    xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e)
                {
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
            }
            return xmlHttp;
        }
        </script> 
</head>
<body>
Welcome Admin! <br>

        

        <b>Click here to view the recipes to be approved </b>
        Approve following to make change
        
        <a href="/listrecipes.htm"> Click </a>
            <div id="searchForm">
    

            <div id="results">

            </div>
          
        </div> -->
        
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
         
           <ul class="nav navbar-nav navbar-right" >
         <li>
        <a class="page-scroll" href="logout.htm">Logout</a> 
         
        </li>

        </ul>
      </div>
    </div>
  </nav>
    <br><br>
  <center>
    <br><br>  <br><br>
  <table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <td><b>Recipe Name</b></td>
                <td><b>Description</b></td>
              <td><b>Price</b></td>
                <td><b>Distance of Delivery</b></td>
                                <td><b>Posted by</b></td>
                                        <td><b>Photo</b></td>
                       <td><b>Approve</b></td>
                        <td><b>Email</b></td>
             
            </tr>
            <c:forEach var="rec" items="${recipeList}">
                <tr>
                    <td>${rec.recipeName}</td>
                    <td>${rec.description}</td>
                  <td>${rec.price}</td>
                    <td>${rec.distanceDelivery}</td>
                                        <td>${rec.chef.firstName}</td>
                                         <td> <img height="150" width="150" src="${rec.photoName}" /></td>
                                        <td><a href="approve.htm?id=${rec.id}"> Approve</td></a>
                                        <td><a href="email.htm"> E-mail</td></a>
                    
                </tr>
            </c:forEach>
        </table>
    

</body>
</html>