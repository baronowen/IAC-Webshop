package Tests;

import Model.Product;
import Persistance.ProductController;
import Webservices.ProductResource;
import Webservices.Resource;
import io.jsonwebtoken.lang.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductResourceTest {

    @org.junit.jupiter.api.Test
    void getAllProducts() {
        ProductResource pTest = new ProductResource();
        Assert.notNull(pTest.getAllProducts());
    }

    @org.junit.jupiter.api.Test
    void getProductById() {
        ProductResource pTest = new ProductResource();
        ProductController p = ProductController.getInstance();
        ArrayList<Product> products = p.findAll();
        Assert.notNull(pTest.getProductById(products.get(0).getId()));
    }

    @org.junit.jupiter.api.Test
    void createProduct() {
        ProductResource pTest = new ProductResource();
        Assert.notNull(pTest.createProduct("UnitTest",10, "Een product gemaakt door de test"));
    }
}