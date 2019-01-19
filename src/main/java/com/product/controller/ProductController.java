package com.product.controller;


import com.product.productmodel.ProductModel;
import com.product.productservice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;


    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView getAllProducts() {

        ModelAndView modelAndView = new ModelAndView("productlist");

        List<ProductModel> productModelList = productService.getStudents();

        modelAndView.addObject("product_list", productModelList); //replaces productModellist with product_list and display in browser

        return modelAndView;
    }

    @RequestMapping(value = "/viewform", method = RequestMethod.GET)
    public ModelAndView getEmptyForm() {

        ModelAndView modelAndView = new ModelAndView("emptyform");

        return modelAndView;
    }
    @RequestMapping(value = "/editpage/{id}", method = RequestMethod.GET)
    public ModelAndView getEditForm(@PathVariable int id) {

        List<ProductModel> productModelList = productService.findProductById(id);
        ProductModel productModel = productModelList.get(0);

        ModelAndView modelAndView = new ModelAndView("editform");
        modelAndView.addObject("product", productModel);

        return modelAndView;
    }


    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public ModelAndView getHomePage() {

        ModelAndView modelAndView = new ModelAndView("home_page");

        return modelAndView;
    }



    @RequestMapping(value="/getbyid/{id}")
    public  ModelAndView getProductById(@PathVariable(value = "id") int id){

        ModelAndView modelAndView = null;

        List<ProductModel> productModelList = productService.findProductById(id);

        if (productModelList == null){
            modelAndView = new ModelAndView("product_list_failure");
            return modelAndView;
        } else {
            modelAndView = new ModelAndView("product_list_success");
            modelAndView.addObject("product_list", productModelList);
            return modelAndView;
        }
    }
    @RequestMapping(value = "/addproduct")
    public ModelAndView addProduct(@RequestBody ProductModel productModel){

        ModelAndView modelAndView = new ModelAndView("productlist");
        ProductModel productMode =productService.addpProductinDb(productModel);
       // modelAndView.addObject("")

        return modelAndView;
    }

    @PostMapping(value = "/addproductv2")
    public String addProductViaForm(@RequestParam("form_product_id  ") Integer productId,
                                          @RequestParam("form_product_name") String productName,
                                          @RequestParam("form_product_type") String productType,
                                          @RequestParam("form_product_brand") String productBrand,
                                          @RequestParam("form_product_date") String date){

        ProductModel productModel = new ProductModel();
        productModel.setPid(productId);
        productModel.setName(productName);
        productModel.setType(productType);
        productModel.setBrand(productBrand);
        //productModel.setDate(p);


        //ModelAndView modelAndView = new ModelAndView("productlist");
        ProductModel productMode =productService.addpProductinDb(productModel);
        // modelAndView.addObject("")

        //List<ProductModel> productModelList = productService.getStudents();

        //modelAndView.addObject("product_list", productModelList); //replaces productModellist with product_list and display in browser



        return "redirect:/product/get";
    }



    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String deleteProduct(@PathVariable(value = "id") int id){

        ModelAndView modelAndView = new ModelAndView("productlist");
        boolean isDeleteSuccessful = productService.deleteProduct(id);

      // if (isDeleteSuccessful == false){
            // 400 -- BAD REQUEST
           //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       // }

        // modelAndView.addObject("product_");

        //localhost:8080/product/delete/10
        //http://localhost:8080/product/delete/product/get -- redirect:product/get
        //http://localhost:8080/product/delete/get

        return "redirect:/product/get";



    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateProduct(@RequestBody  ProductModel productModel) {

        ModelAndView modelAndView = new ModelAndView("productlist");
        ProductModel productMode = productService.updateProduct(productModel);


        //inssert, update, delete


        return "redirect:/product/get";
    }

    @RequestMapping(value = "/updateviaform",method = RequestMethod.POST)
    public String updateProduct(@RequestParam("form_product_id") Integer productId,
                                @RequestParam("form_product_name") String productName,
                                @RequestParam("form_product_type") String productType,
                                @RequestParam("form_product_brand") String productBrand,
                                @RequestParam("form_product_date") String date){

        ProductModel productModel = new ProductModel();
        productModel.setPid(productId);
        productModel.setName(productName);
        productModel.setType(productType);
        productModel.setBrand(productBrand);
        //productModel.setDate(p);

        //ModelAndView modelAndView = new ModelAndView("productlist");
        ProductModel productMode = productService.updateProduct(productModel);


        //inssert, update, delete


        return "redirect:/product/get";
    }






}
