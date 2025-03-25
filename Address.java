public class Address{

	String number;
	String street;
	String city;
	String state;
	int zip;
	
	public Address(String numberIn, String streetIn, String cityIn, String stateIn, int zipIn){
		number = numberIn;
		street = streetIn; // modified to actually update
		// cityIn = city; // bug: assigned parameter to class value instead of vice versa
		city = cityIn; // corrected
		state = stateIn;
		zip = zipIn;
	}

	public String toString(){
		// return "\n\t" + number + " " + street + "\n\t" + this.city + ", " + " " + zip;
		// has a "this" notation only for the city (?), and doesn't output the state
		return "\n\t" + number + " " + street + "\n\t" + city + ", " + state + " " + zip;
	}
}