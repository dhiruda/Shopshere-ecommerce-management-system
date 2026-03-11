package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Find by product name
    List<Product> findByPname(String pname);

    // Find by price
    List<Product> findByPrice(double price);

    // Find by quantity
    List<Product> findByQuantity(int quantity);

    // Find by category
    List<Product> findByCategory(String category);

    // Find products greater than price
    List<Product> findByPriceGreaterThan(double price);

    // Find products less than price
    List<Product> findByPriceLessThan(double price);

    // Find products between price
    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    // Find products by name containing keyword
    List<Product> findByPnameContaining(String keyword);

    // Find products starting with name
    List<Product> findByPnameStartingWith(String prefix);

    // Find products ending with name
    List<Product> findByPnameEndingWith(String suffix);

    // Find products with quantity greater than
    List<Product> findByQuantityGreaterThan(int quantity);

    // Find products with quantity less than
    List<Product> findByQuantityLessThan(int quantity);

    // Find products by category and price
    List<Product> findByCategoryAndPrice(String category, double price);

    // Find products by category or price
    List<Product> findByCategoryOrPrice(String category, double price);

}