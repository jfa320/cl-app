package com.example.clapp.repository;

import com.example.clapp.model.entities.ResultadoDiario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultadoDiarioRepository extends MongoRepository<ResultadoDiario, String> {
    List<ResultadoDiario> findAllByOrderByFechaDesc();
    Page<ResultadoDiario> findAllByOrderByFechaDesc(Pageable pageable);
}
