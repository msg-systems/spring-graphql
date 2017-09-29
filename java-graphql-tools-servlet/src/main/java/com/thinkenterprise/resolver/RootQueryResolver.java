/*
 * Copyright (C) 2017 Thinkenterprise
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 *
 * @author Michael Schaefer
 */
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
