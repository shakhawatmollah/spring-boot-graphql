package com.shakhawat.springgraphqlclient.controller;

import com.shakhawat.springgraphqlclient.dto.Item;
import com.shakhawat.springgraphqlclient.dto.ItemRequest;
import com.shakhawat.springgraphqlclient.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    @GetMapping("/products")
    public ResponseEntity<List<Item>> getProducts() {
        List<Item> products = catalogService.viewProducts();
        return products.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(products);
    }

    @GetMapping("/products/{category}")
    public List<Item> viewProductsByCategory(@PathVariable String category) {
        return catalogService.viewProductsByCategory(category);
    }

    @GetMapping("/item/{id}")
    public Item viewProductById(@PathVariable String id) {
        return catalogService.viewProductById(id);
    }

    @PostMapping("/shipment")
    public ResponseEntity<Item> receiveNewShipment(@RequestBody ItemRequest itemRequest) {
        Item item = catalogService.receiveNewShipment(itemRequest);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PostMapping("/update-item")
    public ResponseEntity<Item> updateProduct(@RequestBody ItemRequest request) {
        Item updatedItem = catalogService.updateProduct(request);
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }

    @PostMapping("/save-item")
    public ResponseEntity<Item> saveItem(@RequestBody Item item) {
        Item savedItem = catalogService.saveItem(item);
        return new ResponseEntity<>(savedItem, HttpStatus.OK);
    }

    @DeleteMapping("/delete-item/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable String id) {
        var deletedRecord = catalogService.deleteItem(id);
        return ResponseEntity.ok(deletedRecord);
    }

}
