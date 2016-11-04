package br.com.beblue.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.beblue.domain.Merchant;

public interface MerchantRepository extends CrudRepository<Merchant, Integer> {
	
	Merchant findById(int id);

}
