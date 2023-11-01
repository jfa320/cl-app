package com.example.clapp.service.implementation;

import com.example.clapp.model.entities.ResultadoDiario;
import com.example.clapp.repository.ResultadoDiarioRepository;
import com.example.clapp.service.interfaces.ResultadoDiarioInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultadoDiarioImpl implements ResultadoDiarioInterface {

    private final ResultadoDiarioRepository resultadoDiarioRepository;

    @Override
    public void agregarResultado(ResultadoDiario resultado) {
        resultadoDiarioRepository.save(resultado);
    }

    @Override
    public List<ResultadoDiario> getResultadosHistorico() {
        return resultadoDiarioRepository.findAll();
    }
}
