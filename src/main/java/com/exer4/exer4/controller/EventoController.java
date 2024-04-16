package com.exer4.exer4.controller;

import com.exer4.exer4.domain.Evento;

import com.exer4.exer4.infra.base.BaseController;
import com.exer4.exer4.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Evento")
public class EventoController extends BaseController<Evento> {
    @Autowired
    private EventoService service;

    @PostMapping("/ConcluirEvento")
    public ResponseEntity<Object> ConcluirEvento(@RequestParam("id") Integer id) {
        try {
            service.concluir(id);
            return ResponseEntity.status(200).body("Evento concluida com sucesso: " + id);
        } catch(Exception e) {
            return ResponseEntity.status(500).body("Erro ao concluir evento registro! " + e.getMessage());
        }
    }
}
