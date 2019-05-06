package springapp.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

public class Person {

	private int id;
	
	@NotNull
    @Size(min = 1, message = "Le prénom est obligatoire")
    private String firstName;
	
	@NotNull
    @Size(min = 1, message = "Le nom est obligatoire")
    private String lastName;
    
	@NotNull
    @Email(message = "Adresse mail non valide")
    private String mail;
    
	@NotNull
    @URL(message = "Adresse web non valide")
    private String web;
    
	@NotNull
    private Date BirthDay;
    
	@NotNull
    @Size(min = 8, message = "8 caractères minimum")
    private String password;
    
	@NotNull
	@Min(value = 1, message = "L'id du groupe doit etre plus grand que 1")
    private int groupId;
    
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
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