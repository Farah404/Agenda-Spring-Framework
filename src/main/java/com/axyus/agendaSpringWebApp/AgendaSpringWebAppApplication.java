package com.axyus.agendaSpringWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan("com.axyus.agendaSpringWebApp.service")
//@EnableJpaRepositories("com.axyus.agendaSpringWebApp.repository")
public class AgendaSpringWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaSpringWebAppApplication.class, args);
	}

}
