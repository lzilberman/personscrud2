package telran.person.service;

import java.util.List;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.person.dao.PersonRepository;
import telran.person.domain.*;
import telran.person.dto.*;

@Service
public class PersonSevice implements IPerson {
	@Autowired
	PersonRepository personRepository;

	@Override
	public void addRandomPersons(RandomDataDto randomData) {
		List<Person> persons = RandomPerson.getRandomPersons(randomData);
		addPersons(persons);
	}
	
	@Override
	public boolean addPerson(Person person) {
		Person saved = personRepository.save(person);
		return saved != null;
	}

	@Override
	public Person getPerson(int id) {
		return personRepository.findById(id).orElse(null);
	}

	@Override
	public void addPersons(Iterable<Person> persons) {
		personRepository.saveAll(persons);
		
	}

	@Override
	public boolean updateAddress(int id, AddressDto address) {
		if (!personRepository.existsById(id)) {
			return false;
		}
		Person person = personRepository.findById(id).get();
		Address newAddress = new Address(address.getCity(), address.getStreet(), address.getBuilding());
		person.setAddress(newAddress);
		personRepository.save(person);
		return true;
	}

	@Override
	public boolean removePerson(int id) {
		if (!personRepository.existsById(id)) {
			return false;
		}
		personRepository.deleteById(id);
		return true;
	}

	@Override
	public Iterable<Person> getAllPersons() {
		return personRepository.findAll();
	}

	@Override
	public Iterable<Person> getPersonByAge(int fromAge, int toAge) {
		LocalDate fromDate = getDateFromAge(toAge);
		LocalDate toDate = getDateFromAge(fromAge);
		return personRepository.findByBirthdateBetween(fromDate, toDate);
	}

	private LocalDate getDateFromAge(int fromAge) {
		return LocalDate.now().minusYears(fromAge);
	}

	@Override
	public Iterable<Person> getPersonByCity(String city) {
//		return personRepository.findAllBy()
//				.filter(p->p.getAddress().getCity().equals(city))
//				.collect(Collectors.toList());
		
        return personRepository.findByAddressCity (city);
	}

	@Override
	public Iterable<Person> getEmployeeBySalary(int fromSalary, int toSalary) {
		return personRepository.findEmployeeBySalaryBetween(fromSalary, toSalary);
	}

}
