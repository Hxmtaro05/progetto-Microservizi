package com.corso.macchina;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class MacchinaApplicationTests {

	@Test
	void contextLoads() {
	}

}
