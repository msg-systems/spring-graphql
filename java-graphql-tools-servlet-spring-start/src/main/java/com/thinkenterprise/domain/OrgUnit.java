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
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class OrgUnit  {
	
	@Id
	@GeneratedValue
	private Long artificialKey;

	private String id;
	private  String name;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Person> members = new ArrayList<>();
	
		
	public OrgUnit() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OrgUnit(String id, String name) {
		super();
		this.id = id;
		this.name = name;	
	}
	
	
	public List<Person> getMembers() {
		return members;
	}


	public void setMembers(List<Person> members) {
		this.members = members;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}



	
	
	public String getName() {
		return name;
	}
	

	public String getId() {
		return id;
	}
	

	public Long getArtificialKey() {
		return artificialKey;
	}


	public void setArtificialKey(Long artificialKey) {
		this.artificialKey = artificialKey;
	}
	
	public void addPerson(Person person) {
		members.add(person);
	}

	@Override
	public String toString() {
		return "id: " + this.id + "name: " + this.name;
	}
	

}
