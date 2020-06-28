package service;

import java.text.SimpleDateFormat;
import java.util.List;

import dto.SuspiciousData;
import dto.TransactionDataRequest;





public class SuspicionDetectionService {
	
	private static SuspiciousData suspiciousData = new SuspiciousData();
	
	public void detectSuspiciousActivity() {
		TransactionService transactionService = new TransactionService();
		List<TransactionDataRequest> transactions =  transactionService.getTransactions();
		SimpleDateFormat monthFormat = new SimpleDateFormat("MMM");
		for (TransactionDataRequest transaction : transactions) {
			if(isSuspiciousActivity(transaction)) {
				suspiciousData.setSuspiciousTransactionIdsByMonth(monthFormat.format(transaction.getDate()), transaction.getTransactionId());
				suspiciousData.setSuspiciousAccounts(new String[] {transaction.getFromAccount(), transaction.getToAccount()});
			}
		}
	}
	
	public SuspiciousData getSuspiciousData() {
		return suspiciousData;
	}
	
	private Boolean isSuspiciousActivity(TransactionDataRequest transaction) {
		String fromAccount = transaction.getFromAccount();
		String toAccount = transaction.getToAccount();
		CustomerDataService customerService = new CustomerDataService();
		if(customerService.getAddressByAccountNumber(fromAccount).equalsIgnoreCase(customerService.getAddressByAccountNumber(toAccount))
				&& customerService.getPhoneNumberByAccountNumber(fromAccount).equalsIgnoreCase(customerService.getPhoneNumberByAccountNumber(toAccount))) {
			return true;
		}
		return false;
	}
	
}
