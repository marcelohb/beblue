package br.com.beblue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.beblue.util.PreLoad;

@SpringBootApplication
public class Application {
	
	public PreLoad preLoad() {
		return new PreLoad();
	}

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}