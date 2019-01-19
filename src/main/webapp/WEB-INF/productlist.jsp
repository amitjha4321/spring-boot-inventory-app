<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<html>
    <head>
    <title> Product List </title>
    </head>

    <body>

    <div class = "container">
       <!-- <table border = 1 style = "margin:300px;"> -->

     <table class  = "table table-bordered table-hover">
        <thead>
            <th>Product ID   </th>
            <th>Name</th>
            <th>Type</th>
            <th>Brand</th>
            <th>Date</th>
            <th>Delete</th>
            <th>Edit</th>

        </thead>
        <tbody>
              <c:forEach items="${product_list }" var="product">
                    <tr>
                           <td>${product.pid }</td>
                             <td >${product.name }</td>
                              <td>${product.type }</td>
                           <td>${product.brand }</td>
                            <td>${product.date }</td>
                          <td>  <a href = "delete/${product.pid}" type="button" class="btn btn-primary btn-sm">Delete</a></td>
                            <td>  <a href = "editpage/${product.pid}" type="button" class="btn btn-primary btn-sm">Edit</a></td>
                    </tr>

                 </c:forEach>
           </tbody>

        </table>


        <a href = "homepage" type="button" class="btn btn-primary">Go home</a>







    </div>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


    </body>

</html>



