package com.shakhawat.springgraphqlserver.service;

import com.shakhawat.springgraphqlserver.entity.Product;
import com.shakhawat.springgraphqlserver.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found with id " + id));
    }

    public List<Product> getProductsByCategory(String category){
        return productRepository.findByCategoryEqualsIgnoreCase(category);
    }

    //sales team : update the stock of a product in (IS)
    public Product updateStock(int id, int stock) {

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found with id " + id));

        existingProduct.setStock(stock);
        return productRepository.save(existingProduct);
    }

    //warehouse : receive new shipment
    public Product receiveNewShipment(int id, int quantity) {

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("product not found with id " + id));

        existingProduct.setStock(existingProduct.getStock() + quantity);
        return productRepository.save(existingProduct);
    }

    public String deleteProduct(int productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + productId));
        productRepository.delete(product);

        return "Product deleted successfully";
    }

}
