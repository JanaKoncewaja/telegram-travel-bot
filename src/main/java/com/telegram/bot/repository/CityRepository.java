package com.telegram.bot.repository;

import com.telegram.bot.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {

    CityEntity findByCityEntityName(String cityEntityName);

}
