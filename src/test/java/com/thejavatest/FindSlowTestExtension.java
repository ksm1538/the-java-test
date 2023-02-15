package com.thejavatest;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Store;

public class FindSlowTestExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback{

	private static final long LIMIT = 2000L; 		// 2초
	
	// store : 간단하게 데이터를 저장하는 공간(인터페이스)
	
	@Override
	public void beforeTestExecution(ExtensionContext context) throws Exception {		// 각 테스트 시작 전에 호출되는 함수
		String testClassName = context.getRequiredTestClass().getName();		// 클래스 이름
		String testMethodName = context.getRequiredTestMethod().getName();		// 메서드 이름
		
		// 클래스 이름과 메서드 이름으로 Store를 가져온 다음
		Store store = context.getStore(ExtensionContext.Namespace.create(testClassName, testMethodName));
		
		// 해당 store에 시작시각을 넣어준다.
		store.put("START_TIME", System.currentTimeMillis());
	}
	
	@Override
	public void afterTestExecution(ExtensionContext context) throws Exception {			// 각 테스트 완료 후에 호출되는 함수
		String testClassName = context.getRequiredTestClass().getName();
		String testMethodName = context.getRequiredTestMethod().getName();
		
		Store store = context.getStore(ExtensionContext.Namespace.create(testClassName, testMethodName));
		
		// store에서 시작 시각을 가져오고 그 데이터는 삭제.
		long startTime = store.remove("START_TIME", long.class);
		// 현재 시각 - 시작 시각
		long duration = System.currentTimeMillis() - startTime;
		
		if(duration > LIMIT) {
			System.out.println("Find Slow Method : " + testMethodName);
		}
	}

	
	
}
