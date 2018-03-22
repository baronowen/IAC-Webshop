package Tests;

import Model.Product;
import Persistance.ProductController;
import Webservices.ProductResource;
import Webservices.Resource;
import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductResourceTest {

    @Test
    void getAllProducts() {
        ProductResource pTest = new ProductResource();
        Assert.notNull(pTest.getAllProducts());
    }

    @Test
    void getProductById() {
        ProductResource pTest = new ProductResource();
        ProductController p = ProductController.getInstance();
        ArrayList<Product> products = p.findAll();
        Assert.notNull(pTest.getProductById(products.get(0).getId()));
    }

    @Test
    void createProduct() {
        ProductResource pTest = new ProductResource();
        Assert.notNull(pTest.createProduct("UnitTest",10, "Een product gemaakt door de test"));
        Assert.notNull(pTest.createProduct("UnitTest",-20, "Een product gemaakt door de test"));
    }
    @Test
    void _createProduct() {
        ProductResource pTest = new ProductResource();
        Assert.notNull(pTest.createProduct("UnitTest",-20, "Een product gemaakt door de test"));
    }
}