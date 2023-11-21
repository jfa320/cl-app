package com.example.clapp.service.interfaces;

import com.example.clapp.model.entities.ResultadoDiario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ResultadoDiarioService {
    ResultadoDiario agregarResultado(ResultadoDiario resultado);
    List<ResultadoDiario> getResultadosHistorico();
    Page<ResultadoDiario> getResultadosHistorico(PageRequest page);
}
