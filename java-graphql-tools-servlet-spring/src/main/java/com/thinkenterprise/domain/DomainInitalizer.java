package com.thinkenterprise.domain;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DomainInitalizer {

	@Autowired
	private OrgUnitRepository orgUnitRepository;
	
	
	
	@PostConstruct
	public void initalize() {
		
		
		OrgUnit orgUnit = new OrgUnit("msg", "msg systems ag");
		orgUnit.addPerson(new Person("HZ", "Hans Zehetmaier"));	
		orgUnitRepository.save(orgUnit);
		
		orgUnit = new OrgUnit("XT",  "msg Applied Technology Research (XT)");
		orgUnit.addPerson(new Person("RSE",  "Ralf S. Engelschall"));			
		orgUnitRepository.save(orgUnit);			
		
		orgUnit = new OrgUnit("XIS", "msg Information Security (XIS)");
		orgUnit.addPerson(new Person("MWS", "Mark-W. Schmidt"));	
		orgUnitRepository.save(orgUnit);
		
	}
	
	
	
}
