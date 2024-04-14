package com.exer4.exer4.infra;

import org.springframework.stereotype.Component;

@Component
public class EntidadeBase implements IEntidadeBase {
    private Integer id;
    private Boolean removida = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getRemovida() {
        return removida;
    }

    public void setRemovida(Boolean removida) {
        this.removida = removida;
    }
}
