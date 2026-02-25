package com.securin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securin.Entity.WeatherModel;
import com.securin.Service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService service;

    @PostMapping("/load")
    public String loadData() throws Exception {
        service.loadCSV();
        return "CSV Loaded Successfully!";
    }

    @GetMapping("/all")
    public List<WeatherModel> getAll() {
        return service.getAll();
    }

    @GetMapping("/filter/condition/{cond}")
    public List<WeatherModel> filterByCondition(@PathVariable String cond) {
        return service.filterByCondition(cond);
    }

    @GetMapping("/filter/temp/{temp}")
    public List<WeatherModel> filterByTemp(@PathVariable Double temp) {
        return service.filterByTemperature(temp);
    }

    @GetMapping("/sort/{name}")
    public List<WeatherModel> sort(@PathVariable String name) {
        return service.sortByField(name);
    }
}