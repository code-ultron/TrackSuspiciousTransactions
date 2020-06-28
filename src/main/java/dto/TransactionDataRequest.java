package dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;





public class TransactionDataRequest {

	String transactionId;
	Date date;
	String fromAccount;
	String toAccount;
	Double amount;
	
	public TransactionDataRequest(String transactionId, String date, String fromAccount,
			String toAccount, String amount) {
		super();
		this.transactionId = transactionId.trim();
		try {
			this.date = new SimpleDateFormat("dd-MMM-yy").parse(date.trim());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.fromAccount = fromAccount.trim();
		this.toAccount = toAccount.trim();
		this.amount = Double.parseDouble(amount.trim());
	}

	
	public String getTransactionId() {
		return transactionId;
	}
	public Date getDate() {
		return date;
	}
	public String getFromAccount() {
		return fromAccount;
	}
	public String getToAccount() {
		return toAccount;
	}
	public Double getAmount() {
		return amount;
	}
	

}
