package com.mysite.yougether.question;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.yougether.DataNotFountException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {

	private final QuestionRepository qr;
	
	public List<Question> getList(){
		return this.qr.findAll();
	}
	
	public Question getQuestion(Integer id) {
		Optional<Question> question = this.qr.findById(id);
		if(question.isPresent()) {
			return question.get();
		}else {
			throw new DataNotFountException("question not found");
		}
		
	}
}
