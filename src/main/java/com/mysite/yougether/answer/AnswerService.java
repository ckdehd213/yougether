package com.mysite.yougether.answer;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.mysite.yougether.question.Question;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerService {

	private final AnswerRepository ar;
	
	public void create(Question question, String content) {
		Answer answer=new Answer();
		answer.setContent(content);
		answer.setCreateDate(LocalDateTime.now());
		answer.setQuestion(question);
		this.ar.save(answer);
	}
}
