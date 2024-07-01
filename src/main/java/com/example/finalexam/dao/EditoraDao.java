package com.example.finalexam.dao;

import com.example.finalexam.entity.Editora;
import com.example.finalexam.entity.Genero;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Component
public class EditoraDao {
    public List<Editora> listarEditora(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Editora[]> response = restTemplate.getForEntity(
                "http://localhost:8080/product", Editora[].class);
        return Arrays.asList(response.getBody());
    }
}
