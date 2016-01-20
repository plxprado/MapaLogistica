package com.mapalogistica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mapalogistica.domain.CustoRota;
import com.mapalogistica.importdata.PopularMalhaLogistica;
import com.mapalogistica.rota.RotaService;

@RestController
public class CarregaMapaController {
	
	private PopularMalhaLogistica popularMalhaLogisticaService;
	
	@Autowired private RotaService rotaService;

    @Autowired
    public CarregaMapaController(PopularMalhaLogistica popularMalhaLogisticaService) {
        this.popularMalhaLogisticaService = popularMalhaLogisticaService;
    }
    
  
    
    @RequestMapping(value = "/importarmalhatest", method = RequestMethod.GET)
    public String importData(){    
    	popularMalhaLogisticaService.polularMalhaLogistica();
    	return "importdata/result";
    }
    

    @RequestMapping(value = "/custorota", method = RequestMethod.GET)
    public CustoRota calculoRota(@RequestParam(value="origen") String origem, 
    								@RequestParam(value="destino") String destino, 
    								@RequestParam(value="autonomia") Double autonomia,
    								@RequestParam(value="preco") Double precoCombustivel) {
    	
    	CustoRota custoRota = null;
    	if(origem != null && destino != null){
    			custoRota =  rotaService.getCustoRota(origem, destino, autonomia, precoCombustivel);
    		
    	}
    	return custoRota;
   	 }
    
    
	

}
