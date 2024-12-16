package com.education.ztu;

import com.education.ztu.dao.ProductDAO;
import com.education.ztu.model.Product;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();

        try {
            // Create table
            System.out.println("Adding new products...");
            productDAO.create(new Product("Laptop", "Electronics", 1200.99));
            productDAO.create(new Product("Phone", "Electronics", 799.49));

            // Retrieve all products
            System.out.println("Products in the database:");
            productDAO.getAll().forEach(System.out::println);

            // Update product
            Product product = productDAO.read(1);
            if (product != null) {
                product.setPrice(1100.00);
                productDAO.update(product);
            }

            // Delete product
            productDAO.delete(2);
            System.out.println("Products after deletion:");
            productDAO.getAll().forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
