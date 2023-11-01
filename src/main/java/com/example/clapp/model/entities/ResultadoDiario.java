package com.example.clapp.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@Document(collection = "resultados_diarios")
@JsonIgnoreProperties(value = {"_class"})
public class ResultadoDiario {
    @Id
    private String id;
    private Date fecha;
    private Integer partidosGanados;
    private Integer partidosPerdidos;

    public ResultadoDiario() {
        this.setFecha(new Date());
    }
}
