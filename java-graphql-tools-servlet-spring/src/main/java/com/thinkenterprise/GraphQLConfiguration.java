package com.thinkenterprise;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.thinkenterprise.domain.OrgUnitRepository;
import com.thinkenterprise.domain.PersonRepository;
import com.thinkenterprise.resolver.RootMutationResolver;
import com.thinkenterprise.resolver.RootQueryResolver;

@Configuration
public class GraphQLConfiguration {
	
	@Bean
	public RootQueryResolver rootQueryResolver(OrgUnitRepository orgUnitRepository, PersonRepository personRepository) {
		
		return new RootQueryResolver(orgUnitRepository,personRepository);
		
		
	}
	
	@Bean
	public RootMutationResolver rootMutationResolver(OrgUnitRepository orgUnitRepository) {
		
		return new RootMutationResolver(orgUnitRepository);
		
	}
	
	
	
	
	

}
