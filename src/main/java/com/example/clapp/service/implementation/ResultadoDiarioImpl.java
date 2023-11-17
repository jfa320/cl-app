package com.example.clapp.service.implementation;

import com.example.clapp.model.entities.ResultadoDiario;
import com.example.clapp.repository.ResultadoDiarioRepository;
import com.example.clapp.service.interfaces.ResultadoDiarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultadoDiarioImpl implements ResultadoDiarioService {

    private final ResultadoDiarioRepository resultadoDiarioRepository;

    @Override
    public void agregarResultado(ResultadoDiario resultado) {
        resultadoDiarioRepository.save(resultado);
    }

    @Override
    public List<ResultadoDiario> getResultadosHistorico() {
        return resultadoDiarioRepository.findAllByOrderByFechaDesc();
    }

    @Override
    public Page<ResultadoDiario> getResultadosHistorico(PageRequest page) {
        return resultadoDiarioRepository.findAllByOrderByFechaDesc(page);
    }


}
