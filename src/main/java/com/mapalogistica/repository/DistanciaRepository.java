package com.mapalogistica.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import com.mapalogistica.domain.Distancia;
import com.mapalogistica.domain.MelhorCaminho;

public interface DistanciaRepository extends GraphRepository<Distancia>{

	 @Query("MATCH (from:Ponto { nome:{0} }), (to:Ponto { nome: {1}}) , path = (from)-[:RELATIONSHIPS*]->(to) "+ 
	 "RETURN path AS menorCaminho, "+
	     " reduce(kmDistancia = 0, r in relationships(path) | kmDistancia+r.kmDistancia) AS distanciaTotal "+
	     " ORDER BY distanciaTotal ASC " +
	     "LIMIT 1")
	 MelhorCaminho getMelhorCaminho(String origem, String destino);

}
