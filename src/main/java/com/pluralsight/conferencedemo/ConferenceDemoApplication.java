package com.pluralsight.conferencedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class ConferenceDemoApplication {

	public static void main(String[] args) {
		/*Map<String, String> env = System.getenv();
		for (String envName : env.keySet()) {
			System.out.format("%s=%s%n",
					envName,
					env.get(envName));
		}
		String dburl = System.getProperty("BD_URL") ;
		System.out.println("Username using system property: "  + dburl);
		for (String env: args) {
            String value = System.getenv(env);
            if (value != null) {
                System.out.format("%s=%s%n",
                                  env, value);
            } else {
                System.out.format("%s is"
                    + " not assigned.%n", env);
            }
		*/

		SpringApplication.run(ConferenceDemoApplication.class, args);
	}
}
