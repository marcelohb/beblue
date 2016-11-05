package br.com.beblue.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.beblue.domain.TransactionType;
import br.com.beblue.domain.User;
import br.com.beblue.repository.TransactionTypeRepository;
import br.com.beblue.repository.UserRepository;

@Component
public class PreLoad {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TransactionTypeRepository typeRepository;
	
	private RestTemplate restTemplate;
	
	@PostConstruct
	public void preLoad() {
		restTemplate = new RestTemplate();
		User[] users = restTemplate.getForObject("https://quarkbackend.com/getfile/vilibaldo-neto/json-javatest-users", User[].class);
		userRepository.deleteAll();
		for (User u : users) {
			userRepository.save(u);
		}
		
		restTemplate = new RestTemplate();
		TransactionType[] types = restTemplate.getForObject("https://quarkbackend.com/getfile/vilibaldo-neto/json-javatest-transactiontypr", TransactionType[].class);
		typeRepository.deleteAll();
		for (TransactionType t : types) {
			typeRepository.save(t);
		}
	}

}
