package br.com.beblue.application;

import org.springframework.stereotype.Service;

import br.com.beblue.domain.Merchant;
import br.com.beblue.domain.Transaction;
import br.com.beblue.domain.User;
import br.com.beblue.domain.UsersTransactions;

@Service
public class UsersTransactionsService {

	public User registerTransaction(Transaction t, Merchant m) {
		UsersTransactions ut = new UsersTransactions();
		ut.registerTransaction(t, m);
		return ut.getUser(t.getUser().getId());
	}

}
