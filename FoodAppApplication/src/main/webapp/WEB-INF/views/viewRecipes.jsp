<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
   <script>
   var xmlHttp;
   xmlHttp = GetXmlHttpObject();
function getResults() {
            if (xmlHttp == null)
            {
                alert("Your browser does not support AJAX!");
                return;
            }
   /*          var key = document.getElementById("name").value;
            var flag = document.querySelector('input[name = "search"]:checked').value;*/
            //var query = 
            xmlHttp.onreadystatechange = function stateChanged()
            {
                if (xmlHttp.readyState == 4)
                {
                     alert("in ready state");
                    document.getElementById("results").innerHTML = "";
                    var json = JSON.parse(xmlHttp.responseText);
                    if (json.recipes.length > 0) {
                      	 alert("Your browser support AJAX!");

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

                    

                        for (var count = 0; count < json.recipes.length; count++) {
                         	 alert("Your browser support AJAX!");

                            var y = document.createElement("TR");
                            y.setAttribute("id", "myTr" + count);
                            document.getElementById("myTable").appendChild(y);

                            var z = document.createElement("TD");
                            var t = document.createTextNode(json.recipes[count].recipeName);
                            z.appendChild(t);
                            document.getElementById("myTr" + count).appendChild(z);

                            var z = document.createElement("TD");
                            var t = document.createTextNode(json.recipes[count].description);
                            z.appendChild(t);
                            document.getElementById("myTr" + count).appendChild(z);

                         
                        }
                    } else {
                        document.getElementById("results").innerHTML="Nothing Found";
                    }
                }
            };
            xmlHttp.open("POST", "/listrecipes.htm", true);
            xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlHttp.send(query);
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

        <b> Recipes to be approved </b>
        Approve following to make change
        
        <button onclick="getResults()"> Click </button>
            <div id="searchForm">
    

            <div id="results">

            </div>
          
        </div>
  <%--   <table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <td><b>Recipe Name</b></td>
                <td><b>Description</b></td>
              <td><b>Price</b></td>
                <td><b>Distance of Delivery</b></td>
                                <td><b>Posted by</b></td>
                
             
            </tr>
            <c:forEach var="rec" items="${recipes}">
                <tr>
                    <td>${rec.recipeName}</td>
                    <td>${rec.description}</td>
                  <td>${rec.price}</td>
                    <td>${rec.distanceDelivery}</td>
                                        <td>${rec.chef.firstName}</td>
                    
                </tr>
            </c:forEach>
        </table>
    --%>
</body>
</html>