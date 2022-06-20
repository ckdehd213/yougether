package com.mysite.yougether;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class YougetherApplicationTests {

	@Autowired
	private QuestionRepository qr; 
	
	@Autowired
	private AnswerRepository ar;
	
	/*@Test  //질문 데이터삽입 테스트
	void testJpa() {
		Question q1=new Question();
		q1.setSubject("yougether가 무엇인가요?");
		q1.setContent("yougether에 대해서 알고싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.qr.save(q1); // 첫번쨰 질문 저장
		
		Question q2=new Question();
		q2.setSubject("스프링부트 모델 질문입니다.");
		q2.setContent("id는 자동으로 생성되나요?");
		q2.setCreateDate(LocalDateTime.now());
		this.qr.save(q2); // 두번째 질문 저장
	}
	*/
	/*
	@Test	//삽입된 데이터 확인 테스트
	void testJpa() {
		List<Question> all = this.qr.findAll();
		assertEquals(2, all.size());
		
		Question q = all.get(0);
		assertEquals("yougether가 무엇인가요?", q.getSubject());
	}
	*/
	/*
	@Test	//Question의 id값으로 데이터 확인
	void testJpa() {
	Optional<Question> oq = this.qr.findById(1);
	if(oq.isPresent()) {
		Question q = oq.get();
		assertEquals("yougether가 무엇인가요?", q.getSubject());
	}
	}
	*/
	/*
	@Test	//Question의 subject값으로 데이터 확인(QuestionRepository 인터페이스에 작업후)
	void testJpa() {
		Question q = this.qr.findBySubject("yougether가 무엇인가요?");
		assertEquals(1, q.getId());
	}
	*/
	/*
	@Test	//Question의 제목과 내용같이  데이터 확인(QuestionRepository 인터페이스에 작업후)
	void testJpa() {
		Question q = this.qr.findBySubjectAndContent("yougether가 무엇인가요?", "yougether에 대해서 알고싶습니다.");
		assertEquals(1, q.getId());
	}
	*/
	/*
	@Test	//Question의 특정 문자열 데이터 확인(QuestionRepository 인터페이스에 작업후)
	void testJpa() {
		List<Question> qList = this.qr.findBySubjectLike("yougether%");
		Question q = qList.get(0);
		assertEquals("yougether가 무엇인가요?", q.getSubject());
	}
	*/
	/*
	@Test	// 데이터수정
	void testJpa() {
		Optional<Question> oq = this.qr.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		q.setSubject("yougether 수정된 제목");
		this.qr.save(q);	
	}
	*/
	/*
	@Test	// 데이터삭제
	void testJpa() {
		 assertEquals(2, this.qr.count());
	        Optional<Question> oq = this.qr.findById(1);
	        assertTrue(oq.isPresent());
	        Question q = oq.get();
	        this.qr.delete(q);
	        assertEquals(1, this.qr.count());
	}
	*/
	/*
	@Test	// 답변데이터 생성 후 저장
	void testJpa() {
		Optional<Question> oq = this.qr.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		
		Answer a=new Answer();
		a.setContent("네 자동으로 생성됩니다.");
		a.setQuestion(q);
		a.setCreateDate(LocalDateTime.now());
		this.ar.save(a);
	}
	*/
	/*
	@Test	// 답변데이터 확인
	void testJpa() {
		Optional<Answer> oa = this.ar.findById(1);
        assertTrue(oa.isPresent());
        Answer a = oa.get();
        assertEquals(2, a.getQuestion().getId());
	}
	*/
	@Transactional
	@Test	// 질문에서 답변 찾기
	void testJpa() {
		Optional<Question> oq = this.qr.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();

        assertEquals(1, answerList.size());
        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
	}
	
}
