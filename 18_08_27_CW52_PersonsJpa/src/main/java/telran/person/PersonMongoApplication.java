package telran.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import telran.person.service.IPerson;


@SpringBootApplication
public class PersonMongoApplication { 
	@Autowired
	IPerson personService;

	public static void main(String[] args) {
		SpringApplication.run(PersonMongoApplication.class, args);
	}
	
}
