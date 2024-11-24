package com.shakhawat.springgraphqlclient.client;

import com.shakhawat.springgraphqlclient.dto.Item;
import com.shakhawat.springgraphqlclient.dto.ItemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class InventoryClient {

    private final HttpGraphQlClient graphQlClient;

    public List<Item> viewProducts() {
        String graphQLQuery = """
                query GetProducts {
                    getProducts {
                        name
                        category
                        price
                        stock
                    }
                }""";

        return graphQlClient.document(graphQLQuery)
                .retrieve("getProducts")
                .toEntityList(Item.class).block();
    }

    public List<Item> viewProductsByCategory(String category) {

        String graphQLQuery = String.format("""
                query GetProductsByCategory {
                    getProductsByCategory(category: "%s") {
                        name
                        category
                        price
                        stock
                    }
                }
                """, category);

        return graphQlClient.document(graphQLQuery)
                .retrieve("getProductsByCategory")
                .toEntityList(Item.class).block();
    }

    public Item viewProductById(String id) {

        String graphQLQuery = String.format("""
                query GetProductById {
                    getProduct(id: "%s") {
                        name
                        category
                        price
                        stock
                    }
                }
                """, id);

        return graphQlClient.document(graphQLQuery)
                .retrieve("getProduct")
                .toEntity(Item.class).block();
    }

    public Item receiveNewShipment(ItemRequest itemRequest) {
        String graphQlQuery = String.format("""
                mutation ReceiveNewShipment {
                    receiveNewShipment(id: "%s", quantity: %d) {
                        name
                        price
                        stock
                    }
                }
                """, itemRequest.id(), itemRequest.quantity());
        return graphQlClient.document(graphQlQuery)
                .retrieve("receiveNewShipment")
                .toEntity(Item.class).block();
    }

    public Item updateProduct(ItemRequest itemRequest) {
        String graphQlQuery = String.format("""
                mutation UpdateProduct {
                    updateStock(id: "%s", quantity: %d) {
                        name
                        price
                        stock
                    }
                }
                """, itemRequest.id(), itemRequest.quantity());
        return graphQlClient.document(graphQlQuery)
                .retrieve("updateStock")
                .toEntity(Item.class).block();
    }

    public Item saveItem(Item item) {
        String graphQlQuery = String.format("""
                mutation SaveItem {
                    saveProduct(name: "%s", category: "%s", price: %f, stock: %d) {
                        name
                        category
                        price
                        stock
                    }
                }
                """, item.name(), item.category(), item.price(), item.stock());
        return graphQlClient.document(graphQlQuery)
                .retrieve("saveProduct")
                .toEntity(Item.class).block();
    }

    public String deleteItem(String id) {
        String graphQlQuery = String.format("""
                mutation DeleteItem {
                    deleteProduct(id: "%s")
                }
                """, id);
        return graphQlClient.document(graphQlQuery)
                .retrieve("deleteProduct")
                .toEntity(String.class).block();
    }

}
