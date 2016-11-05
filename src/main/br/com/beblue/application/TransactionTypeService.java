package br.com.beblue.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beblue.domain.TransactionType;
import br.com.beblue.repository.TransactionTypeRepository;

@Service
public class TransactionTypeService {

	@Autowired
	private TransactionTypeRepository repository;
	
	public TransactionType findByType(String type) {
		return repository.findByTransactionType(type);
	}
}
