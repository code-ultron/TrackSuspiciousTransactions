package dto;







public class CustomerDataRequest {
	
	String AccountNumber;
	String Name;
	String Address;
	String PhoneNumber;
	
	public CustomerDataRequest(String accountNumber, String name, String address, String phoneNumber) {
		super();
		AccountNumber = accountNumber.trim();
		Name = name.trim();
		Address = address.trim();
		PhoneNumber = phoneNumber.trim();
	}

	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getCustomerName() {
		return Name;
	}
	public void setCustomerName(String customerName) {
		Name = customerName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String customerPhoneNumber) {
		PhoneNumber = customerPhoneNumber;
	}
	

	
}
