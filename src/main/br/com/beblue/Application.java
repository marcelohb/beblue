package br.com.beblue;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import br.com.beblue.domain.TransactionType;
import br.com.beblue.domain.User;
import br.com.beblue.repository.TransactionTypeRepository;
import br.com.beblue.repository.UserRepository;

@SpringBootApplication
public class Application {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private TransactionTypeRepository typeRpository;
	
	RestTemplate restTemplate;

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
	
	@PostConstruct
	private void load() {
		
        restTemplate = new RestTemplate();
		User[] users = restTemplate.getForObject("https://quarkbackend.com/getfile/vilibaldo-neto/json-javatest-users", User[].class);
		userRepository.deleteAll();
		for (User u : users) {
			userRepository.save(u);
		}
		
		restTemplate = new RestTemplate();
		TransactionType[] types = restTemplate.getForObject("https://quarkbackend.com/getfile/vilibaldo-neto/json-javatest-transactiontypr", TransactionType[].class);
		typeRpository.deleteAll();
		for (TransactionType t : types) {
			typeRpository.save(t);
		}
	}
}