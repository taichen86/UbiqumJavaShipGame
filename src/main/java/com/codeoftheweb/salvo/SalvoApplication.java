package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository repository) {
		return (args) -> {
			// create players
			repository.save(new Player("j.bauer@ctu.gov"));
			repository.save(new Player("c.obrian@ctu.gov"));
			repository.save(new Player("t.almeida@ctu.gov"));
			repository.save(new Player("d.palmer@whitehouse.gov"));


		};
	}

}
