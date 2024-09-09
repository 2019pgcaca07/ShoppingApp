package com.ecommerce.shopping.service;

import com.ecommerce.shopping.model.Cotegoery;

import java.util.List;

public interface CotegoeryService {

    List<Cotegoery> getAllCotegoery();

    void createCotegoery(Cotegoery cotegoery);
}
