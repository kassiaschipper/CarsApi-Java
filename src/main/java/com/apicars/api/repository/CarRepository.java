package com.apicars.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apicars.api.model.Car;

public interface CarRepository extends JpaRepository<Car, Long>{
    
}
