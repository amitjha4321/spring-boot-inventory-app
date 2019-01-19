package com.product.productservice;

import com.product.productmodel.ProductModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<ProductModel> getStudents();

   // List<ProductModel> findProductById(int id);
   List<ProductModel> findProductById(int id);

    ProductModel addpProductinDb(ProductModel productModel);

    boolean deleteProduct(int id);

    ProductModel updateProduct(ProductModel productModel);




}
