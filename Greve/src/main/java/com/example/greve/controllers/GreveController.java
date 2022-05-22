package com.example.greve.controllers;

import com.example.greve.dao.Plant;
import com.example.greve.repository.GreveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@CrossOrigin
@RestController
public class GreveController {
    @Autowired
    GreveRepository greveRepository;

    List<Plant> names = new ArrayList<>();

    @GetMapping(path ="/sayhello")
    public Plant getHelloWorld()
    {   Plant plant=new Plant();
        plant.setName("Bonsai");
        plant.setDescription("This  is old & small plant");
        return plant;
    }

    @PostMapping(path = "/add-data")
    public ResponseEntity<String> postNames(@RequestBody Plant plantrequest)
    {
        greveRepository.save(plantrequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(path ="/getallplants")
    public ResponseEntity<List<Plant>> getAllPlants()
    {
        List<Plant> result = greveRepository.findAll();
        return new ResponseEntity<>(result , HttpStatus.OK);
    }
    @PutMapping(path = "/add-data/{id}" )
    public ResponseEntity<String> updatePlantDetails(@RequestBody Plant plantrequest , @PathVariable Long id){
       greveRepository.save(plantrequest);
       return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/deletePlant/{id}")
    public ResponseEntity<Object> deletePlant(@PathVariable Long id)
    {
        Plant a = greveRepository.getById(id);
        System.out.println(a.toString());
        greveRepository.delete(a);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}
