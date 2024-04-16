package com.exer4.exer4.domain;

import com.exer4.exer4.domain.Enums.Dificuldade;
import com.exer4.exer4.domain.Enums.Status;
import com.exer4.exer4.infra.base.EntidadeBase;
import com.exer4.exer4.infra.base.IEntidadeBase;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class Tarefa extends EntidadeBase implements IEntidadeBase {
    private String nome;
    private String descricao;
    private Date dataInicial;
    private Date dataFinal;
    private Status status;
    private Dificuldade dificuldade;

    public Status getStatusTarefa() {
        return status;
    }
    public void setStatusTarefa(Status status) {
        this.status = status;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Dificuldade getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
    }

    public void validarDuracao() throws Exception{
        if(this.getDataInicial() == null || this.getDataFinal() == null) return;

        var dataInicialMaisSeteDias = LocalDateTime.from(this.getDataInicial().toInstant()).plusDays(7);
        var dataFinal = LocalDateTime.from(this.getDataInicial().toInstant());

        if (dataInicialMaisSeteDias.isBefore(dataFinal)) {
            throw new Exception("Não é possível salvar tarefas com mais de 7 dias de duração!");
        }
    }

    public void validarData() throws Exception{
        if(this.getDataInicial() == null || this.getDataFinal() == null) return;;

        var agora = new Date();

        if(this.getDataInicial().after(agora) || this.getDataFinal().before(agora)){
            throw new Exception("Não é possível concluir a tarefa fora da data");
        }
    }
}