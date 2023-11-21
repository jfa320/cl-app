package com.example.clapp.controller;

import com.example.clapp.model.entities.ResultadoDiario;
import com.example.clapp.service.interfaces.ResultadoDiarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<?> agregarResultado(@Valid @RequestBody ResultadoDiario resultado, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error de validación: " + bindingResult.getAllErrors());
        }
        ResultadoDiario resultadoDiario = resultadoDeportivoService.agregarResultado(resultado);
        return ResponseEntity.status(HttpStatus.CREATED).body(resultadoDiario);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarResultadosHistoricos() {
        try {
            List<ResultadoDiario> resultados = resultadoDeportivoService.getResultadosHistorico();
            return ResponseEntity.ok(resultados);
        } catch (Exception e) {
            // Manejar la excepción y devolver una respuesta apropiada
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener resultados históricos: " + e.getMessage());
        }
    }
    @GetMapping("/listar/page/{page}")
    public ResponseEntity<?> listarResultadosHistoricos(@PathVariable Integer page) {
        try {
            Page<ResultadoDiario> resultadosPage = resultadoDeportivoService.getResultadosHistorico(PageRequest.of(page, 11));
            return ResponseEntity.ok(resultadosPage);
        } catch (Exception e) {
            // Manejar la excepción y devolver una respuesta apropiada
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener resultados históricos: " + e.getMessage());
        }
    }
}
