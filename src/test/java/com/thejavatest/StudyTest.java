package com.thejavatest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

// 클래스 안에 있는 모든 @Test에 대해 일괄적으로 적용. (아래는 언더바를 공백으로 치환하는 규칙)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {
	@Test
	@DisplayName("테스트")		// 해당 테스트의 이름을 변경
	void test() {
		System.out.println("TEST");
	}

	@Test		// 실제 Test
	void create_test() {
		Study study = new Study();
		assertNotNull(study);
		System.out.println("createTest");
	}
	
	@Test		
	void create_11() {
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
