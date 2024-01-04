package com.example.clapp.service.implementation;

import com.example.clapp.model.entities.ResultadoDiario;
import com.example.clapp.repository.ResultadoDiarioRepository;
import com.example.clapp.service.interfaces.ResultadoDiarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

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
