package com.shakhawat.springgraphqlserver.controller;

import com.shakhawat.springgraphqlserver.entity.Product;
import com.shakhawat.springgraphqlserver.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductService productService;

    @MutationMapping
    public Product saveProduct(@Argument String name, @Argument String category, @Argument float price, @Argument int stock) {
        Product product = new Product(name, category, price, stock);
        return productService.addProduct(product);
    }

    @MutationMapping
    public Product updateStock(@Argument int id, @Argument int stock) {
        return productService.updateStock(id, stock);
    }

    @MutationMapping
    public Product receiveNewShipment(@Argument int id, @Argument int quantity) {
        return productService.receiveNewShipment(id, quantity);
    }

    @MutationMapping
    public String deleteProduct(@Argument int id) {
        try {
            return productService.deleteProduct(id);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @QueryMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @QueryMapping
    public Product getProduct(@Argument int id) {
        return productService.getProductById(id);
    }

    @QueryMapping
    public List<Product> getProductsByCategory(@Argument String category) {
        return productService.getProductsByCategory(category);
    }

}
