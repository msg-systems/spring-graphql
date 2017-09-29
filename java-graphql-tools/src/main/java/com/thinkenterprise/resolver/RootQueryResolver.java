package com.thinkenterprise.resolver;

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
		return orgUnitRepository.findAll();
	} 
	

	public OrgUnit getOrgUnit(String id) {
		return orgUnitRepository.get(id);
	}
	
	public List<Person> getPersons() {
		return personRepository.findAll();
	}

}
