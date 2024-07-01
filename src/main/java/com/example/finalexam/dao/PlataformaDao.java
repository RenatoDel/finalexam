package com.example.finalexam.dao;

import com.example.finalexam.entity.Juegos;
import com.example.finalexam.entity.Plataforma;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Component
public class PlataformaDao {
    public List<Plataforma> listarPlataforma(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Plataforma[]> response = restTemplate.getForEntity(
                "http://localhost:8080/product", Plataforma[].class);
        return Arrays.asList(response.getBody());
    }
}
