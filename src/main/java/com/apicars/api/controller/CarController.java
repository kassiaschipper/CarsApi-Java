package com.apicars.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apicars.api.dto.CarDTO;
import com.apicars.api.model.Car;
import com.apicars.api.repository.CarRepository;

import jakarta.validation.Valid;

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
    public void create(@RequestBody @Valid CarDTO req){
        System.out.println("Esse é um veículo da " + req.fabricante() + " fabricado em " + req.dataFabricacao() + ".");
        repository.save(new Car(req));
    } 

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
      }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid CarDTO req){
       repository.findById(id).map(car -> {
        car.setModelo(req.modelo());
        car.setFabricante(req.fabricante());
        car.setDataFabricacao(req.dataFabricacao());
        car.setValor(req.valor());
        car.setAnoModelo(req.anoModelo());

        return repository.save(car);
       });

  
    }

}
