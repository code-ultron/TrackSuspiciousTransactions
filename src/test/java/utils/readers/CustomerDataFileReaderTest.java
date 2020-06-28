package utils.readers;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;




public class CustomerDataFileReaderTest {

	@Test
	public void willThrowFileNotFoundExceptionTest() {
		String fileLocation  = "C:\\Users\\ULTRON\\Desktop\\Credit_Problem\\com.bank.TrackSuspiciousTransaction\\src\\test\\resources\\customerData\\Sample_Data.txt";
		CustomerDataFileReader customerDataFileReader = new CustomerDataFileReader(fileLocation);
		boolean thrown = false;
		try {
			customerDataFileReader.importDataIntoService();
		} catch (FileNotFoundException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
}
