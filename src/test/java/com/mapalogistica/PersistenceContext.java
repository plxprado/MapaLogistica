package com.mapalogistica;


import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.server.InProcessServer;
import org.springframework.data.neo4j.server.Neo4jServer;


//@Configuration
//@EnableNeo4jRepositories("com.mapalogistica.repository")
//@EnableTransactionManagement
//@ComponentScan("com.mapalogistica")
public class PersistenceContext extends Neo4jConfiguration {

    @Override
    public SessionFactory getSessionFactory() {
        return new SessionFactory("com.mapalogistica.domain");
    }

    @Bean
    public Neo4jServer neo4jServer() {
        return new InProcessServer();
    }

    @Override
    @Bean
    public Session getSession() throws Exception {
        return super.getSession();
    }
}