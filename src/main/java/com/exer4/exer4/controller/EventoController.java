package com.exer4.exer4.controller;

import com.exer4.exer4.domain.Evento;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventoController{

    @PostMapping("/evento/inserir")
    public ResponseEntity<Object> Inserir(Evento evento) {
        try {
            return ResponseEntity.status(200).body("Evento inserido com sucesso!");
        } catch(Exception e) {
            return ResponseEntity.status(500).body("");
        }
    }
}
