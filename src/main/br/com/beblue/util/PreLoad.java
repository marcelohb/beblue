package br.com.beblue.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.beblue.domain.User;
import br.com.beblue.repository.TransactionTypeRepository;
import br.com.beblue.repository.UserRepository;

@Component
public class PreLoad {
	
	@Autowired
	private static UserRepository userRepository;
	
	@Autowired
	private static TransactionTypeRepository typeRepository; 
	
	private static RestTemplate restTemplate;
	
	public static void preLoad() {
//		restTemplate = new RestTemplate();
//		User[] users = restTemplate.getForObject("https://quarkbackend.com/getfile/vilibaldo-neto/json-javatest-users", User[].class);
//		userRepository.deleteAll();
//		for (User u : users) {
//			userRepository.save(u);
//		}
	}

}
