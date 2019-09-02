package telran.person.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RandomDataDto {
	
	public static final int MIN_EMPL_YEAR=1951;
	public static final int MAX_EMPL_YEAR=2000;
	
	public static final int MIN_CHILD_YEAR=2013;
	public static final int MAX_CHILD_YEAR=2018;
	
	public Integer n_persons;   // number of the created persons 
	public Integer n_names;     // number of the person names: name1, name2...
	public Integer n_cities;    // number of the cities: city1, city2...
	public Integer n_streets;   // number of the streets: street1, street2...
	public Integer n_buildings; // number of the buildings: 1, 2... 
	public Integer min_id;      // minimal id number (each new person's id equals previous id +1)
	public Integer min_salary;  // minimal salary value
	public Integer max_salary;  // maximal salary value
	public Integer percent_empl;// approximate percent of the employees from all n_persons
	public Integer n_gartens;   // number of the kindergartens: garten1, garten2...
	public Integer n_companies; // number of the companies: company1, company2...
	
}
