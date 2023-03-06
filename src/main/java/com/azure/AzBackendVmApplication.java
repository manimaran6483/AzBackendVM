package com.azure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AzBackendVmApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzBackendVmApplication.class, args);
	}

	@Bean
	public Connection getConnection() {

		try {
			// build connection properties
			Properties properties = new Properties();
			properties.put("user", "VS00389"); // replace "" with your user name
			properties.put("password", "Ring_123!@#"); // replace "" with your password
			properties.put("warehouse", "COMPUTE_WH"); // replace "" with target warehouse name
			properties.put("db", "SNOWFLAKEDEMO"); // replace "" with target database name
			properties.put("schema", "SNOWFLAKESCHEMA"); // replace "" with target schema name

			String connectStr = "jdbc:snowflake://wp91410.east-us-2.azure.snowflakecomputing.com";
			return DriverManager.getConnection(connectStr, properties);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
