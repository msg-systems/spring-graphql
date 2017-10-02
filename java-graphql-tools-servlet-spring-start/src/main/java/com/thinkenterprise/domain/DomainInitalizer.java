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
