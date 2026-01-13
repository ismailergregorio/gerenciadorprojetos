package br.edu.suauniversidade.fabrica.gerenciadorprojetos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableJpaAuditing
@SpringBootApplication
public class GerenciadorprojetosApplication {
	public static void main(String[] args) {
		SpringApplication.run(GerenciadorprojetosApplication.class, args);
	}
}