package com.mapalogistica.rota;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapalogistica.domain.CustoRota;
import com.mapalogistica.domain.MelhorCaminho;
import com.mapalogistica.repository.DistanciaRepository;

@Service
public class RotaService {
	
	@Autowired DistanciaRepository distanciaRepository;

	@Transactional
	public CustoRota getCustoRota(String origem, String destino, Double autonomia, Double precoCombustivel) {		
		MelhorCaminho melhorCaminho  = distanciaRepository.getMelhorCaminho(origem, destino);			
		if(melhorCaminho != null){
			CustoRota custoRota = new CustoRota();
			Double gastoCaminho = getPreco(melhorCaminho.getDistanciaTotal(), autonomia, precoCombustivel);
			custoRota.setMenorDistanciaKm(melhorCaminho.getDistanciaTotal());
			custoRota.setTotalPrecoCombustivel(gastoCaminho);
			custoRota.setCaminho(montarCaminho(melhorCaminho.getMenorCaminho()));
			return custoRota;
			
		}	
		return null;
	}

	private String montarCaminho(List<String> menorCaminho) {

		return menorCaminho.toString();
	}

	private Double getPreco(Double distanciaTotal, Double autonomia, Double precoCombustivel) {				
		if(distanciaTotal != null && autonomia != null && precoCombustivel != null){		
			return (distanciaTotal / autonomia) * precoCombustivel;			
		}		
		return null;
	}
	
	
	

}
