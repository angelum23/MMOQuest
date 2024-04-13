package com.exer4.exer4.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class BaseService<T> {

    @Autowired
    private BaseRepository<T, Long> repository;

    public List<T> recuperar()

    public T salvar(T entidade) {
        return repository.save(entidade);
    }

    public T alterar(T entidade) {
        return repository.save(entidade);
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}