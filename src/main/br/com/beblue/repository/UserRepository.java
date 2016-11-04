package br.com.beblue.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.beblue.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByUserCpf(String cpf);

	User findById(int id);

}
