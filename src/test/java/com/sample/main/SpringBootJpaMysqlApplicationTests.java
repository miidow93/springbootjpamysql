package com.sample.main;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.sample.repository.BookRepository;


@RunWith(SpringRunner.class)
@ComponentScan("com.sample.*")
@SpringBootTest
public class SpringBootJpaMysqlApplicationTests {

	@Autowired
	BookRepository bookRepo;
	
	@Before
	public void Test() {
		long count = bookRepo.count();
		System.out.println(count);
	}
	
	@Test
	public void contextLoads() {
	}

}

