package com.exer4.exer4.controller;

import com.exer4.exer4.domain.Tarefa;
import com.exer4.exer4.infra.base.BaseController;
import com.exer4.exer4.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Tarefa")
public class TarefaController extends BaseController<Tarefa> {

    @Autowired
    private TarefaService service;

    @PostMapping("/ConcluirTarefa")
    public ResponseEntity<Object> ConcluirTarefa(@RequestParam("id") Integer id) {
        try {
            service.concluir(id);
            return ResponseEntity.status(200).body("Atividade concluida com sucesso: " + id);
        } catch(Exception e) {
            return ResponseEntity.status(500).body("Erro ao concluir atividade registro! " + e.getMessage());
        }
    }
}
