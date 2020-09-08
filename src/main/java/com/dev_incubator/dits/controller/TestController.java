package com.dev_incubator.dits.controller;

import com.dev_incubator.dits.service.interfaces.TestService;
import com.dev_incubator.dits.service.interfaces.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/tests")
@AllArgsConstructor
public class TestController {

    private final TestService testService;

    private final TopicService topicService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'TUTOR')")
    public String getAllTestsInformation(Model model) {
        model.addAttribute("listTopicsWithTests", topicService.getAllTopicsWithTests());
        return "test-list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView editTest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("topicList",topicService.findAll());
        modelAndView.setViewName("getTests");
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editQuestion() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("topicList", topicService.findAll());
        modelAndView.setViewName("editQuestionsAndAnswers");
        return modelAndView;
    }
}
