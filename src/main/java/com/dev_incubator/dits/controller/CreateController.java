package com.dev_incubator.dits.controller;

import com.dev_incubator.dits.persistence.entity.*;
import com.dev_incubator.dits.service.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
@AllArgsConstructor
public class CreateController {

    private TopicService topicService;
    private TestService testService;
    private QuestionServiceY questionService;
    private AnswerServiceY answerService;
    private LiteratureService literatureService;
    private LinkService linkService;


    @RequestMapping(value = "/getTests", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Test> searchTest(@RequestParam(value = "id", required = false)
                                         Long id) {
        return testService.getByTopicId(id);
    }

    @RequestMapping(value = "/getTest", method = RequestMethod.GET)
    public ModelAndView getTest(@RequestParam(value = "testList") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("test", testService.getById(id));
        modelAndView.setViewName("questionListForTest");
        return modelAndView;
    }

    @RequestMapping(value = "/getTest/{id}", method = RequestMethod.GET)
    public ModelAndView getTestForId(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("test", testService.getById(id));
        modelAndView.setViewName("questionListForTest");
        return modelAndView;
    }

    @RequestMapping(value = "/addQuestion/{id}", method = RequestMethod.GET)
    public ModelAndView addQuestionPage(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("test", testService.getById(id));
        modelAndView.setViewName("addQuestion");
        return modelAndView;
    }

    @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
    public ModelAndView addQuestion(@RequestParam(value = "testId") Long testId,
                                    @RequestParam(value = "description") String description,
                                    @RequestParam(value = "literature") String literatureString,
                                    @RequestParam(value = "link") String linkString,
                                    @RequestParam(value = "answer[]") List<String> answers,
                                    @RequestParam(value = "correct[]") List<String> corrects
    ) {
        ModelAndView modelAndView = new ModelAndView();
        Question question = new Question();
        question.setDescription(description);
        question.setTest(testService.getById(testId));
        questionService.add(question);
        Answer answer = new Answer();
        answer.setQuestion(question);
        for (int i = 0; i < answers.size(); i++) {
            answer.setId(0L);
            answer.setDescription(answers.get(i));
            answer.setCorrect(Boolean.parseBoolean(corrects.get(i)));
            answerService.add(answer);
        }
        Literature literature = new Literature();
        literature.setQuestion(question);
        literature.setDescription(literatureString);
        literatureService.add(literature);
        Link link = new Link();
        link.setLink(linkString);
        link.setLiterature(literature);
        linkService.add(link);
        modelAndView.setViewName("redirect:/getTest?testList=" + testId);
        return modelAndView;
    }

    @RequestMapping(value = "/addLiterature/{id}/{testId}", method = RequestMethod.GET)
    public ModelAndView addLiteraturePage(@PathVariable(value = "id") Long id,
                                          @PathVariable(value = "testId") Long testId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("questionId", id);
        modelAndView.addObject("testId", testId);
        modelAndView.setViewName("addLiterature");
        return modelAndView;
    }

    @RequestMapping(value = "/addLiterature", method = RequestMethod.POST)
    public ModelAndView addLiterature(@ModelAttribute(name = "literature") Literature literature,
                                      @RequestParam("link") String linkStr,
                                      @RequestParam("questionId") int id,
                                      @RequestParam("testId") long testId
    ) {
        ModelAndView modelAndView = new ModelAndView();
        Link link = new Link();
        link.setLink(linkStr);
        literature.setQuestion(questionService.getById(id));
        literatureService.add(literature);
        link.setLiterature(literature);
        linkService.add(link);
        modelAndView.setViewName("redirect:/getTest/" + testId);
        return modelAndView;
    }

    @RequestMapping(value = "/addLink", method = RequestMethod.POST)
    public ModelAndView addLink(@ModelAttribute(name = "literature") Literature literature,
                                @RequestParam("link") String linkStr,
                                @RequestParam("questionId") int id,
                                @RequestParam("testId") long testId
    ) {
        ModelAndView modelAndView = new ModelAndView();
        literature.setQuestion(questionService.getById(id));
        Link link = new Link();
        link.setLink(linkStr);
        link.setLiterature(literature);
        linkService.add(link);
        modelAndView.setViewName("redirect:/getTest/" + testId);
        return modelAndView;
    }

    @RequestMapping(value = "/addTest", method = RequestMethod.POST)
    public ModelAndView addTest(@RequestParam("name") String name,
                                @RequestParam("description") String description,
                                @RequestParam("topics") long id) {
        ModelAndView modelAndView = new ModelAndView();
        Test test = new Test();
        test.setName(name);
        test.setDescription(description);
        test.setTopic(topicService.getById(id));
        testService.add(test);
        modelAndView.setViewName("redirect:/tests/create");
        return modelAndView;
    }
}
