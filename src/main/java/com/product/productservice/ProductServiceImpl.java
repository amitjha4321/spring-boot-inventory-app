package com.product.productservice;

import com.product.productdao.ProductDao;
import com.product.productmodel.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;


    @Override
    public List<ProductModel> getStudents() {


        return productDao.getAllProduct();
    }

    @Override
    public List<ProductModel> findProductById(int id) {
        return productDao.getProductById(id); //when calling the method variable type is no reuired...
    }

    @Override
    public ProductModel addpProductinDb(ProductModel productModel) {
        return productDao.addProduct(productModel);
    }

    @Override
    public boolean deleteProduct(int id) {

        return productDao.deleteProduct(id);
    }

    @Override
    public ProductModel updateProduct(ProductModel productModel) {
        return productDao.updateProduct(productModel);
    }
}
