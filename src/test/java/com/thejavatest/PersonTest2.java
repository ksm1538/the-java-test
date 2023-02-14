package com.thejavatest;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)			// 한 클래스내부에서 해당 테스트의 메서드를 모두 처리(각 인스턴스를 생성하지 않고)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)	// 테스트 메서드 순서 결정
public class PersonTest2 {

	static int num = 0;
	@Test
	@DisplayName("2번 테스트")
	@Disabled
	@Order(2)
	void test_2() {
		System.out.println("2번 num : " + num++);
	}
	
	@Test
	@DisplayName("3번 테스트")
	@Order(3)
	void test_3() {
		System.out.println("3번 num : " + num++);
	}
	
	@Test
	@DisplayName("1번 테스트")
	@Order(1)
	void test_1() {
		System.out.println("1번 num : " + num++);
	}
	
}

