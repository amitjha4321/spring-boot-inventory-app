<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<html>
    <head>
        <title> Edit product </title>

    </head>

    <body>

    <div class = "container">


    <h1> Edit Product </h1>

         <form method = "post" action = "/product/updateviaform">
                  <div class="form-group">
                        <label>Enter Product ID</label>
                        <input type="text" class="form-control" name = "form_product_id" value = "${product.pid}">

                  </div>
                   <div class="form-group">
                          <label>Enter Product Name</label>
                          <input type="text" class="form-control" name = "form_product_name" value = "${product.name}">

                    </div>

                   <div class="form-group">
                          <label >Enter Product Type</label>
                          <input type="text" class="form-control" name = "form_product_type" value = "${product.type}">

                    </div>

                     <div class="form-group">
                            <label >Enter Product Brand</label>
                            <input type="text" class="form-control" name = "form_product_brand" value  = "${product.brand}">

                      </div>

                      <div class="form-group">
                              <label >Date</label>
                              <input type="text" class="form-control" name = "form_product_date" value = "${product.date}">

                    </div>


                  <button type="submit" class="btn btn-primary">Save</button>
        </form>

         <a href = "homepage" type="button" class="btn btn-primary">Go home</a>



    </div>




    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


    </body>

</html>



