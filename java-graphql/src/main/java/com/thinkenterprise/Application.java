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

import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import com.thinkenterprise.domain.OrgUnitRepository;
import com.thinkenterprise.domain.PersonRepository;
import com.thinkenterprise.domain.mutation.OrgUnitMutationDataFetcher;
import com.thinkenterprise.domain.query.OrgUnitQuery;
import com.thinkenterprise.domain.query.OrgUnitByIdQuery;
import com.thinkenterprise.domain.query.OrgUnitPersonQuery;
import com.thinkenterprise.domain.query.PersonQuery;
import com.thinkenterprise.util.GraphQlUtil;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLSchema;
import graphql.schema.StaticDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

public class Application {
	
	
	public static void main(String[] args) {
		
		
		// Create Data Repositories 
		OrgUnitRepository orgUnitRepository = new OrgUnitRepository();
		PersonRepository personRepository = new PersonRepository();
		
		// Read Schema from Classpath 
		InputStream inputStream = Application.class.getClassLoader().getResourceAsStream("schema.graphqls");
		InputStreamReader reader = new InputStreamReader(inputStream);
		
				
		//  Build the a GraphQl Schema  
		// Create a Parser 
		SchemaParser schemaParser = new SchemaParser();
						
				
		// Parse the Schema in a java type representation  
		TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(reader);
		
		
		//  Build Schema Resolver and Data Fetcher 
		RuntimeWiring runtimeWiring = newRuntimeWiring().type("Root", builder -> builder.dataFetcher("OrgUnits", new OrgUnitQuery(orgUnitRepository)))
														.type("Root", builder -> builder.dataFetcher("Persons", new PersonQuery(personRepository)))
														.type("OrgUnit", builder -> builder.dataFetcher("members", new OrgUnitPersonQuery(personRepository)))
														.type("OrgUnit", builder -> builder.dataFetcher("create", new OrgUnitMutationDataFetcher(orgUnitRepository)))
														.type("Root", builder -> builder.dataFetcher("OrgUnit", new OrgUnitByIdQuery(orgUnitRepository))).build();
		
		// Bring both together an schema resolver with data fetcher an build an executable GraphQl schema  
		SchemaGenerator schemaGenerator = new SchemaGenerator();
		GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
		
		// Finally build the graph GraphQl Engine 
		GraphQL graphQL = GraphQL.newGraphQL(graphQLSchema).build();
		
		// Some Samples which shows different queries, mutation and introspection  
		GraphQlUtil.executeGraphQlQuery(graphQL, "query {OrgUnits{name}}", true);
		GraphQlUtil.executeGraphQlQuery(graphQL, "query {OrgUnit(id:\"XT\"){name}}",false);
		GraphQlUtil.executeGraphQlQuery(graphQL, "query {OrgUnits{name members {name}}}",false);
		GraphQlUtil.executeGraphQlQuery(graphQL, "query {Persons{name}}",false);
		GraphQlUtil.executeGraphQlQuery(graphQL, "mutation {OrgUnits{create(id:\"foo\", name:\"foo\") {name} }}",false);
		GraphQlUtil.executeGraphQlQuery(graphQL, "{__schema { types {name}}}",false);
		
				
	}
	
	
}
