package br.com.beblue.web.data;

public class TransactionData {
	
	private String userCpf;
	private int merchandId;
	private Double transactionValue;
	private String transactionName;
	
	public TransactionData(String userCpf, int merchandId, Double transactionValue, String transactionName) {
		this.userCpf = userCpf;
		this.merchandId = merchandId;
		this.transactionValue = transactionValue;
		this.transactionName = transactionName;
	}

	public String getUserCpf() {
		return userCpf;
	}

	public void setUserCpf(String userCpf) {
		this.userCpf = userCpf;
	}

	public int getMerchandId() {
		return merchandId;
	}

	public void setMerchandId(int merchandId) {
		this.merchandId = merchandId;
	}

	public Double getTransactionValue() {
		return transactionValue;
	}

	public void setTransactionValue(Double transactionValue) {
		this.transactionValue = transactionValue;
	}

	public String getTransactionName() {
		return transactionName;
	}

	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}
	
	public TransactionData() {}

}
