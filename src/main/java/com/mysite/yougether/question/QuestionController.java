package com.mysite.yougether.question;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.yougether.answer.AnswerForm;
import com.mysite.yougether.user.SiteUser;
import com.mysite.yougether.user.UserService;

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

	private final QuestionService qService;
	private final UserService uService; 
	
	@RequestMapping("/list")
	//@ResponseBody 템플릿을 사용하기 때문에 필요 x
	public String list(Model model, @RequestParam(value="page", defaultValue = "0") int page) {
		
		Page<Question> paging = this.qService.getList(page);
		model.addAttribute("paging", paging);
		
		return "question_list";
	}
	
	@RequestMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
		Question question = this.qService.getQuestion(id);
		model.addAttribute("question", question);
		return "question_detail";

	}
	
	@GetMapping("/create")
	public String questionCreate(QuestionForm questionForm) {
		return "question_form";
	}
	// 오버로딩
	@PostMapping("/create")
	public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult, Principal principal) {
			if(bindingResult.hasErrors()) {
				return "question_form";
			}
			SiteUser siteUser = this.uService.getUser(principal.getName());
		this.qService.create(questionForm.getSubject(), questionForm.getContent(), siteUser);
		return "redirect:/question/list";
	}
	
}
