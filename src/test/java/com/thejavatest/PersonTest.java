package com.thejavatest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.time.Duration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

class PersonTest {

	@Test
	@EnabledOnJre(JRE.JAVA_8)		// 두 개 이상을 넣는 경우 배열 형태로 넣어주면 됨
	@EnabledOnOs(OS.WINDOWS)
	@DisplayName("JDK, OS 테스트")
	void test_1() {
		int n = 8;
		
		assertThat(n > 0);
	}
	
	@Test
	@DisplayName("assumeTrue 테스트")
	void assumeTrueTest() {
		int n = 8;
		
		assumeTrue(7 == n);
		assertThat(n > 0);
	}
	
	@Test
	@DisplayName("age 테스트")
	void test() {
		Person person = new Person();
		
		int age = 28;
		person.setAge(age);
		assertEquals(age, person.getAge(), "Person 객체의 Age는 " + age + "이어야 한다.");	
	}
	
	@Test
	@DisplayName("제한시간 테스트")
	void timeTest() {
		assertTimeout(Duration.ofMillis(100), () -> {
			Person person = new Person();
			Thread.sleep(500);
		});
	}
	
	@Test
	@DisplayName("다중 테스트")
	void manyTest() {
		int n = 1;
		assertAll(
			()->assertEquals(n, 1),
			()->assertNull(n),
			()->assertNotNull(n)
		);
	}
	
	
	
	

}
