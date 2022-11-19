package com.example.pruebaFinal.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class ConfiguracionApp {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl("jdbc:sqlserver://localhost;databaseName=master;trustServerCertificate=true");
        driverManagerDataSource.setUsername("sa");
        driverManagerDataSource.setPassword("1234");
        return driverManagerDataSource;
    }
}
