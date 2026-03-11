package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository prepo;

    
    // Save product
    public Product saveProduct(Product product) {
        return prepo.save(product);
    }

    // Save multiple products
    public List<Product> saveAllProducts(List<Product> products) {
        return prepo.saveAll(products);
    }

    // Get all products
    public List<Product> getAllProducts() {
        return prepo.findAll();
    }

    // Get product by id
    public Product getProductById(int pid) {
        return prepo.findById(pid).orElse(null);
    }

    // Delete product
    public void deleteProduct(int pid) {
        prepo.deleteById(pid);
    }

    // Update product
    public Product updateProduct(int pid, Product product) {

        Product p = prepo.findById(pid).orElse(null);

        if (p != null) {
            p.setPname(product.getPname());
            p.setPrice(product.getPrice());
            p.setQuantity(product.getQuantity());
            p.setCategory(product.getCategory());

            return prepo.save(p);
        }

        return null;
    }

    // Find by product name
    public List<Product> getByName(String pname) {
        return prepo.findByPname(pname);
    }

    // Find by price
    public List<Product> getByPrice(double price) {
        return prepo.findByPrice(price);
    }

    // Find by quantity
    public List<Product> getByQuantity(int quantity) {
        return prepo.findByQuantity(quantity);
    }

    // Find by category
    public List<Product> getByCategory(String category) {
        return prepo.findByCategory(category);
    }

    // Price greater than
    public List<Product> priceGreaterThan(double price) {
        return prepo.findByPriceGreaterThan(price);
    }

    // Price less than
    public List<Product> priceLessThan(double price) {
        return prepo.findByPriceLessThan(price);
    }

    // Price between
    public List<Product> priceBetween(double min, double max) {
        return prepo.findByPriceBetween(min, max);
    }

    // Product name containing keyword
    public List<Product> nameContains(String keyword) {
        return prepo.findByPnameContaining(keyword);
    }

    // Product name starting with
    public List<Product> nameStartsWith(String prefix) {
        return prepo.findByPnameStartingWith(prefix);
    }

    // Product name ending with
    public List<Product> nameEndsWith(String suffix) {
        return prepo.findByPnameEndingWith(suffix);
    }

    // Quantity greater than
    public List<Product> quantityGreaterThan(int quantity) {
        return prepo.findByQuantityGreaterThan(quantity);
    }

    // Quantity less than
    public List<Product> quantityLessThan(int quantity) {
        return prepo.findByQuantityLessThan(quantity);
    }

    // Category AND price
    public List<Product> categoryAndPrice(String category, double price) {
        return prepo.findByCategoryAndPrice(category, price);
    }

    // Category OR price
    public List<Product> categoryOrPrice(String category, double price) {
        return prepo.findByCategoryOrPrice(category, price);
    }

}