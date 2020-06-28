package utils.readers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dto.TransactionDataRequest;
import interfaces.FileReader;
import service.TransactionService;

public class TransactionFileReader implements FileReader {
	
	private String fileLocation;
	
	public TransactionFileReader(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public void importDataIntoService() throws FileNotFoundException {
		TransactionService transactionService = new TransactionService();
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
			TransactionDataRequest transactionDataRequest = new TransactionDataRequest(recordData[0],recordData[1],recordData[2],recordData[3],recordData[4]);
			transactionService.addSingleRecord(transactionDataRequest);
		}
		lineReader.close();
	}
}
		     
	