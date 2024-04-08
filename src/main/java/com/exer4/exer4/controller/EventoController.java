package com.exer4.exer4.controller;

import com.exer4.exer4.domain.Evento;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.http.HttpResponse;

@Controller
public class EventoController{
    public RequestBody Inserir(Evento evento) {
        try {

        } catch(Exception e) {
            return HttpResponse.status(500);
        }
    }
}
