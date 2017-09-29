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


public class OrgUnitRepository {
	
	private static Map<String, OrgUnit> store = new HashMap<>();
	

	static {
		
		store.put("msg", new OrgUnit("msg", "msg systems ag"));
		store.put("XT", new OrgUnit("XT",  "msg Applied Technology Research (XT)"));
		store.put("XIS", new OrgUnit("XIS", "msg Information Security (XIS)"));
	}
	
	public List<OrgUnit> findAll() {
		 List<OrgUnit> allOrgUnits = new ArrayList<>();
	     for (OrgUnit orgUnit : store.values()) {
	    	 allOrgUnits.add(orgUnit);
	     }  
	     return allOrgUnits;
	}
	
	
	
	public OrgUnit save(OrgUnit orgUnit) {
		
		return store.put(orgUnit.getId(), orgUnit);
		
	}
	
	
	public OrgUnit get(String id) {
		
		return store.get(id);
	}
    
}