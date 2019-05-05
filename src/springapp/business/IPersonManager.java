package springapp.business;

import java.util.Collection;

import springapp.model.Group;
import springapp.model.Person;

public interface IPersonManager {

	// r�cup�rer les groupes
	Collection<Group> findAllGroups();

	// r�cup�rer les personnes
	Collection<Person> findAllPersons(long groupId);

	// lire une personne
	Person findPerson(long id);

	// modification ou ajout d'une nouvelle personne
	void savePerson(Person p);

	// modification ou ajout d'une nouvelle personne
	void saveGroup(Group g);

}