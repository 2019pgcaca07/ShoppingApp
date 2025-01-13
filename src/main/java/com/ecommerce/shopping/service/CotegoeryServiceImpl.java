package com.ecommerce.shopping.service;

import com.ecommerce.shopping.exception.APIException;
import com.ecommerce.shopping.exception.ResourceNotFoundException;
import com.ecommerce.shopping.model.Cotegoery;
import com.ecommerce.shopping.repositories.CotegoeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CotegoeryServiceImpl implements CotegoeryService{

    //when we don't use repository we are using like this
    //private List<Cotegoery> cotegoeries = new ArrayList<>();
    //private  Long uniqueid= 1L;

    //As now we have a repository to interact with Cotegoery Entity
    @Autowired
    CotegoeryRepository cotegoeryRepository;


    @Override
    public List<Cotegoery> getAllCotegoery() {
        List<Cotegoery> cotegoeries = cotegoeryRepository.findAll();
        if(cotegoeries.isEmpty())
            throw new APIException("No cotgoery is created at yet!!!");
        return cotegoeries;
    }

    @Override
    public void createCotegoery(Cotegoery cotegoery) {
         //check cotegoery is already exist in repository
        Cotegoery savedCotegoery = cotegoeryRepository.findByCotegoeryName(cotegoery.getCotegoeryName());
        if(savedCotegoery != null){
            throw new APIException("Cotegoery with Cotegoeryname "+ cotegoery.getCotegoeryName()+" is already " +
                    "exist!!!");
        }
        //save a cotegoery to cotegoeryRepository
        cotegoeryRepository.save(cotegoery);
    }

    @Override
    public String deleteCotegoery(Long cotegoeryId) {

        //create a list of cotegoery here
        //List<Cotegoery> cotegoeries = cotegoeryRepository.findAll();
        //optimizing the code , we can use findById, it returns an Optional
        Optional<Cotegoery> optionalcotegoeryToDelete = cotegoeryRepository.findById(cotegoeryId);
        //lets get the cotegoery to delete , find in optional container using orElseThrow
        Cotegoery cotegoeryToDelete = optionalcotegoeryToDelete.orElseThrow(()->
                new ResourceNotFoundException("Cotegoery","CotegoeryId",cotegoeryId));
        //delete the cotegoery
        cotegoeryRepository.delete(cotegoeryToDelete);
           return "Cotegoery with " + cotegoeryId + " deleted successfully";
    }

    @Override
    public Cotegoery updateCotegoery(Cotegoery cotegoery, Long cotegoeryId) {

        //find the Cotegoery with given id in repository, findById returns an Optional
        Optional<Cotegoery> optionalExistingCotegoery  = cotegoeryRepository.findById(cotegoeryId);
        //check in optional container that cotegoery with given Id is present or not
         Cotegoery existingCotegoery = optionalExistingCotegoery.orElseThrow(()->
                new ResourceNotFoundException("Cotegoery","cotegoeryId",cotegoeryId));
         //updating the existingCotegoery with new cotegoery
         existingCotegoery.setCotegoeryName(cotegoery.getCotegoeryName());
         //updatedCotegoery
        Cotegoery updatedCotegoery = existingCotegoery;
        //update in repository
        cotegoeryRepository.save(updatedCotegoery);
        return  updatedCotegoery;
    }
}
