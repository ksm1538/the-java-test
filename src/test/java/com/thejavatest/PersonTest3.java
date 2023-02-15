package com.thejavatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

// @ExtendWith(FindSlowTestExtension.class)
public class PersonTest3 {
	
	// @RegisterExtension을 이용하면, 생성자나 Builder를 이용할 수 있다.
	@RegisterExtension
	static FindSlowTestExtension findSlowTestExtension = new FindSlowTestExtension();
	
	@Test
	@DisplayName("1번테스트")
	void Test_1() {
		System.out.println("1");
	}
	
	@Test
	@DisplayName("2번테스트")
	void Test_2() throws InterruptedException {
		Thread.sleep(3000L);
		System.out.println("2");
	}
}

