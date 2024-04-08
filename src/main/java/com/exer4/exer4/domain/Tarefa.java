package com.exer4.exer4.domain;

import com.exer4.exer4.domain.Enums.StatusTarefa;
import org.springframework.stereotype.Component;

@Component
public class Tarefa extends Evento {
    Boolean NaoPossuiData = false;
    StatusTarefa status;
}