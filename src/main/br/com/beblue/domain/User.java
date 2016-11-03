package br.com.beblue.domain;

public class User {
	
	private int id;
	private String cpf;
	private String name;
	private Double balance;
	
	public User(String cpf, String name) {
		this.cpf = cpf;
		this.name = name;
		this.balance = Double.valueOf(0.0);
	}
	
	public int getId() {
		return id;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getName() {
		return name;
	}
	
	public Double getBalance() {
		return balance;
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
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

}
