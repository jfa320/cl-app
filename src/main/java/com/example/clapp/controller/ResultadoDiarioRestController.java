package com.example.clapp.controller;

import com.example.clapp.model.entities.ResultadoDiario;
import com.example.clapp.service.interfaces.ResultadoDiarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins={"*"})
@RestController
@RequestMapping("/resultados")
@RequiredArgsConstructor
public class ResultadoDiarioRestController {

    private final ResultadoDiarioService resultadoDeportivoService;

    @GetMapping("/working")
    public String working() {
        return "Funciono joya";
    }

    @PostMapping("/agregar")
    public void agregarResultado(@RequestBody ResultadoDiario resultado) {
        resultadoDeportivoService.agregarResultado(resultado);
    }

    @GetMapping("/listar")
    public List<ResultadoDiario> listarResultadosHistoricos() {
        return resultadoDeportivoService.getResultadosHistorico();
    }
}
