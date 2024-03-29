package telran.person.service;

import telran.person.domain.Person;
import telran.person.dto.AddressDto;
import telran.person.dto.RandomDataDto;

public interface IPerson {
	
//	void addPerson(Person person);
	boolean addPerson(Person person);
	
	void addPersons(Iterable<Person> persons);
	
	Person getPerson(int id);
	
	boolean updateAddress(int id, AddressDto address);
	
	boolean removePerson(int id);
	
	Iterable<Person> getAllPersons();
	
	Iterable<Person> getPersonByAge(int fromAge, int toAge);
	
	Iterable<Person> getPersonByCity(String city);
	
	Iterable<Person> getEmployeeBySalary(int fromSalary, int toSalary);

	void addRandomPersons(RandomDataDto randomData);
}
