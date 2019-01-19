package com.product.productdao;

import com.product.productdb.ProductDb;
import com.product.productmodel.ProductModel;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    Connection con = null;

    public ProductDaoImpl(){
        ProductDb db = new ProductDb();
        con = db.getConnection();
    }

    @Override
    public List<ProductModel> getAllProduct() {

        List<ProductModel> productModelList = new ArrayList<>();
        String sql = "select * from productmodel";
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement(sql);
            ResultSet resultSet= pstm.executeQuery();

            while(resultSet.next()){
                ProductModel productModel = new ProductModel();  //take from resultset and put into the productmodel obj
                int Pid= resultSet.getInt("pid");
                productModel.setPid(Pid);
                String Name = resultSet.getString("name");
                productModel.setName(Name);
                productModel.setType(resultSet.getString("type"));
                productModel.setBrand(resultSet.getString("brand"));        //shortcut of above two process

                productModelList.add(productModel); //add all the above attributes to the list made above and return that list.

            }

            return productModelList;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public List<ProductModel> getProductById(int id) {

        List<ProductModel> productModelList = new ArrayList<>();
        String sql = "select * from productmodel where pid = ?";
        PreparedStatement pstn = null;
        try {
            pstn =con.prepareStatement(sql);
            pstn.setInt(1,id);

            ResultSet resultSet= pstn.executeQuery();


            if(resultSet.next()){
                ProductModel productModel = new ProductModel();
                productModel.setPid(resultSet.getInt("pid"));
                productModel.setName(resultSet.getString("name"));
                productModel.setType(resultSet.getString("type"));
                productModel.setBrand(resultSet.getString("brand"));

                productModelList.add(productModel);

                return productModelList;


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ProductModel addProduct(ProductModel productModel) {

        String sql = "insert into productmodel (pid,name,type,brand) values(?,?,?,?)";
        try {
            PreparedStatement pstn =con.prepareStatement(sql);
            pstn.setInt(1,productModel.getPid());
            pstn.setString(2,productModel.getName());
            pstn.setString(3,productModel.getBrand());
            pstn.setString(4,productModel.getType());

          //  pstn.executeQuery(sql);//optional as executeuery also does the same thing only return types are diff resultset and int1...

            if(pstn.executeUpdate()!=0){
                return productModel;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteProduct(int id){
   // public ProductModel deleteProduct(int id) {
        String sql = "delete from productmodel where pid = ?";

        try {

            PreparedStatement pstm=con.prepareStatement(sql);
            pstm.setInt(1,id);

            if(pstm.executeUpdate()!=0){

                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public ProductModel updateProduct(ProductModel productModel) {

        String sql = "update productmodel set name =?,type=?,brand=?,date=? where pid=?";

        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,productModel.getName());
            pstm.setString(2,productModel.getType());
            pstm.setString(3,productModel.getBrand());
            pstm.setDate(4,productModel.getDate());
            pstm.setInt(5,productModel.getPid());

            if(pstm.executeUpdate()!=0){

                return productModel;

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
