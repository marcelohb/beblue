package br.com.beblue.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(unique=true)
	private String userCpf;
	private String name;
	private Double balance;
	
	public User(String cpf, String name) {
		this.userCpf = cpf;
		this.name = name;
		this.balance = Double.valueOf(0.0);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUser_cpf() {
		return userCpf;
	}
	
	public void setUser_cpf(String cpf) {
		this.userCpf = cpf;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getBalance() {
		return balance;
	}
	
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public void sacar(Double value) {
		balance -= value;
		if (balance < 0d) {
			balance = Double.valueOf(0.0);
		}
	}

	public void depositar(Double valor) {
		balance += valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userCpf == null) ? 0 : userCpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userCpf == null) {
			if (other.userCpf != null)
				return false;
		} else if (!userCpf.equals(other.userCpf))
			return false;
		return true;
	}
	
	protected User() {}

}
