package telran.person.dto;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import telran.person.domain.*;

public class RandomPerson {
	
	private static int getRandom(int min, int max){
	    return  (int) ( (Math.random()*((max-min)+1))+min); 
	}
    private static LocalDate getRandomBirthdate(RandomDataDto randomData, boolean isEmployee) {
		int year = isEmployee? getRandom(RandomDataDto.MIN_EMPL_YEAR, RandomDataDto.MAX_EMPL_YEAR):
			                   getRandom(RandomDataDto.MIN_CHILD_YEAR, RandomDataDto.MAX_CHILD_YEAR);
		int month = getRandom(1, 12);
		int monthLength = LocalDate.of(year, month, 1).lengthOfMonth();
		int day = getRandom(1, monthLength);
		return LocalDate.of(year, month, day);
	} 
    private static Address getRandomAddress(RandomDataDto randomData) {
    	String city = "city" + getRandom(1, randomData.n_cities); 
    	String street = "street" + getRandom(1, randomData.n_streets); 
    	int building = getRandom(1, randomData.n_buildings); 
		return new Address(city, street, building);
	} 
    private static Employee getRandomEmployee(RandomDataDto randomData, int id) {
		String name = "name" + getRandom(1, randomData.n_names);
		LocalDate birthdate = getRandomBirthdate(randomData, true);
		Address address = getRandomAddress(randomData);
		String company = "company" + getRandom(1, randomData.n_companies); 
		int salary = getRandom(randomData.min_salary, randomData.max_salary);
		
		return new Employee(id, name, birthdate, address, company, salary);
	}
    private static Child getRandomChild(RandomDataDto randomData, int id) {
		String name = "name" + getRandom(1, randomData.n_names);
		LocalDate birthdate = getRandomBirthdate(randomData, true);
		Address address = getRandomAddress(randomData);
		String garten = "garten" + getRandom(1, randomData.n_gartens);
		
		return new Child(id, name, birthdate, address, garten);
	}
    public static List<Person> getRandomPersons(RandomDataDto randomData){
    	List<Person> persons = new LinkedList<Person>();
		int n_employees = (int)randomData.n_persons * randomData.percent_empl/100;
		int n_childs = randomData.n_persons - n_employees;
		int sequence = randomData.min_id;
		
		for(int i=0; i<n_employees; i++) {
			persons.add(getRandomEmployee(randomData, sequence++));
		}
		for(int i=0; i<n_childs; i++) {
			persons.add(getRandomChild(randomData, sequence++));
		}
		return persons;
    }

}
