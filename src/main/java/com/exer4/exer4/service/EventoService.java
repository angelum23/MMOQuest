package com.exer4.exer4.service;

import com.exer4.exer4.domain.Enums.Chuva;
import com.exer4.exer4.domain.Enums.Dificuldade;
import com.exer4.exer4.domain.Enums.Status;
import com.exer4.exer4.domain.Evento;
import com.exer4.exer4.domain.Tarefa;
import com.exer4.exer4.domain.WeatherDto;
import com.exer4.exer4.infra.WeatherHelper;
import com.exer4.exer4.infra.base.BaseRepository;
import com.exer4.exer4.infra.base.BaseService;
import com.exer4.exer4.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class EventoService extends BaseService<Evento> {
    @Autowired
    private EventoRepository repository;

    @Autowired
    private WeatherHelper weatherHelper;

    @Override
    public Integer salvar(Evento evento) throws Exception{
        if (evento.getData() != null) {
            var dataInstant = evento.getData().toInstant();
            var agoraInstant = new Date().toInstant();

            if (dataInstant.isBefore(agoraInstant)) {
                throw new Exception("Não é possível salvar eventos retroativos!");
            }
        }

        return super.salvar(evento);
    }

    public Integer concluir(Integer id) throws Exception {
        Evento evento = repository.recuperar(id);

        evento.validarData();

        evento.setDificuldade(gerarDificuldade(evento.getData()));
        evento.setStatus(gerarStatus(evento));

        return evento.getId();
    }

    private Status gerarStatus(Evento evento) {
        if(evento.getData() != null && !evento.getData().equals(new Date())) {
            return Status.Falha;
        }

        return Status.Sucesso;
    }

    public Dificuldade gerarDificuldade(Date data) throws Exception{
        WeatherDto clima = weatherHelper.recuperarClima();

        return clima.gerarDificuldadeComBaseNoClima();
    }
}
