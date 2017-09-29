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



package com.thinkenterprise;

import java.io.InputStream;
import java.io.InputStreamReader;

import com.thinkenterprise.domain.OrgUnitRepository;
import com.thinkenterprise.domain.PersonRepository;

public class Application {
	
	
	public static void main(String[] args) {
		
		
		// Create Data Repositories 
		OrgUnitRepository orgUnitRepository = new OrgUnitRepository();
		PersonRepository personRepository = new PersonRepository();
		
		// Read Schema from Classpath 
		InputStream inputStream = Application.class.getClassLoader().getResourceAsStream("schema.graphqls");
		InputStreamReader reader = new InputStreamReader(inputStream);
		
				
		
		
				
	}
	
	
}
