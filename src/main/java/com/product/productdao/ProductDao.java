package com.product.productdao;

import com.product.productmodel.ProductModel;

import java.util.List;

public interface ProductDao {

    List<ProductModel> getAllProduct();

    List<ProductModel> getProductById(int id);

    ProductModel addProduct(ProductModel productModel);

    boolean deleteProduct(int id);

    ProductModel updateProduct(ProductModel productModel);

}
