package com.fjuarez.clapp.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@Document(collection = "resultados_diarios")
@JsonIgnoreProperties(value = {"_class"})
public class ResultadoDiario implements Serializable {
    @Id
    private String id;
    private Date fecha;
    @NotNull(message = "Partidos Ganados no puede ser nulo")
    private Integer partidosGanados;
    @NotNull(message = "Partidos Perdidos no puede ser nulo")
    private Integer partidosPerdidos;

    public ResultadoDiario() {
        this.setFecha(new Date());
    }
}
