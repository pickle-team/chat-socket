package com.pickle.socket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJdbcHttpSession
@EnableTransactionManagement
public class SessionConfig {
    
    @Bean
    public LobHandler lobHandler() {
        return new DefaultLobHandler();
    }
} 