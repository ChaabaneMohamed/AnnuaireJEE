package springapp.model;

import java.util.Date;

public class Person {

	private int id;
    private String firstName;
    private String lastName;
    private String mail;
    private String web;
    private Date BirthDay;
    private String password;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public Date getBirthDay() {
		return BirthDay;
	}
	public void setBirthDay(Date birthDay) {
		BirthDay = birthDay;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}