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

import com.coxautodev.graphql.tools.SchemaParser;
import com.thinkenterprise.domain.OrgUnitRepository;
import com.thinkenterprise.domain.PersonRepository;
import com.thinkenterprise.resolver.RootQueryResolver;
import com.thinkenterprise.resolver.RootMutationResolver;
import com.thinkenterprise.util.GraphQlUtil;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;

public class Application {
	
	
	public static void main(String[] args) {
		
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
		
		
		
		// Finally build the graph GraphQl Engine 
		GraphQL graphQL = GraphQL.newGraphQL(graphQLSchema).build();
		
		
		// Some Samples which shows different queries, mutation and introspection  
		GraphQlUtil.executeGraphQlQuery(graphQL, "query {OrgUnits{name}}", false);
		GraphQlUtil.executeGraphQlQuery(graphQL, "query {OrgUnit(id:\"XT\"){name}}",false);
		GraphQlUtil.executeGraphQlQuery(graphQL, "query {Persons{name}}",false);
		GraphQlUtil.executeGraphQlQuery(graphQL, "query {OrgUnits{name members {name}}}",false);
		GraphQlUtil.executeGraphQlQuery(graphQL, "mutation {create(id:\"foo\", name:\"foo\") {name} }",false);
		GraphQlUtil.executeGraphQlQuery(graphQL, "{__schema { types {name}}}",false);
	
		
		 
	}

}
