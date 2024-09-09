package com.ecommerce.shopping.service;

import com.ecommerce.shopping.model.Cotegoery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CotegoeryServiceImpl implements CotegoeryService{

    private List<Cotegoery> cotegoeries = new ArrayList<>();
    @Override
    public List<Cotegoery> getAllCotegoery() {
        return cotegoeries;
    }

    @Override
    public void createCotegoery(Cotegoery cotegoery) {
           cotegoeries.add(cotegoery);
    }
}
