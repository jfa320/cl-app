package com.example.clapp.repository;

import com.example.clapp.model.entities.ResultadoDiario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoDiarioRepository extends MongoRepository<ResultadoDiario, String> {
}
