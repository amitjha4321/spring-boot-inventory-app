package com.product.productdb;

import java.sql.Connection;
import java.sql.DriverManager;

public class ProductDb {

    public Connection getConnection(){

         try {
              Class.forName("com.mysql.jdbc.Driver");
                 return DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","");
            } catch (Exception e) {
        e.printStackTrace();
              }

    return null;
}

}
