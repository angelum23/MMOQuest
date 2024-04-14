package com.exer4.exer4.domain;

import com.exer4.exer4.domain.Enums.TipoEvento;
import com.exer4.exer4.infra.EntidadeBase;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Evento extends EntidadeBase {
    String nome;
    String descricao;
    Date dataInicial;
    Date dataFinal;
    TipoEvento tipoEvento;
}
