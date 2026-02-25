package com.securin.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securin.Entity.WeatherModel;

public interface WeatherRepository extends JpaRepository<WeatherModel, Long> {

    List<WeatherModel> findByConds(String conds);

    List<WeatherModel> findByTempmGreaterThan(Double tempm);
}