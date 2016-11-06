package br.com.beblue.domain;

import java.time.DayOfWeek;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Merchant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@Transient
	private HashMap<DayOfWeek, Double> cashbacks = new HashMap<>();
	
	public Merchant(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public HashMap<DayOfWeek, Double> getCashbacks() {
		return cashbacks;
	}
	
	public void setCashbacks(HashMap<DayOfWeek, Double> cashbacks) {
		this.cashbacks = cashbacks;
	}

	public Merchant() {}

	public Double getCashBackFromString(String dayOfWeek) {
		if (cashbacks.isEmpty())
			return 0d;
		return getCashbacks().get(DayOfWeek.valueOf(dayOfWeek.toUpperCase()));
	}

}
