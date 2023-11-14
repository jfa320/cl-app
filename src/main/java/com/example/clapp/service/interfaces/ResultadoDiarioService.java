package com.example.clapp.service.interfaces;

import com.example.clapp.model.entities.ResultadoDiario;

import java.util.List;

public interface ResultadoDiarioService {
    void agregarResultado(ResultadoDiario resultado);
    List<ResultadoDiario> getResultadosHistorico();
}
