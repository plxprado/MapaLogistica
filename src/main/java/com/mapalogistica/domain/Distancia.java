package com.mapalogistica.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type="DIS_KM")
public class Distancia {
	
	@GraphId   private Long relationshipId;
    @Property  private Double kmDistancia;
    @StartNode private Ponto origemPonto;
    @EndNode   private Ponto fimPonto;
    
	public Distancia(Ponto origem, Ponto destino, Double km) {
		this.origemPonto = origem;
		this.fimPonto = destino;
		this.kmDistancia = km;
		
	}
	
	public Distancia() {}
	
	public Long getRelationshipId() {
		return relationshipId;
	}
	
	
	public void setRelationshipId(Long relationshipId) {
		this.relationshipId = relationshipId;
	}
	public Double getKmDistancia() {
		return kmDistancia;
	}
	public void setKmDistancia(Double kmDistancia) {
		this.kmDistancia = kmDistancia;
	}
	public Ponto getOrigemPonto() {
		return origemPonto;
	}
	public void setOrigemPonto(Ponto origemPonto) {
		this.origemPonto = origemPonto;
	}
	public Ponto getFimPonto() {
		return fimPonto;
	}
	public void setFimPonto(Ponto fimPonto) {
		this.fimPonto = fimPonto;
	}	
	

}
