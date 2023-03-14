
public class Customer {
	private String firstName;
	private String lastName;
	private String SNN;
	
	public Customer(String firstName, String lastName, String sNN) {
		this.firstName = firstName;
		this.lastName = lastName;
		SNN = sNN;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSNN() {
		return SNN;
	}

	@Override
	public String toString() {
		return " : " + firstName + " : " + lastName + " : " + SNN;
	}
	
	
	
}
