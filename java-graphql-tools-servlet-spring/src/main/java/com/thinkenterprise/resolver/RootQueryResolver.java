package com.thinkenterprise.resolver;

import java.util.ArrayList;
import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.thinkenterprise.domain.OrgUnit;
import com.thinkenterprise.domain.OrgUnitRepository;
import com.thinkenterprise.domain.Person;
import com.thinkenterprise.domain.PersonRepository;

public class RootQueryResolver implements GraphQLQueryResolver {
	
	
	private OrgUnitRepository orgUnitRepository;
	private PersonRepository personRepository;
	
	public RootQueryResolver(OrgUnitRepository orgUnitRepository, 
							 PersonRepository personRepository) {
		
		super();
		this.orgUnitRepository = orgUnitRepository;
		this.personRepository = personRepository;
		
	}


	public List<OrgUnit> getOrgUnits() {
		
		Iterable<OrgUnit> store = orgUnitRepository.findAll();
		
		List<OrgUnit> result = new ArrayList<>();
		
		for (OrgUnit orgUnit : store) {
			result.add(orgUnit);
		}
		
		return result;
	} 
	

	public OrgUnit getOrgUnit(String id) {
		return orgUnitRepository.findByName(id);
	}
	
	public List<Person> getPersons() {
		
		Iterable<Person> store = personRepository.findAll();
		
		List<Person> result = new ArrayList<>();
		
		for (Person person : store) {
			result.add(person);
		}
		
		return result;
	}

}
