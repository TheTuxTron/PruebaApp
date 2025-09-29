package com.backend.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class TestBD {

    public static void main(String[] args) {
        SpringApplication.run(TestBD.class, args);
    }

    @Bean
    public CommandLineRunner testConnection(DataSource dataSource) {
        return args -> {
            System.out.println("✅ Probando conexión con la base de datos...");

            try (Connection connection = dataSource.getConnection()) {
                if (connection.isValid(2)) { // timeout de 2 segundos
                    System.out.println("✅ Conexión exitosa a la base de datos.");
                } else {
                    System.err.println("❌ Conexión fallida a la base de datos.");
                }
            } catch (Exception ex) {
                System.err.println("❌ Error al conectar con la base de datos:");
                ex.printStackTrace();
            }
        };
    }
}
