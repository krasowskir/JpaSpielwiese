package com.example.jpaSpielwiese.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories("com.example.jpaSpielwiese")
@EnableTransactionManagement
public class MainConfiguration {

//    @Value("${jpaSpielwiese.datasource.driverClassName}")
//    String driverClassName;
//
//    @Value("${jpaSpielwiese.datasource.url}")
//    String databaseUrl;
//
//    @Value("${jpaSpielwiese.datasource.username}")
//    String username;
//
//    @Value("${jpaSpielwiese.datasource.password}")
//    String password;
//
//    @Bean
//    public DataSource dataSource() {
//        SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
//
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUrl(databaseUrl);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        dataSource.setSuppressClose(true);
//        return dataSource;
//    }
}
