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


package com.thinkenterprise.domain.query;

import java.util.List;

import com.thinkenterprise.domain.OrgUnit;
import com.thinkenterprise.domain.OrgUnitRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

public class OrgUnitQuery implements DataFetcher<List<OrgUnit>> {

	
	private OrgUnitRepository orgUnitRepository;
	
	
	public OrgUnitQuery(OrgUnitRepository orgUnitRepository) {
		super();
		this.orgUnitRepository = orgUnitRepository;
	}


	@Override
	public List<OrgUnit> get(DataFetchingEnvironment environment) {
		return null;
	}


		
	
}
