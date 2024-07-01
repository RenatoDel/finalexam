package com.example.finalexam.dao;

import com.example.finalexam.dto.JuegosDto;
import com.example.finalexam.entity.Juegos;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class JuegosDao {
    public List<Juegos> listarJuegos(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Juegos[]> response = restTemplate.getForEntity(
                "http://localhost:8080/api/order", Juegos[].class);
        return Arrays.asList(response.getBody());
    }
    public void guardarJuego(Juegos juegos) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String url = "http://localhost:8080/api/order";
        HttpEntity<Juegos> httpEntity = new HttpEntity<>(juegos, headers);

        RestTemplate restTemplate = new RestTemplate();
        if (juegos.getId() > 0) {
            restTemplate.put(url, httpEntity, Juegos.class);
        } else {
            restTemplate.postForEntity(url, httpEntity, Juegos.class);
        }

    }
    public Juegos obtenerJuegoPorId(int id) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/product/" + id;

        ResponseEntity<JuegosDto> responseMap = restTemplate.getForEntity(url, JuegosDto.class);

        JuegosDto juegosDto = responseMap.getBody();

        return juegosDto.getJuegos();
    }
}
