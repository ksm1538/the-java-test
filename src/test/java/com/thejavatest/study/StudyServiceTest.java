package com.thejavatest.study;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.thejavatest.domain.Member;
import com.thejavatest.member.MemberService;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {
	/*
	// 1. Mockito.mock 사용 (@Mock 어노테이션 없이도 가능)
	
	MemberService memberService = mock(MemberService.class);
	StudyRepository studyRepository = mock(StudyRepository.class);
	
	*/
	
	@Mock MemberService memberService;
	@Mock StudyRepository studyRepository;
	
	@Test
	void createStudyService() {
		StudyService studyService = new StudyService(memberService, studyRepository);
		
		Member member = new Member();
		member.setId(1L);
		member.setEmail("test@email.com");
		
		// 1이라는 ID로 findById를 하라고 했을 때, member 변수로 리턴해라.
		when(memberService.findById(1L)).thenReturn(Optional.of(member));
		
		// any()를 사용하면 특정 파라미터가 아닌 모든 파라미터에 대해 적용된다.
		//when(memberService.findById(any())).thenReturn(Optional.of(member));
		
		
		Optional<Member> optional = memberService.findById(1L);
		
		// memberService의 validate라는 메서드를 1L 파라미터로 호출했을 때 IllegalArgumentException 을 호출하도록 설정
		doThrow(new IllegalArgumentException()).when(memberService).validate(1L);

		
	}
	
}
