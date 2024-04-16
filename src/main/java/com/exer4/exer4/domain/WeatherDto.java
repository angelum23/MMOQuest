package com.exer4.exer4.domain;

import com.exer4.exer4.domain.Enums.Dificuldade;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDto {
    private Float chanceDeChuva;
    private Float temperatura;

    @JsonCreator
    public WeatherDto(@JsonProperty("data_day") DataDay dataDay) {
        if (dataDay != null && dataDay.precipitationProbability != null && dataDay.precipitationProbability.length > 0) {
            this.chanceDeChuva = dataDay.precipitationProbability[0];
        }
        if (dataDay != null && dataDay.temperatureMean != null && dataDay.temperatureMean.length > 0) {
            this.temperatura = dataDay.temperatureMean[0];
        }
    }

    public Float getChanceDeChuva() {
        return chanceDeChuva;
    }

    public void setChanceDeChuva(Float chanceDeChuva) {
        this.chanceDeChuva = chanceDeChuva;
    }

    public Float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Float temperatura) {
        this.temperatura = temperatura;
    }

    public Dificuldade gerarDificuldadeComBaseNoClima() throws Exception{
        if(this.chanceDeChuva == null && this.temperatura == null){
            return Dificuldade.Facil;
        }

        var chanceChuva = this.chanceDeChuva != null ? this.chanceDeChuva : 0;
        var temperatura = this.temperatura != null ? this.temperatura : 0;

        if(chanceChuva > 90 || temperatura < 0 || temperatura > 33){
            return Dificuldade.Dificil;
        }

        if(chanceChuva > 60 || temperatura < 10 || temperatura > 29){
            return Dificuldade.Medio;
        }

        return Dificuldade.Facil;
    }

    public static class DataDay {
        @JsonProperty("precipitation_probability")
        Float[] precipitationProbability;

        @JsonProperty("temperature_mean")
        Float[] temperatureMean;
    }
}
