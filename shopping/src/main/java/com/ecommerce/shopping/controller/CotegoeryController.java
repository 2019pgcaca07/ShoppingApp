package com.ecommerce.shopping.controller;

import com.ecommerce.shopping.model.Cotegoery;
import com.ecommerce.shopping.service.CotegoeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CotegoeryController {

    @Autowired
    private CotegoeryService cotegoeryService;

    @GetMapping("/api/public/cotegoeries")
    List<Cotegoery> getAllCotegoery(){
        return cotegoeryService.getAllCotegoery();
    }

    @PostMapping("/api/public/cotegoery")
    String createCotegoery(@RequestBody Cotegoery cotegoery){
        System.out.println(cotegoery.toString());
        cotegoeryService.createCotegoery(cotegoery);
        return "cotegoery created successfully";
    }
}
