package com.thejavatest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


class StudyTest {
	@Test
	void test() {
		System.out.println("TEST");
	}

	@Test		// 실제 Test
	void createTest() {
		Study study = new Study();
		assertNotNull(study);
		System.out.println("createTest");
	}
	
	@Test		
	@Disabled
	void create1() {
		System.out.println("create1");
	}
	
	// 이 어노테이션은 반드시 static 사용해야함
	@BeforeAll	// 모든 Test가 시작되기 전 실행
	static void beforeAll() {
		System.out.println("Before All");
	}
	
	// 이 어노테이션은 반드시 static 사용해야함
	@AfterAll	// 모든 Test가 끝난 후 실행
	static void afterAll() {
		System.out.println("After All");
	}
	
	@BeforeEach	// 각 Test가 시작되기 전 실행
	void BeforeEach() {
		System.out.println("Before Each");
	}
	
	@AfterEach	// 각 Test가 끝난 후 실행
	void AfterEach() {
		System.out.println("After Each");
	}
}
