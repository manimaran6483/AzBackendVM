package com.azure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class Controller {

	@Autowired
	Connection connection;
	
	@GetMapping("/hello")
	public ResponseEntity<String> getReqeust() {
		
		return new ResponseEntity<String>("Hello World", HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<Response> getAllRecords(){
		ResultSet resultSet = null;
		List<Employee> responseList = new ArrayList<>();
		Response res = new Response();
		try {
			// get connection
		    System.out.println("Create JDBC connection");
		    System.out.println("Done creating JDBC connection\n");

		    // create statement
		    System.out.println("Create JDBC statement");
		    Statement statement = connection.createStatement();
		    System.out.println("Done creating JDBC statement\n");
			
			// query the data
		    System.out.println("Query demo");
		    resultSet = statement.executeQuery("ALTER SESSION SET JDBC_QUERY_RESULT_FORMAT='JSON'");
		    resultSet = statement.executeQuery("select * from EMPLOYEE");
		    System.out.println("Metadata:");
		    System.out.println("================================");


		    // fetch data
		    System.out.println("\nData:");
		    System.out.println("================================");
		    while (resultSet.next()) {
		      Employee emp = new Employee();
		      emp.setAge(resultSet.getInt(2));
		      emp.setName(resultSet.getString(1));
		      emp.setQualification(resultSet.getString(3));
		      responseList.add(emp);
		    }
		    resultSet.close();
		    statement.close();
		    
		}catch(Exception e) {
			System.out.println(e);
		}
		res.setResult(responseList);
		return new ResponseEntity<Response>(res, HttpStatus.OK);
	}
	
	
}
