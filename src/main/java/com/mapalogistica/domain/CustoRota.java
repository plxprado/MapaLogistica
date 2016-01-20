package com.mapalogistica.domain;


public class CustoRota {

	
	private Double totalPrecoCombustivel;
	private Double menorDistanciaKm;
	private String caminho;
	
	
	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public Double getTotalPrecoCombustivel() {
		return totalPrecoCombustivel;
	}
	
	public void setTotalPrecoCombustivel(Double totalPrecoCombustivel) {
		this.totalPrecoCombustivel = totalPrecoCombustivel;
	}
	
	public Double getMenorDistanciaKm() {
		return menorDistanciaKm;
	}
	
	public void setMenorDistanciaKm(Double menorDistanciaKm) {
		this.menorDistanciaKm = menorDistanciaKm;
	}
	

}
