package com.apicars.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apicars.api.dto.CarDTO;
import com.apicars.api.model.Car;
import com.apicars.api.repository.CarRepository;

@RestController
@RequestMapping("api/car")
public class CarController {    
    
    @Autowired
    private CarRepository repository;

    @GetMapping
    public List<Car> listCars(){
        return repository.findAll();
    }

    @PostMapping
    public void create(@RequestBody CarDTO req){
        System.out.println("Esse é um veículo da " + req.fabricante() + " fabricado em " + req.dataFabricacao() + ".");
        repository.save(new Car(req));
    } 
}
