package com.example.testDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.testDemo.controller.RestAppController;

@SpringBootApplication
public class TestDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TestDemoApplication.class, args);
		RestAppController controller = context.getBean(RestAppController.class);
		controller.onlyOnceExecuteToInsert();
	}

}
