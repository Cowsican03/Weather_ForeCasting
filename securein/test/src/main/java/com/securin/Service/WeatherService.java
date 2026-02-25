package com.securin.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.securin.Entity.WeatherModel;
import com.securin.Repository.WeatherRepository;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepository repository;

    public void loadCSV() throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new ClassPathResource("testset.csv").getInputStream()
                )
        );

        String line;
        boolean firstLine = true;

        while ((line = br.readLine()) != null) {

            if (firstLine) {
                firstLine = false;
                continue;
            }

            String[] data = line.split(",");

            WeatherModel weather = new WeatherModel(
                    data[0],
                    data[1].trim(),
                    parseDouble(data[2]),
                    parseInt(data[3]),
                    parseInt(data[4]),
                    parseDouble(data[6]),
                    parseDouble(data[8]),
                    parseDouble(data[11]),
                    parseDouble(data[19])
            );

            repository.save(weather);
        }

        br.close();
    }

    private Double parseDouble(String value) {
        if (value == null || value.isEmpty() || value.equals("NaN") || value.equals("-9999"))
            return null;
        return Double.parseDouble(value);
    }

    private Integer parseInt(String value) {
        if (value == null || value.isEmpty())
            return null;
        return Integer.parseInt(value);
    }

    public List<WeatherModel> getAll() {
        return repository.findAll();
    }

    public List<WeatherModel> filterByCondition(String cond) {
        return repository.findByConds(cond);
    }

    public List<WeatherModel> filterByTemperature(Double tempm) {
        return repository.findByTempmGreaterThan(tempm);
    }

    public List<WeatherModel> sortByField(String field) {
        return repository.findAll(Sort.by(Sort.Direction.ASC, field));
    }
}