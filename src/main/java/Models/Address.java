package Models;

public class Address extends Hotel {
private String addresses;
private String city;
private String number;
private String email;
private int hid;
public int getHid() {
	return hid;
}
public void setHid(int hid) {
	this.hid = hid;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddresses() {
	return addresses;
}
public void setAddresses(String addresses) {
	this.addresses = addresses;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}

}
