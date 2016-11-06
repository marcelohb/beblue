package br.com.beblue.application;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beblue.domain.Merchant;
import br.com.beblue.domain.Transaction;
import br.com.beblue.domain.TransactionType;
import br.com.beblue.domain.User;
import br.com.beblue.repository.TransactionRepository;
import br.com.beblue.web.data.TransactionData;

@Service
public class TransactionService {

	private User user;
	private Merchant merchant;
	
	@Autowired
	private TransactionRepository repository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MerchantService merchantService;
	
	@Autowired
	private TransactionTypeService type;
	
	@Autowired
	private UsersTransactionsService usersTransaction;
	
	public void registrerTransaction(TransactionData transaction) {
		user = userService.findByCpf(transaction.getUser_cpf());
		merchant = merchantService.findById(transaction.getMerchant_id());
		this.setCashbackMerchant();
		TransactionType transactionType = type.findByType(transaction.getTransaction_type());
		Transaction t = new Transaction(user, merchant, transaction.getTransaction_value(), transactionType);
		usersTransaction.registerTransaction(t, merchant);
		repository.save(t);
		userService.updateUser(user);
	}

	public List<Transaction> getAll() {
		return repository.findAll();
	}
	
	private void setCashbackMerchant() {
		HashMap<DayOfWeek, Double> cashbacks = new HashMap<>();
		cashbacks.put(DayOfWeek.SUNDAY, 5d);
		cashbacks.put(DayOfWeek.MONDAY, 10d);
		cashbacks.put(DayOfWeek.TUESDAY, 15d);
		cashbacks.put(DayOfWeek.WEDNESDAY, 20d);
		cashbacks.put(DayOfWeek.THURSDAY, 25d);
		cashbacks.put(DayOfWeek.FRIDAY, 30d);
		cashbacks.put(DayOfWeek.SATURDAY, 35d);
		merchant.setCashbacks(cashbacks);
	}

}
