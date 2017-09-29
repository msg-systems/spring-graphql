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


package com.thinkenterprise.domain.mutation;

import com.thinkenterprise.domain.OrgUnit;
import com.thinkenterprise.domain.OrgUnitRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

public class OrgUnitMutationDataFetcher implements DataFetcher<OrgUnit> {

	
	private OrgUnitRepository orgUnitRepository;
	
	
	public OrgUnitMutationDataFetcher(OrgUnitRepository orgUnitRepository) {
		super();
		this.orgUnitRepository = orgUnitRepository;
	}


	@Override
	public OrgUnit get(DataFetchingEnvironment environment) {
		
		OrgUnit orgUnit = new OrgUnit(environment.getArgument("id"), environment.getArgument("name"));
		
		return orgUnitRepository.save(orgUnit);
	}


		
	
}
