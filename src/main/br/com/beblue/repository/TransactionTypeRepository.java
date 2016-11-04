package br.com.beblue.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.beblue.domain.TransactionType;

public interface TransactionTypeRepository extends CrudRepository<TransactionType, Integer> {
	
	TransactionType findByTransactionType(String type);
	
	TransactionType findByTransactionName(String name);
	
	TransactionType findById(int id);

}
