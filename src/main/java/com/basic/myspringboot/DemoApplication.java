package com.basic.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		/*SpringApplication application = new SpringApplication(DemoApplication.class);
		application.addListeners(new SampleListener());
		application.run(args);*/
		SpringApplication.run(DemoApplication.class, args);
	}

}
