package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.entity.Product;
import com.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService pserv;

    // Save product
    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product p) {
        return pserv.saveProduct(p);
    }

    // Save multiple products
    @PostMapping("/saveAll")
    public List<Product> saveAllProducts(@RequestBody List<Product> products) {
        return pserv.saveAllProducts(products);
    }

    // Get all products
    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return pserv.getAllProducts();
    }

    // Get product by id
    @GetMapping("/{pid}")
    public Product getProductById(@PathVariable int pid) {
        return pserv.getProductById(pid);
    }

    // Update product
    @PutMapping("/update/{pid}")
    public Product updateProduct(@PathVariable int pid, @RequestBody Product product) {
        return pserv.updateProduct(pid, product);
    }

    // Delete product
    @DeleteMapping("/delete/{pid}")
    public String deleteProduct(@PathVariable int pid) {
        pserv.deleteProduct(pid);
        return "Product Deleted Successfully";
    }

    // Find product by name
    @GetMapping("/name/{pname}")
    public List<Product> getByName(@PathVariable String pname) {
        return pserv.getByName(pname);
    }

    // Find product by category
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return pserv.getByCategory(category);
    }

    // Find products price greater than
    @GetMapping("/price/greater/{price}")
    public List<Product> priceGreater(@PathVariable double price) {
        return pserv.priceGreaterThan(price);
    }
    
    // Find products price greater than
    @GetMapping("/price/less/{price}")
    public List<Product> priceLess(@PathVariable double price) {
        return pserv.priceLessThan(price);
    }

    // Find products between price
    @GetMapping("/price/{min}/{max}")
    public List<Product> priceBetween(@PathVariable double min, @PathVariable double max) {
        return pserv.priceBetween(min, max);
    }

}