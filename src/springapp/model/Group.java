package springapp.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Group {
	
	private int id;
	private String name;
	private Map<Integer, Person> persons;
	
	public Group(int id, String name) {
		persons = new HashMap<Integer, Person>();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<Integer, Person> getPersons() {
		return persons;
	}
	public void setPersons(Map<Integer, Person> persons) {
		this.persons = persons;
	}
	public Collection<Person> getPersonsValue(){
		return persons.values();
	}
}
