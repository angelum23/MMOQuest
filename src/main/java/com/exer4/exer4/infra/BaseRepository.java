package com.exer4.exer4.infra;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class BaseRepository<T extends IEntidadeBase> {
    private List<T> entidades;

    public List<T> recuperarTodos() {
        return entidades.stream().filter(e -> !e.getRemovida()).toList();
    }

    public T recuperar(int id) {
        return entidades.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
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

    public Integer inserir(T entidade) {
        int maxId = entidades.stream().mapToInt(IEntidadeBase::getId).max().orElse(0);
        entidade.setId(maxId + 1);
        entidades.add(entidade);

        return entidade.getId();
    }

    public void remover(Integer id) throws Exception {
        T entidadeASerRemovida = entidades.stream()
                                          .filter(e -> e.getId().equals(id))
                                          .findFirst()
                                          .orElse(null);

        if (entidadeASerRemovida == null) {
            throw new Exception();
        }

        entidades.remove(entidadeASerRemovida);
    }
}