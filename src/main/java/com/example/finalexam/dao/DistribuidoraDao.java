package com.example.finalexam.dao;

import com.example.finalexam.entity.Distribuidora;
import com.example.finalexam.entity.Juegos;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class DistribuidoraDao {
    public List<Distribuidora> listarDistribuidora(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Distribuidora[]> response = restTemplate.getForEntity(
                "http://localhost:8080/product", Distribuidora[].class);
        return Arrays.asList(response.getBody());
    }
}
