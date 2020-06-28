package service;

import java.util.ArrayList;
import java.util.List;

import dto.TransactionDataRequest;
import interfaces.DataService;



public class TransactionService implements DataService<TransactionDataRequest> {
	
	private static List<TransactionDataRequest> transactions = new ArrayList<TransactionDataRequest>();
	
	public List<TransactionDataRequest> getTransactions() {
		return transactions;
	}
	
	public void addSingleRecord(TransactionDataRequest record) {
		transactions.add(record);
	}
	
	public void addBulkRecords(List<TransactionDataRequest> records) {
		for (TransactionDataRequest transaction : records) {
			transactions.add(transaction);
		}
	}
}
