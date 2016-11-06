package br.com.beblue.domain;

import java.time.DayOfWeek;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Merchant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private HashMap<DayOfWeek, Double> cashbacks;
	
	public Merchant(String name) {
		this.name = name;
		cashbacks = new HashMap<>();
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
		return getCashbacks().get(DayOfWeek.valueOf(dayOfWeek.toUpperCase()));
	}

}
