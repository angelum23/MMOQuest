package com.exer4.exer4.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseService<T extends IEntidadeBase> {

    @Autowired
    private BaseRepository<T> repository;

    public Integer salvar(T entidade) throws Exception {
        if (entidade.getId() == null) {
            return repository.inserir(entidade);
        }

        return repository.alterar(entidade);
    }

    public void remover(Integer id) throws Exception {
        repository.remover(id);
    }
}