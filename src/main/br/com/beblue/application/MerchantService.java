package br.com.beblue.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beblue.domain.Merchant;
import br.com.beblue.repository.MerchantRepository;

@Service
public class MerchantService {
	
	@Autowired
	private MerchantRepository repository;
	
	public Merchant findById(int id) {
		return repository.findById(id);
	}

}
