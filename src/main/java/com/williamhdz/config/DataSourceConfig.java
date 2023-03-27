package com.williamhdz.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class DataSourceConfig {
   
    public DataSource getDataSource() {
    	System.out.println("Conectando a la BD");
        return DataSourceBuilder.create()
          .driverClassName("com.mysql.cj.jdbc.Driver")
          .url("jdbc:mysql://localhost:3306/db_party")
          .username("root")
          .password("root")
          .build();	
    }
}
