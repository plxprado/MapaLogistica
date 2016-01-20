package com.mapalogistica;


import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mapalogistica.repository.DistanciaRepository;
import com.mapalogistica.repository.PontoRepository;

@Configuration
@EnableNeo4jRepositories("com.mapalogistica.repository")
@EnableTransactionManagement
@ComponentScan("com.mapalogistica")
public class Application extends Neo4jConfiguration {
	
	 @Autowired DistanciaRepository distanciaRepository;
	 @Autowired PontoRepository pontoRepository;  
	 @Autowired Session session;

    public static final int NEO4J_PORT = 7474;
    

    @Override
    public SessionFactory getSessionFactory() {
        return new SessionFactory("com.mapalogistica.domain");
    }

    @Bean
    public Neo4jServer neo4jServer() {    	    	
        return new RemoteServer("http://wmtestedb.sb02.stations.graphenedb.com:24789","wmteste_db","FcRYrh8sRCosILtkFQKT");
        
    }

    @Override
    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Session getSession() throws Exception {
        return super.getSession();
    }
    
   
}