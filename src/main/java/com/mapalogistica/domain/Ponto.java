package com.mapalogistica.domain;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;


@NodeEntity
public class Ponto {

	@GraphId
	private Long id;
	
	public Ponto(String nome) {this.nome = nome;}
	
	public Ponto() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	private String nome;
	

	Set<Distancia> relationships = new HashSet<Distancia>();
	public Distancia relatedTo(Ponto thing, Double km){
	    Distancia thingRelationship = new Distancia(this, thing, km);
	    relationships.add(thingRelationship);
	    return thingRelationship;
	}
	
	public Set<Distancia> getRelationships() {
	    return relationships;
	}
	
	
}
