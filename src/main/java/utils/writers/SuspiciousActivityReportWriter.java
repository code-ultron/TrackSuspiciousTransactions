package utils.writers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import service.SuspicionDetectionService;

public class SuspiciousActivityReportWriter {
	
	private String fileLocation;
	private static String newLine = System.getProperty("line.separator");
	private SuspicionDetectionService suspicionDetectionService;
	
	public SuspiciousActivityReportWriter(String fileLocation) {
		this.fileLocation = fileLocation;
		suspicionDetectionService = new SuspicionDetectionService();
	}
	
	public void generateReport() throws IOException {
		FileWriter fileWriter = new FileWriter(fileLocation);
		for(Entry<String, List<String>> entry : getMonthlyClassifiedSuspiciousTransactions().entrySet()) {
			fileWriter.write("For The Month of " + entry.getKey() + ":" + newLine);
			fileWriter.write("Suspicious Transactions :" + newLine);
			for (String transactionId : entry.getValue()) {
				fileWriter.write(transactionId + newLine);
			}
			fileWriter.write(newLine);
		}
		fileWriter.write("Suspicious Accounts" + newLine);
		for (String[] suspiciousAccounts : getSuspiciousAccounts()) {
			fileWriter.write("[" + suspiciousAccounts[0] + ", " + suspiciousAccounts[1] + "]" + newLine);
		}
		fileWriter.close();
	}
	
	private HashMap<String, List<String>> getMonthlyClassifiedSuspiciousTransactions() {
		return suspicionDetectionService.getSuspiciousData().getSuspiciousTransactionIdsByMonth();
	}
	
	private List<String[]> getSuspiciousAccounts() {
		return suspicionDetectionService.getSuspiciousData().getSuspiciousAccounts();
	}
}
