package com.telegram.bot.controller;

import com.telegram.bot.dto.City;
import com.telegram.bot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class CityController {


    private final Logger logger;
    private CityService cityService;

    @Autowired
    public CityController(@Qualifier("controllerLogger") Logger logger, CityService cityService) {
        this.logger = logger;
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public List<City> getAllCities() {
        logger.log(Level.INFO,"Getting cities list");
        return cityService.getAllCities();
    }

    @GetMapping("/cities/{id}")
    public City getCityById(@PathVariable Long id) {
        logger.log(Level.INFO, "Getting CityEntity by Id: "+id);
        return cityService.getById(id);
    }

    @PostMapping("/cities")
    public void addNewCity(@RequestBody City city) {
        logger.log(Level.INFO, "Adding new CityEntity");
        cityService.saveNewCity(city);
    }

    @PutMapping("/cities/{id}")
    public ResponseEntity updateCityInf(@RequestBody City city, @PathVariable Long id) {
        City selectedForUpdateCity = cityService.getById(id);
        if (selectedForUpdateCity == null) {
            logger.log(Level.WARNING, "selected cityEntity does not exist");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        cityService.updateCity(id,city);
        return new ResponseEntity(HttpStatus.OK);

    }

    @DeleteMapping("/cities/{id}")
    public void deleteCity(@PathVariable Long id) {
        logger.log(Level.INFO, "Deleting by Id: "+id);
        cityService.deleteById(id);
    }

}
