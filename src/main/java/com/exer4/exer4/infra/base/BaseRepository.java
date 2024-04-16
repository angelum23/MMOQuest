package com.exer4.exer4.infra.base;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public abstract class BaseRepository<T extends IEntidadeBase> {
    public List<T> entidades = new ArrayList<>();

    public List<T> recuperar() {
        return entidades.stream().filter(e -> !e.getRemovida()).toList();
    }

    public T recuperar(int id) throws Exception{
        return entidades.stream().filter(e -> e.getId() == id).findFirst().orElseThrow();
    }

    public Integer inserir(T entidade) {
        int maxId = entidades.stream().mapToInt(IEntidadeBase::getId).max().orElse(0);
        entidade.setId(maxId + 1);
        entidades.add(entidade);

        return entidade.getId();
    }

    public Integer alterar(T entidade) throws Exception {
        T entidadeAntiga = entidades.stream()
                                    .filter(t -> t.getId().equals(entidade.getId()))
                                    .findFirst()
                                    .orElseThrow();
        int entidadePos = entidades.indexOf(entidadeAntiga);
        entidades.set(entidadePos, entidade);

        return entidade.getId();
    }

    public void remover(Integer id) throws Exception {
        T entidadeASerRemovida = entidades.stream()
                                          .filter(e -> e.getId().equals(id))
                                          .findFirst()
                                          .orElse(null);

        if (entidadeASerRemovida == null || entidadeASerRemovida.getRemovida()) {
            throw new NoSuchElementException();
        }

        var indexEntidade = entidades.indexOf(entidadeASerRemovida);
        entidadeASerRemovida.setRemovida(true);

        entidades.set(indexEntidade, entidadeASerRemovida);
    }
}