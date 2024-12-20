package com.shakhawat.springgraphqlserver.repository;

import com.shakhawat.springgraphqlserver.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategoryEqualsIgnoreCase(String category);
}
