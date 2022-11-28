package com.antonio.crudtarefas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudTarefasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudTarefasApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(TarefasRepository tarefasRepository) {
		return args -> {
			tarefasRepository.deleteAll();

			Tarefas t = new Tarefas();
			t.setTarefas("Projecto");
			t.setDescrition("Entregar ao Hugo");

			tarefasRepository.save(t);
		};
	}

}