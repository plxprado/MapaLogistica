package com.mapalogistica.importdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapalogistica.domain.Ponto;
import com.mapalogistica.repository.DistanciaRepository;
import com.mapalogistica.repository.PontoRepository;

@Service
public class PopularMalhaLogistica {

    
    @Autowired PontoRepository pontoRepository;  
	@Autowired DistanciaRepository distanciaRepository;

	@Transactional
	public void polularMalhaLogistica(){		
		 	Ponto A = new Ponto("A");
	        Ponto B = new Ponto("B");
	        Ponto C = new Ponto("C");
	        Ponto D = new Ponto("D");
	        Ponto E = new Ponto("E");
	       
	        A.relatedTo(B, 10D);
	        B.relatedTo(D, 15D);
	        A.relatedTo(C, 20D);
	        C.relatedTo(D, 30D);
	        B.relatedTo(E, 50D);
	        D.relatedTo(E, 30D);
	        
	        pontoRepository.save(A);
	        pontoRepository.save(B);
	        pontoRepository.save(C);
	        pontoRepository.save(D);
	        pontoRepository.save(E);
	        
	}
	

}
