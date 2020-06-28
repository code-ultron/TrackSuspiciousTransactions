import java.io.IOException;

import service.SuspicionDetectionService;
import utils.readers.CustomerDataFileReader;
import utils.readers.TransactionFileReader;
import utils.writers.SuspiciousActivityReportWriter;

/**
 * 
 */

/**
 * @author ULTRON
 *
 */
public class MainApplication {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String CUSTOMER_DATA_FILE_LOCATION = "C:\\Users\\ULTRON\\Desktop\\Credit_Problem\\com.bank.TrackSuspiciousTransaction\\src\\main\\resources\\customerData\\Sample_Customer_Data.txt";
		String TRANSACTION_DATA_FILE_LOCATION = "C:\\Users\\ULTRON\\Desktop\\Credit_Problem\\com.bank.TrackSuspiciousTransaction\\src\\main\\resources\\transactionData\\Sample_Transaction_Data.txt"; 
		String SUSPICIOUS_ACTIVITY_REPORT_FILE_LOCATION = "C:\\Users\\ULTRON\\Desktop\\Credit_Problem\\com.bank.TrackSuspiciousTransaction\\src\\main\\resources\\suspiciousActivityReport\\Suspicious_Activity_Report.txt"; 
		
		CustomerDataFileReader customerDataFileReader = new CustomerDataFileReader(CUSTOMER_DATA_FILE_LOCATION);
		TransactionFileReader transactionFileReader = new TransactionFileReader(TRANSACTION_DATA_FILE_LOCATION);
		
		customerDataFileReader.importDataIntoService();
		transactionFileReader.importDataIntoService();
		
		SuspicionDetectionService suspicionDetectionService = new SuspicionDetectionService();
		suspicionDetectionService.detectSuspiciousActivity();
		
		SuspiciousActivityReportWriter suspiciousActivityReportWriter = new SuspiciousActivityReportWriter(SUSPICIOUS_ACTIVITY_REPORT_FILE_LOCATION);
		suspiciousActivityReportWriter.generateReport();

	}

}
