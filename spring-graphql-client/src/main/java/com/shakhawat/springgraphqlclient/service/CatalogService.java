package com.shakhawat.springgraphqlclient.service;

import com.shakhawat.springgraphqlclient.client.InventoryClient;
import com.shakhawat.springgraphqlclient.dto.Item;
import com.shakhawat.springgraphqlclient.dto.ItemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CatalogService {

    private final InventoryClient inventoryClient;

    public List<Item> viewProducts() {
        return inventoryClient.viewProducts();
    }

    public List<Item> viewProductsByCategory(String category) {
        return inventoryClient.viewProductsByCategory(category);
    }

    public Item viewProductById(String id) {
        return inventoryClient.viewProductById(id);
    }

    public Item receiveNewShipment(ItemRequest itemRequest) {
        return inventoryClient.receiveNewShipment(itemRequest);
    }

    public Item updateProduct(ItemRequest itemRequest) {
        return inventoryClient.updateProduct(itemRequest);
    }

    public Item saveItem(Item item) {
        return inventoryClient.saveItem(item);
    }

    public String deleteItem(String id) {
        return inventoryClient.deleteItem(id);
    }

}
