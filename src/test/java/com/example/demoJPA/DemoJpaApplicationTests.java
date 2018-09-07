package com.example.demoJPA;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demoJPA.service.CocheService;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class DemoJpaApplicationTests {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CocheService cocheService;

	@Test
	public void contextLoads() {

	}

}
