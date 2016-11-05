package br.com.beblue.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.beblue.domain.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

	List<Transaction> findAll();

}
