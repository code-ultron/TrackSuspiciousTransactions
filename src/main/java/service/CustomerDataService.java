package service;

import java.util.ArrayList;
import java.util.List;

import dto.CustomerDataRequest;
import interfaces.DataService;





public class CustomerDataService implements DataService<CustomerDataRequest> {
	
	private static List<CustomerDataRequest> customerData = new ArrayList<CustomerDataRequest>();
	
	public List<CustomerDataRequest> getCustomersData() {
		return customerData;
	}
	
	public CustomerDataRequest getCustomerDataByAccountNumber(String accountNumber) {
		for (CustomerDataRequest customer : customerData) {
			if(customer.getAccountNumber().equals(accountNumber)) {
				return customer;
			}
		}
		return null;
	}
	
	public String getPhoneNumberByAccountNumber(String accountNumber) {
		for (CustomerDataRequest customer : customerData) {
			if(customer.getAccountNumber().equals(accountNumber)) {
				return customer.getPhoneNumber();
			}
		}
		return null;
	}
	
	public String getAddressByAccountNumber(String accountNumber) {
		for (CustomerDataRequest customer : customerData) {
			if(customer.getAccountNumber().equals(accountNumber)) {
				return customer.getAddress();
			}
		}
		return null;
	}

	public void addSingleRecord(CustomerDataRequest record) {
		customerData.add(record);
	}

	public void addBulkRecords(List<CustomerDataRequest> records) {
		for (CustomerDataRequest customerDataRequest : records) {
			customerData.add(customerDataRequest);
		}
	}
}
