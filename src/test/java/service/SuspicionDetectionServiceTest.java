package service;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import dto.SuspiciousData;
import utils.readers.CustomerDataFileReader;
import utils.readers.TransactionFileReader;





public class SuspicionDetectionServiceTest {

	@Test
	public void willGiveExpectedResultOnDetectionTest() throws FileNotFoundException {
		ingestCustomerData();
		ingestTransactionData();
		
		SuspicionDetectionService suspicionDetectionService = new SuspicionDetectionService();
		suspicionDetectionService.detectSuspiciousActivity();
		
		SuspiciousData actualSuspiciousData = suspicionDetectionService.getSuspiciousData();
		assertTrue(isEqual(actualSuspiciousData));
	}
	
	private void ingestTransactionData() throws FileNotFoundException {
		String TRANSACTION_DATA_FILE_LOCATION = "C:\\Users\\ULTRON\\Desktop\\Credit_Problem\\com.bank.TrackSuspiciousTransaction\\src\\test\\resources\\transactionData\\Sample_Transaction_Data.txt"; 
		TransactionFileReader transactionFileReader = new TransactionFileReader(TRANSACTION_DATA_FILE_LOCATION);	
		transactionFileReader.importDataIntoService();
	}
	
	private void ingestCustomerData() throws FileNotFoundException {
		String CUSTOMER_DATA_FILE_LOCATION = "C:\\Users\\ULTRON\\Desktop\\Credit_Problem\\com.bank.TrackSuspiciousTransaction\\src\\test\\resources\\customerData\\Sample_Customer_Data.txt";
		CustomerDataFileReader customerDataFileReader = new CustomerDataFileReader(CUSTOMER_DATA_FILE_LOCATION);
		customerDataFileReader.importDataIntoService();
	}
	
	private SuspiciousData getExpectedResult() {
		SuspiciousData expectedSuspiciousData = new SuspiciousData();
		expectedSuspiciousData.setSuspiciousTransactionIdsByMonth("Jan", "T0175896345");
		expectedSuspiciousData.setSuspiciousTransactionIdsByMonth("Feb", "T0175896350");
		expectedSuspiciousData.setSuspiciousAccounts(new String[] {"10010589","80074567"});
		return expectedSuspiciousData;
	}
	
	private boolean isEqual(SuspiciousData actualSuspiciousData) {
		SuspiciousData expectedSuspiciousData = getExpectedResult();
		if(expectedSuspiciousData.getSuspiciousTransactionIdsByMonth().equals(actualSuspiciousData.getSuspiciousTransactionIdsByMonth())
			&& areListsEqual(expectedSuspiciousData.getSuspiciousAccounts(),actualSuspiciousData.getSuspiciousAccounts())) {
			return true;
		}
		return false;
	}
	
	private static boolean areListsEqual(List<String[]> expected, List<String[]> actual) {
	    if (expected.size() != actual.size()) {
	        return false;
	    }

	    for (int index = 0; index < expected.size(); index++) {
	        if (!Arrays.equals(expected.get(index), actual.get(index))){
	            return false;
	        }
	    }
	    return true;
	}

}
