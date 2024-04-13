package com.exer4.exer4.controller;

import com.exer4.exer4.domain.Evento;

import com.exer4.exer4.infra.BaseController;
import com.exer4.exer4.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventoController extends BaseController<Evento> {}
