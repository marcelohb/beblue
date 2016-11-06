package br.com.beblue.web.data;

public class TransactionData {
	
	private String userCpf;
	private int merchantId;
	private Double transactionValue;
	private String transactionType;
	
	public TransactionData(String userCpf, int merchantId, Double transactionValue, String transactionType) {
		this.userCpf = userCpf;
		this.merchantId = merchantId;
		this.transactionValue = transactionValue;
		this.transactionType = transactionType;
	}

	public String getUser_cpf() {
		return userCpf;
	}

	public void setUser_cpf(String userCpf) {
		this.userCpf = userCpf;
	}

	public int getMerchant_id() {
		return merchantId;
	}

	public void setMerchant_id(int merchantId) {
		this.merchantId = merchantId;
	}

	public Double getTransaction_value() {
		return transactionValue;
	}

	public void setTransaction_value(Double transactionValue) {
		this.transactionValue = transactionValue;
	}

	public String getTransaction_type() {
		return transactionType;
	}

	public void setTransaction_type(String transactionType) {
		this.transactionType = transactionType;
	}
	
	public TransactionData() {}

}
