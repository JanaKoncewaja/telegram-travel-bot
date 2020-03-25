package com.telegram.bot.service;

import com.telegram.bot.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private CityRepository cityRepository;

    public CityService(@Autowired CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }


}
