package com.rme.post;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootPostApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootPostApplication.class, args);
	}
    @Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory e) {
		return e.getSessionFactory();
	}
	
}
