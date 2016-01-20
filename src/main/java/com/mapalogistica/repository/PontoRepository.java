package com.mapalogistica.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.mapalogistica.domain.Ponto;

public interface PontoRepository extends GraphRepository<Ponto> {
	
	
    Ponto findByNome(String nome);



}
