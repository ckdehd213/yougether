package com.mysite.yougether.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mysite.yougether.DataNotFountException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {

	private final QuestionRepository qr;
	
	public Page<Question> getList(int page){
		List<Sort.Order> sorts=new ArrayList<>(); 
		sorts.add(Sort.Order.desc("createDate"));
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		return this.qr.findAll(pageable);
	}
	
	public Question getQuestion(Integer id) {
		Optional<Question> question = this.qr.findById(id);
		if(question.isPresent()) {
			return question.get();
		}else {
			throw new DataNotFountException("question not found");
		}
	}
	
	public void create(String content, String subject) {
		Question q=new Question();
		q.setSubject(subject);
		q.setContent(content);
		q.setCreateDate(LocalDateTime.now());
		this.qr.save(q);
	}
}
