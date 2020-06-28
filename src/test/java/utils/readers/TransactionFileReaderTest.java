package utils.readers;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;





public class TransactionFileReaderTest {

	@Test
	public void willThrowFileNotFoundException() {
		String fileLocation  = "C:\\Users\\ULTRON\\Desktop\\Credit_Problem\\com.bank.TrackSuspiciousTransaction\\src\\test\\resources\\Sample_Data.txt";
		TransactionFileReader transactionFileReader = new TransactionFileReader(fileLocation);
		boolean thrown = false;
		try {
			transactionFileReader.importDataIntoService();
		} catch (FileNotFoundException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

}
