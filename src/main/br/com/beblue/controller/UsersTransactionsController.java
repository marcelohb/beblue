package br.com.beblue.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.beblue.domain.Transaction;
import br.com.beblue.repository.TransactionRepository;
import br.com.beblue.web.data.UserTransactionData;

@RestController
public class UsersTransactionsController {
	
	@Autowired
	private TransactionRepository repository;

	@RequestMapping(name="/users-transactions")
	public List<UserTransactionData> transactions() {
		List<Transaction> transactions = repository.findAll();
		List<UserTransactionData> data = new ArrayList<>();
		for (Transaction t : transactions) {
			data.add(new UserTransactionData(t, t.getUser()));
		}
		return data;
	}
}
