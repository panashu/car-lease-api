package com.ashupan.cardataservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashupan.cardataservice.exception.ResourceNotFoundException;
import com.ashupan.cardataservice.model.Car;
import com.ashupan.cardataservice.repository.CarRepository;



@RestController
@RequestMapping("/api/v1")
@Api(value = "This is car controller")
public class CarController {

	@Autowired
	private CarRepository carRepository;
	
	@GetMapping("/cars")
	@ApiOperation(value = "Get all cars")
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}

	@GetMapping("/cars/{id}")
	@ApiOperation(value = "Get Car by id")
	public ResponseEntity<Car> getCarById(@PathVariable(value = "id") Long carId)
			throws ResourceNotFoundException {
		Car car = carRepository.findById(carId)
				.orElseThrow(() -> new ResourceNotFoundException("Car not found for this id :: " + carId));
		return ResponseEntity.ok().body(car);
	}

	@PostMapping("/cars")
	@ApiOperation(value = "Save new Car")
	public Car createCar(@Valid @RequestBody Car car) {
		return carRepository.save(car);
	}

	@PutMapping("/cars/{id}")
	@ApiOperation(value = "Update a Car")
	public ResponseEntity<Car> updateCar(@PathVariable(value = "id") Long carId,
			@Valid @RequestBody Car carDetails) throws ResourceNotFoundException {
		Car car = carRepository.findById(carId)
				.orElseThrow(() -> new ResourceNotFoundException("Car not found for this id :: " + carId));

		car.setMake(carDetails.getMake());
		car.setModel(carDetails.getModel());
		car.setVersion(carDetails.getVersion());
		car.setNumberOfDoors(carDetails.getNumberOfDoors());
		car.setEmmissionCO2(carDetails.getEmmissionCO2());
		car.setGrossPrice(carDetails.getGrossPrice());
		car.setNetPrice(carDetails.getNetPrice());
		
		final Car updatedCar = carRepository.save(car);
		return ResponseEntity.ok(updatedCar);
	}

	@DeleteMapping("/cars/{id}")
	@ApiOperation(value = "Delete a Car")
	public Map<String, Boolean> deleteCar(@PathVariable(value = "id") Long carId)
			throws ResourceNotFoundException {
		Car car = carRepository.findById(carId)
				.orElseThrow(() -> new ResourceNotFoundException("Car not found for this id :: " + carId));

		carRepository.delete(car);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
