package com.fjuarez.clapp.service.implementation;

import com.fjuarez.clapp.model.entities.ResultadoDiario;
import com.fjuarez.clapp.repository.ResultadoDiarioRepository;
import com.fjuarez.clapp.service.interfaces.ResultadoDiarioService;
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
    public ResultadoDiario agregarResultado(ResultadoDiario resultado) {
        return resultadoDiarioRepository.save(resultado);
    }

    @Override
    public List<ResultadoDiario> getResultadosHistorico() {
        return resultadoDiarioRepository.findAllByOrderByFechaDesc();
    }

    @Override
    public Page<ResultadoDiario> getResultadosHistorico(PageRequest page) {
        return resultadoDiarioRepository.findAllByOrderByFechaDesc(page);
    }

    @Override
    public void deleteById(String id) {
        resultadoDiarioRepository.deleteById(id);
    }

    @Override
    public ResultadoDiario findById(String id) {
        return resultadoDiarioRepository.findById(id).get();
    }
}
