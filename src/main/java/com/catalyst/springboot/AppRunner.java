package main.java.com.catalyst.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ZooKeepr is a proof of concept application that keeps track animals and animal 
 * enclosures. The application is meant to be a single user application without login, 
 * registration, or security. 
 * @author gwalpole
 */
@SpringBootApplication
public class AppRunner {

	/**
	 * Runs the program
	 */
	public static void main(String[] args) {
		SpringApplication.run(AppRunner.class);
	}

}
