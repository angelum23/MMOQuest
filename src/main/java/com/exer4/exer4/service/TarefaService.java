package com.exer4.exer4.service;

import com.exer4.exer4.domain.Enums.Status;
import com.exer4.exer4.domain.Tarefa;
import com.exer4.exer4.domain.WeatherDto;
import com.exer4.exer4.infra.WeatherHelper;
import com.exer4.exer4.infra.base.BaseService;
import com.exer4.exer4.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TarefaService extends BaseService<Tarefa> {
    @Autowired
    private TarefaRepository repository;

    @Autowired
    private WeatherHelper weatherHelper;

    @Override
    public Integer salvar(Tarefa tarefa) throws Exception{
        tarefa.validarDuracao();

        return super.salvar(tarefa);
    }

    public void concluir(Integer id) throws Exception{
        Tarefa tarefa = repository.recuperar(id);
        tarefa.validarData();

        WeatherDto clima = weatherHelper.recuperarClima();
        tarefa.setDificuldade(clima.gerarDificuldadeComBaseNoClima());

        tarefa.setStatusTarefa(Status.Sucesso);
    }
}
