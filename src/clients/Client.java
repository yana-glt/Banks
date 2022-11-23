package clients;

abstract class Client {
	private long id;
	private String IdentificationNumber;
	private String phoneNumber;
	private String address;

	public Client() {

	}

	public Client(long id, String identificationNumber, String phoneNumber, String address) {
		this.id = id;
		this.IdentificationNumber = identificationNumber;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdentificationNumber() {
		return IdentificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		IdentificationNumber = identificationNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
