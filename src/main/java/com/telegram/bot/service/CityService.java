package com.telegram.bot.service;

import com.telegram.bot.dto.City;
import com.telegram.bot.entity.CityEntity;
import com.telegram.bot.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class CityService {

    final private Logger logger;

    private CityRepository cityRepository;

    private final String THERE_IS_NO_SUCH_CITY = "Oops, are you sure there is such a city?";

    public CityService(@Autowired CityRepository cityRepository,
                       @Autowired @Qualifier("serviceLogger") Logger logger) {
        this.cityRepository = cityRepository;
        this.logger = logger;
    }


    public String searchMessageByCityName(String cityEntityName) {
        if (cityRepository.findByCityEntityName(cityEntityName) == null) {
            logger.log(Level.INFO, "Wrong input");
            return THERE_IS_NO_SUCH_CITY;
        } else {
            logger.log(Level.INFO,"Displaying user`s output message");
            return cityRepository.findByCityEntityName(cityEntityName).getOutPutMessage();
        }
    }

    public List<City> getAllCities() {
        return cityRepository.findAll()
                .stream()
                .map(this::convertFromCityEntity)
                .collect(Collectors.toList());
    }


    public City getById(Long id) {
        return cityRepository.findById(id).map(this::convertFromCityEntity).get();
    }

    public void saveNewCity(City city) {
        cityRepository.save(convertFromCity(city));
    }

    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }

    public void updateCity(Long id, City city) {
        CityEntity cityEntity = cityRepository.findById(id).get();
        cityRepository.delete(cityEntity);
        CityEntity updatedCityEntity = new CityEntity();
        updatedCityEntity.setId(city.getId());
        updatedCityEntity.setCityEntityName(city.getCityName());
        updatedCityEntity.setOutPutMessage(city.getOutPutMessage());
        cityRepository.save(updatedCityEntity);
    }

    private City convertFromCityEntity(CityEntity cityEntity) {
        return new City(cityEntity.getCityEntityName(), cityEntity.getOutPutMessage());
    }

    private CityEntity convertFromCity(City city) {
        return new CityEntity(city.getCityName(), city.getOutPutMessage());
    }
}

