package com.mapalogistica.domain;

import java.util.List;

import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class MelhorCaminho {

	
	List<String> menorCaminho;
	Double distanciaTotal;
	
	
	public List<String> getMenorCaminho() {
		return menorCaminho;
	}
	public void setMenorCaminho(List<String> menorCaminho) {
		this.menorCaminho = menorCaminho;
	}
	public Double getDistanciaTotal() {
		return distanciaTotal;
	}
	public void setDistanciaTotal(Double distanciaTotal) {
		this.distanciaTotal = distanciaTotal;
	}
	
	
	
	
	
	
	
	
}
