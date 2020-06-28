package utils.readers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dto.CustomerDataRequest;
import interfaces.FileReader;
import service.CustomerDataService;





public class CustomerDataFileReader implements FileReader {
	
	private String fileLocation;
	
	public CustomerDataFileReader(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public void importDataIntoService() throws FileNotFoundException {
		CustomerDataService customerDataService = new CustomerDataService();
		File fileObject = new File(fileLocation);
		Scanner lineReader = null;
		try {
			lineReader = new Scanner(fileObject);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new FileNotFoundException();
		}
		lineReader.nextLine();
		while(lineReader.hasNextLine()) {
			
			String[] recordData = lineReader.nextLine().split("\\|");
			CustomerDataRequest customerDataRequest = new CustomerDataRequest(recordData[0],recordData[1],recordData[2],recordData[3]);
			
			customerDataService.addSingleRecord(customerDataRequest);
			
		}
		lineReader.close();
	}
}
