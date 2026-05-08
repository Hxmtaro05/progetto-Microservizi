package com.corso.macchina;

import org.springframework.boot.SpringApplication;

public class TestMacchinaApplication {

	public static void main(String[] args) {
		SpringApplication.from(MacchinaApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
