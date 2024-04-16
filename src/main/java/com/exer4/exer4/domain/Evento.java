package com.exer4.exer4.domain;

import com.exer4.exer4.domain.Enums.Coordenada;
import com.exer4.exer4.domain.Enums.Dificuldade;
import com.exer4.exer4.domain.Enums.Status;
import com.exer4.exer4.domain.Enums.TipoEvento;
import com.exer4.exer4.infra.base.EntidadeBase;
import com.exer4.exer4.infra.base.IEntidadeBase;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class Evento extends EntidadeBase implements IEntidadeBase {
    private String nome;
    private String descricao;
    private Date data;
    private TipoEvento tipoEvento;
    private Coordenada coordenada;
    private Dificuldade dificuldade;
    private Status status;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public void validarData() throws Exception{
        if(this.getData() == null) {
            return;
        }

        var dataInstant = this.getData().toInstant();
        var agoraInstant = new Date().toInstant();

        if (dataInstant.isBefore(agoraInstant)) {
            throw new Exception("Não é possível salvar eventos retroativos!");
        }
    }

    public Dificuldade getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
