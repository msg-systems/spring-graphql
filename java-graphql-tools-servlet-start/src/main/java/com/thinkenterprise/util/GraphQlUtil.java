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
package com.thinkenterprise.util;

import java.util.Map;

import com.coxautodev.graphql.tools.SchemaParser;
import com.thinkenterprise.domain.OrgUnitRepository;
import com.thinkenterprise.domain.PersonRepository;
import com.thinkenterprise.resolver.RootMutationResolver;
import com.thinkenterprise.resolver.RootQueryResolver;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;

public class GraphQlUtil {
	
	
	
	public static void executeGraphQlQuery(GraphQL graphql, String query, boolean response ) {
		
		ExecutionInput executionInput = ExecutionInput.newExecutionInput().query(query).build();
		
		ExecutionResult executionResult = graphql.execute(executionInput);
		
		Map<String,Object> specification = executionResult.toSpecification();

		if(executionResult.getErrors().isEmpty()) {
			System.out.println(executionResult.getData().toString());
			if(response)
				System.out.println(specification.toString());
		}
		else 
			System.out.println(executionResult.getErrors().toString());
		
		
	}
	
	
	public static GraphQLSchema createExecutableSchema() {
		// Create Data Repositories 
		OrgUnitRepository orgUnitRepository = new OrgUnitRepository();
		PersonRepository personRepository = new PersonRepository();
			
			
		// Build an executable GraphQL Schema with GraphQl Tool Parser which support Resolver 
		GraphQLSchema  graphQLSchema = SchemaParser.newParser()
		               .file("schema.graphqls")
			           .resolvers(new RootQueryResolver(orgUnitRepository,personRepository), 
			            		   new RootMutationResolver(orgUnitRepository))
			                .build()
			                .makeExecutableSchema();
		
		return graphQLSchema;
	}

}
