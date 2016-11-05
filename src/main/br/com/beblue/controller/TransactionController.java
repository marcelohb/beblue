package br.com.beblue.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.beblue.Application;
import br.com.beblue.application.TransactionService;
import br.com.beblue.domain.Transaction;
import br.com.beblue.web.data.TransactionData;

@RestController
public class TransactionController {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private TransactionService service;
	
	@RequestMapping(value="/register-transaction", method = RequestMethod.POST)
	@ResponseBody
	public void registerTransaction(@RequestBody TransactionData transaction) {
		log.info("Request for CPF: " + transaction.getUserCpf());
		service.registrerTransaction(transaction);
		log.info("Finished");
	}
	
	@RequestMapping(value="/transactions")
	public List<Transaction> transactions() {
		return service.getAll();
	}

}
