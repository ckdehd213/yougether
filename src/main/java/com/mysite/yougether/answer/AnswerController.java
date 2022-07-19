package com.mysite.yougether.answer;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysite.yougether.question.Question;
import com.mysite.yougether.question.QuestionService;
import com.mysite.yougether.user.SiteUser;
import com.mysite.yougether.user.UserService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

	private final QuestionService qService;
	private final AnswerService aService;
	private final UserService uService;
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create/{id}")
	//@RequestMapping(value = "/create/{id}", method = {RequestMethod.POST, RequestMethod.GET})
    public String createAnswer(Model model, @PathVariable("id") Integer id,
                               @Valid AnswerForm answerForm, BindingResult bindingResult, Principal principal) {
        Question question = this.qService.getQuestion(id);
        SiteUser siteUser = this.uService.getUser(principal.getName());
        if (bindingResult.hasErrors()) {
            model.addAttribute("question", question);
            return "question_detail";
        }
        this.aService.create(question, answerForm.getContent(), siteUser);
        return String.format("redirect:/question/detail/%s", id);
    }
}