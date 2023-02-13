package com.thejavatest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

// 클래스 안에 있는 모든 @Test에 대해 일괄적으로 적용. (아래는 언더바를 공백으로 치환하는 규칙)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {
	@Test
	@DisplayName("테스트")		// 해당 테스트의 이름을 변경
	@Tag("태그")
	void test() {
		System.out.println("TEST");
	}

	@Test		
	@customTag
	void create_test() {
		Study study = new Study();
		assertNotNull(study);
		System.out.println("createTest");
	}
	
	@RepeatedTest(value = 5, name ="{displayName}, {currentRepetition} of {totalRepetitions}")
	@DisplayName("반복 테스트")
	void repeat_test() {
		System.out.println("create1");
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"1번", "2번", "3번"})
	@DisplayName("파라미터 반복 테스트")
	void repeat_param_test(String s) {
		System.out.println(s);
	}
	
	@ParameterizedTest
	@CsvSource({"1, '1번'", "1, '2번'"})
	@DisplayName("파라미터 반복 테스트_csv")
	void repeat_param_test2(String s) {
		System.out.println(s);
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
