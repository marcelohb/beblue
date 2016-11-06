package br.com.beblue.application;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beblue.Application;
import br.com.beblue.domain.Merchant;
import br.com.beblue.domain.Transaction;
import br.com.beblue.domain.TransactionType;
import br.com.beblue.domain.User;
import br.com.beblue.repository.TransactionRepository;
import br.com.beblue.web.data.TransactionData;

@Service
public class TransactionService {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private TransactionRepository repository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MerchantService merchantService;
	
	@Autowired
	private TransactionTypeService type;
	
	public void registrerTransaction(TransactionData transaction) {
		log.info("Service....");
		User user = userService.findByCpf(transaction.getUser_cpf());
		log.info("User OK");
		Merchant merchant = merchantService.findById(transaction.getMerchant_id());
		log.info("Merchant OK");
		TransactionType transactionType = type.findByType(transaction.getTransaction_type());
		log.info("Type OK");
		repository.save(new Transaction(user, merchant, transaction.getTransaction_value(), transactionType));
		log.info("Saved");
	}

	public List<Transaction> getAll() {
		return repository.findAll();
	}

}
