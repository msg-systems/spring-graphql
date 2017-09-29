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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonRepository {


	private static Map<String, Person> list = new HashMap<>();
	

	static {
		
		list.put("msg", new Person("HZ", "Hans Zehetmaier","msg"));
		list.put("XT", new Person("RSE",  "Ralf S. Engelschall","XT"));
		list.put("XIS", new Person("MWS", "Mark-W. Schmidt", "XIS"));
		
	}
	
	public List<Person> findAll() {
		
		List<Person> allPersons = new ArrayList<>();
	     for (Person person : list.values()) {
	    	 allPersons.add(person);
	     }  
	     return allPersons;
	    
	}
	
	
	public List<Person> findByOrgUnit(OrgUnit orgUnit) {
		
		
		List<Person> allPersons = new ArrayList<>();
	     for (Person person : list.values()) {
	    	 if(person.getbelongsTo().equals(orgUnit.getId()))
	    		 allPersons.add(person);
	     }  
	     return allPersons;
		
	}
	
    
}
