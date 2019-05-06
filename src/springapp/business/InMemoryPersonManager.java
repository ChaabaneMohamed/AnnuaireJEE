package springapp.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.stereotype.Service;

import springapp.model.Group;
import springapp.model.Person;

@Service("personManager")
public class InMemoryPersonManager implements IPersonManager {

    final Map<Integer, Group> groups;
    final Map<Integer, Person> persons;
    int maxId = 0;

    public InMemoryPersonManager() {
        this.groups = new HashMap<Integer, Group>();
        this.persons = new HashMap<Integer, Person>();
        Group g1 = new Group(1, "ILD");
        Group g2 = new Group(2, "FSI");
        Group g3 = new Group(3, "GIG");
        Group g4 = new Group(4, "IAAA");
        
        Person p1 = new Person();
        p1.setId(1);
        p1.setFirstName("Mohamed");
        p1.setLastName("CHAABANE");
        p1.setMail("mohamed.chaabane@hotmail.fr");
        p1.setWeb("mohamedchaabane.fr");
        p1.setBirthDay(new Date());
        p1.setPassword("password1");
        p1.setGroupId(1);
        
        Person p2 = new Person();
        p2.setId(2);
        p2.setFirstName("Mohamed");
        p2.setLastName("CHAABANE");
        p2.setMail("mail2");
        p2.setWeb("mohamedchaabane.fr");
        p2.setBirthDay(new Date());
        p2.setPassword("password2");
        p2.setGroupId(1);
        
        Person p3 = new Person();
        p3.setId(3);
        p3.setFirstName("Mohamed");
        p3.setLastName("CHAABANE");
        p3.setMail("mail2");
        p3.setWeb("mohamedchaabane.fr");
        p3.setBirthDay(new Date());
        p3.setPassword("password3");
        p3.setGroupId(2);
        
        Person p4 = new Person();
        p4.setId(4);
        p4.setFirstName("Mohamed");
        p4.setLastName("CHAABANE");
        p4.setMail("mail2");
        p4.setWeb("mohamedchaabane.fr");
        p4.setBirthDay(new Date());
        p4.setPassword("password4");
        p4.setGroupId(2);
        
        persons.put(p1.getId(), p1);
        persons.put(p2.getId(), p2);
        persons.put(p3.getId(), p3);
        persons.put(p4.getId(), p4);
 
        groups.put(g1.getId(), g1);
        groups.put(g2.getId(), g2);
        groups.put(g3.getId(), g3);
        groups.put(g4.getId(), g4);
        
        maxId = 4;
    }

	@Override
	public Collection<Group> findAllGroups() {
		return groups.values();
	}
	
	@Override
	public Collection<Person> findAllPersons() {
		return persons.values();
	}

	@Override
	public Collection<Person> findAllPersonsInGroup(long groupId) {
		List<Person> pers = new ArrayList<Person>();
		for (Person p : persons.values()) {
			if(p.getGroupId() == groupId) {
				pers.add(p);
			}
		}
		return pers;
	}

	@Override
	public Person findPerson(long id) {
		return persons.get((int) id);
	}
	
	@Override
	public Group findGroup(int id) {
		return groups.get(id);
	}

	@Override
	public void savePerson(Person p) {
		if(findPerson(p.getId()) != null) {
			persons.put(p.getId(), p);
		}
	}

	@Override
	public void saveGroup(Group g) {
		if(findGroup(g.getId()) != null) {
			groups.put(g.getId(), g);
		}
	}
}