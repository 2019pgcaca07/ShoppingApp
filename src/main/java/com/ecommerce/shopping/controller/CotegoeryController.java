package com.ecommerce.shopping.controller;

import com.ecommerce.shopping.model.Cotegoery;
import com.ecommerce.shopping.service.CotegoeryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CotegoeryController {

    @Autowired
    private CotegoeryService cotegoeryService;

    @GetMapping("/public/cotegoeries")
    //@RequestMapping(value = "/public/cotegoeries",method = RequestMethod.GET)
    ResponseEntity<List<Cotegoery>> getAllCotegoery(){
        List<Cotegoery> cotegoeries = cotegoeryService.getAllCotegoery();
        return new ResponseEntity<>(cotegoeries,HttpStatus.OK);
    }

    @PostMapping("/public/cotegoery")
   //@RequestMapping(value = "/public/cotegoery",method = RequestMethod.POST)
    ResponseEntity<String> createCotegoery(@Valid @RequestBody Cotegoery cotegoery){
        cotegoeryService.createCotegoery(cotegoery);
        return new ResponseEntity<>("cotegoery created successfully",HttpStatus.CREATED);

    }

    @DeleteMapping("/admin/cotegoery/{cotegoeryId}")
    //@RequestMapping(value = "/admin/cotegoery/{cotegoeryId}",method = RequestMethod.DELETE)
    ResponseEntity<String> deleteCotegoery(@PathVariable Long cotegoeryId){
        String status = cotegoeryService.deleteCotegoery(cotegoeryId);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PutMapping("/admin/cotegoery/{cotegoeryId}")
    //@RequestMapping(value = "/admin/cotegoery/{cotegoeryId}",method = RequestMethod.PUT)
    ResponseEntity<String> updateCotegoery(@Valid @RequestBody Cotegoery cotegoery, @PathVariable Long cotegoeryId){
            Cotegoery updatedCotegoery = cotegoeryService.updateCotegoery(cotegoery,cotegoeryId);
            return  new ResponseEntity<>("Cotegoery "+ cotegoery + " updated at CotegoeryId "+cotegoeryId,HttpStatus.OK);
    }
}
