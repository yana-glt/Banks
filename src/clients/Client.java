package clients;

import java.util.Objects;

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return this.id == other.id && Objects.equals(this.IdentificationNumber, other.IdentificationNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, IdentificationNumber);
	}

	@Override
	public String toString() {
		return "General information about the client: id=" + id + ", IdentificationNumber=" + IdentificationNumber
				+ ", phoneNumber=" + phoneNumber + ", address=" + address + ".";
	}

}
