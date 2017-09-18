/*
 * Copyright (C) 2016 Thinkenterprise
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

import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.annotation.WebServlet;

import graphql.schema.GraphQLSchema;
import graphql.schema.StaticDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.servlet.SimpleGraphQLServlet;


/**
 * GraphQl Servlet which provide the GraphQl Query Language over Http   
 * 
 * A possible call is http://localhost:8080/helloWorld?query={text} 
 * 
 * @author Michael Schäfer 
 * 
 * */


@WebServlet(urlPatterns="/helloWorld")
public class HelloWorldGraphQlServlet extends SimpleGraphQLServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	
	/**
	 * Servlet Standard Constructor which will be called if the servlet loaded first time  
	 * 
	 * 
	 * @author Michael Schäfer 
	 * 
	 * */
	
	public HelloWorldGraphQlServlet() {
		super(buildSchema());
	}

	/**
	 * Build an executable GraphQL Schema for the Servlet 
	 * 
	 * 
	 * @author Michael Schäfer 
	 * 
	 * */
	private static GraphQLSchema buildSchema() {
        
				
		// Big Picture: Build the a GraphQl Schema SDL, IDL  
		// Create a Parser 
		SchemaParser schemaParser = new SchemaParser();
		InputStream inputStream = HelloWorldGraphQlServlet.class.getClassLoader().getResourceAsStream("schema.graphqls");
		InputStreamReader reader = new InputStreamReader(inputStream);
			 
		// Parse the SDL in a java type representation  
		TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(reader);
			
		// Big Picture : Build Schema Resolver and Data Fetcher 
		RuntimeWiring runtimeWiring = newRuntimeWiring().type("Message", builder -> builder.dataFetcher("text", new StaticDataFetcher("Hello World"))).build();
				
		// Bring both together an schema an schema resolver with data fetcher an build an executable qraphql schema  
		SchemaGenerator schemaGenerator = new SchemaGenerator();
		GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
		
		return graphQLSchema;
		
    }
	


}
