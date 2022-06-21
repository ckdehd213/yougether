package com.mysite.yougether.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

/*스프링 의존성주입
 1. @Autowired
 2. 생성자를 작성하여 객체를 주입하는 방식
 3.Getter, Setter메서드작성
 */
@RequestMapping("/question")
@RequiredArgsConstructor // 자동으로 생성자를 생성
@Controller
public class QuestionController {

	private final QuestionService service;
	
	@RequestMapping("/list")
	//@ResponseBody 템플릿을 사용하기 때문에 필요 x
	public String list(Model model) {
		
		List<Question> questionList = this.service.getList();
		model.addAttribute("QList", questionList);
		
		return "question_list";
	}
	
	@RequestMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Question question = this.service.getQuestion(id);
		model.addAttribute("question", question);
		return "question_detail";
	}
	
}
