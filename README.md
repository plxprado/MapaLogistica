# MapaLogistica

MapaLogistica - Sistema com interface Rest para resolver problema de menor caminho

### Versão
0.0.1-SNAPSHOT

### Tecnologias envolvidas

Para facilitar o desenvolvimento do sistema, foi usado algumas tecnoligias de comum uso no mercado:

* [Neo4j] Base de dados NoSQL com conceito de grafo
* [SpringNeo4j] Plugin do spring que da suporte ao Neo4j
* [SpringJunit] plugin do spring para testes

### Instalação

Para instalar, basta gerar o war via Maven ou anexar o projeto no eclipse. 

Rodar em qualquer container WEB de preferência Tomcat 7+ onde foi testado.

### Neo4j

 - O Neo4j foi uma opção devido ser simples e com bastante suporte o Spring, por exemplo, dá um suporte bem interessante.
 - Foi criado uma instância do Node4j no GrapheneDB, para facilitar o teste, nassa instância tem uma malhalogistica carregada seguindo o exemplo aprensentado no desafio. link para o GrapheneDB  http://www.graphenedb.com/

 - Além de ser popular é fácil de implementar, dessa maneira foi mais natural resolver o problema do menor caminho entre um nó origem e um nó destino.
 
Exemplo:



```java

@Query("MATCH (from:Ponto { nome:{0} }), (to:Ponto { nome: {1}}) , path = (from)-[:RELATIONSHIPS*]->(to) "+ 
	 "RETURN path AS menorCaminho, "+
	     " reduce(kmDistancia = 0, r in relationships(path) | kmDistancia+r.kmDistancia) AS distanciaTotal "+
	     " ORDER BY distanciaTotal ASC " +
	     "LIMIT 1")
	 MelhorCaminho getMelhorCaminho(String origem, String destino);

```
### Spring Rest + Neo4j + JUnit
 - Como citado o Spring oferece um suporte muito bom para o Neo4j como citato e também fornece um bom suport para o Rest
 
Exemplo:


```java

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

```


### Testar o App do Desafio

- Para carregar a malha dada de exemplo no app: ex: A->B, A->C .....

```java
 
 http://url_servidor_local:porta/importarmalhatest

```
- Para pegar o caminho mais curto de um ponto x ao y


```java
 
 http://url_servidor_local:porta/MapaLogistica/custorota?origen=A&destino=D&autonomia=10&preco=2
 
 - Retorno um JSON com as informações: valor combustivel do melhor caminho entre X e Y e distância percorrida e o caminho(nós percorridos)
 
 {"totalPrecoCombustivel":5.0,"menorDistanciaKm":25.0,"caminho":"[{nome=A}, {kmDistancia=10.0}, {nome=B}, {kmDistancia=15.0}, {nome=D}]"}

```



### Desenvolvendo
 - Criando tela para criação de malhas logisticas dinâmicas
 

### Contato

  prado.tf@gmail.com


    
    
    

