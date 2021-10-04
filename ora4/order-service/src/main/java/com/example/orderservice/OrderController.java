package com.example.orderservice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final StorageClient storageClient;

    @GetMapping("/order")
    public String order() {
        int remainingProduct = this.storageClient.deliver();
        return "Order confirmed! Remaining products: " + remainingProduct;
    }
}
