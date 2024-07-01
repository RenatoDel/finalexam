package com.example.finalexam.dao;

import com.example.finalexam.entity.Distribuidora;
import com.example.finalexam.entity.Genero;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class GeneroDao {
    public List<Genero> listarGenero(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Genero[]> response = restTemplate.getForEntity(
                "http://localhost:8080/product", Genero[].class);
        return Arrays.asList(response.getBody());
    }
}
