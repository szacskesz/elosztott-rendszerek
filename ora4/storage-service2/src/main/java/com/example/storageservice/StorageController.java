package com.example.storageservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {

    private int productCount = 100;

    @GetMapping("/deliver")
    public int deliver() {
        return --this.productCount;
    }

}
