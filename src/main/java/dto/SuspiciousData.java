package dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;





public class SuspiciousData {
	
	HashMap<String, List<String>> suspiciousTransactionIdsByMonth;
	List<String[]> suspiciousAccounts;
	
	public SuspiciousData() {
		this.suspiciousTransactionIdsByMonth = new HashMap<String, List<String>>();
		this.suspiciousAccounts = new ArrayList<String[]>();
	}
	
	public void setSuspiciousTransactionIdsByMonth(String month, String transactionId) {
		if(suspiciousTransactionIdsByMonth.containsKey(month)) {
			List<String> transactionIds = suspiciousTransactionIdsByMonth.get(month);
			transactionIds.add(transactionId);
			suspiciousTransactionIdsByMonth.put(month, transactionIds);
		}
		else {
			List<String> transactionIds = new ArrayList<String>();
			transactionIds.add(transactionId);
			suspiciousTransactionIdsByMonth.put(month, transactionIds);
		}
	}
	
	public void setSuspiciousAccounts(String[] accounts) {
		if(!isRedundant(accounts)) {
			suspiciousAccounts.add(accounts);
		}
	}
	
	public HashMap<String, List<String>> getSuspiciousTransactionIdsByMonth() {
		return suspiciousTransactionIdsByMonth;
	}
	
	public List<String[]> getSuspiciousAccounts() {
		return suspiciousAccounts;
	}
	
	private Boolean isRedundant(String[] accounts) {
		for (String[] suspiciousAccount : suspiciousAccounts) {
			if((suspiciousAccount[0].equals(accounts[0]) && suspiciousAccount[1].equals(accounts[1]))
					|| (suspiciousAccount[0].equals(accounts[1]) && suspiciousAccount[1].equals(accounts[0]))) {
				return true;
			}
		}
		return false;
	}
}
