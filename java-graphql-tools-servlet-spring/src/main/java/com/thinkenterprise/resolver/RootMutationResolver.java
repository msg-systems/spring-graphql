package com.thinkenterprise.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.thinkenterprise.domain.OrgUnit;
import com.thinkenterprise.domain.OrgUnitRepository;

public class RootMutationResolver implements GraphQLMutationResolver {
	
	
	private OrgUnitRepository orgUnitRepository;
	
	
	public RootMutationResolver(OrgUnitRepository orgUnitRepository) {
		super();
		this.orgUnitRepository = orgUnitRepository;	
	}
	
	public OrgUnit create(String id, String name) {
		OrgUnit orgUnit = orgUnitRepository.save(new OrgUnit(id, name));
		return  orgUnit;
	}

}
