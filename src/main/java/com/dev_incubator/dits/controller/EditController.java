package com.dev_incubator.dits.controller;

import com.dev_incubator.dits.persistence.entity.*;
import com.dev_incubator.dits.service.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
@AllArgsConstructor
public class EditController {

    private AnswerServiceY answerService;
    private QuestionServiceY questionService;
    private TestService testService;
    private LiteratureService literatureService;
    private LinkService linkService;


    @RequestMapping(value = "/getTestsForEdit", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Test> searchTest(@RequestParam(value = "id", required = false) Long id) {
        return testService.getByTopicIdForEdit(id);
    }

    @RequestMapping(value = "/getQuestionForEdit", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Question> searchQuestion(@RequestParam(value = "id", required = false) Long id) {
        return questionService.getByTestForEdit(id);
    }

    @RequestMapping(value = "/getAnswersForEdit", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Answer> searchAnswer(@RequestParam(value = "id", required = false) Long id) {
        return answerService.getAnswerByQuestion(id);
    }

    @RequestMapping(value = "/editAnswer/{id}", method = RequestMethod.GET)
    public ModelAndView editAnswerPage(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("answer", answerService.getById(id));
        modelAndView.setViewName("editAnswer");
        return modelAndView;
    }

    @RequestMapping(value = "/editAnswer", method = RequestMethod.POST)
    public ModelAndView editAnswer(@ModelAttribute(name = "answer") Answer answer,
                                   @RequestParam("questionId") int id
    ) {
        ModelAndView modelAndView = new ModelAndView();
        answer.setQuestion(questionService.getById(id));
        answerService.update(answer);
        modelAndView.setViewName("redirect:/tests/edit");
        return modelAndView;
    }

    @RequestMapping(value = "/addAnswer/{id}", method = RequestMethod.GET)
    public ModelAndView addAnswerPage(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("questionId", id);
        modelAndView.setViewName("addAnswer");
        return modelAndView;
    }

    @RequestMapping(value = "/addAnswer", method = RequestMethod.POST)
    public ModelAndView addAnswer(@ModelAttribute(name = "answer") Answer answer,
                                  @RequestParam("questionId") int id
    ) {
        ModelAndView modelAndView = new ModelAndView();
        answer.setQuestion(questionService.getById(id));
        answerService.add(answer);
        modelAndView.setViewName("redirect:/tests/edit");
        return modelAndView;
    }

    @RequestMapping(value = "/deleteAnswer/{id}", method = RequestMethod.GET)
    public ModelAndView deleteAnswer(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        answerService.delete(id);
        modelAndView.setViewName("redirect:/tests/edit");
        return modelAndView;
    }


    @RequestMapping(value = "/editQuestion/{id}", method = RequestMethod.GET)
    public ModelAndView updateQuestionPage(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("question", questionService.getById(id));
        modelAndView.setViewName("editQuestion");
        return modelAndView;
    }

    @RequestMapping(value = "/editQuestion", method = RequestMethod.POST)
    public ModelAndView updateLiteraturePage(@ModelAttribute(name = "question") Question question,
                                             @RequestParam(name = "testId") Long testId) {
        ModelAndView modelAndView = new ModelAndView();
        question.setTest(testService.getById(testId));
        questionService.update(question);
        modelAndView.setViewName("redirect:/getTest/" + testId);
        return modelAndView;
    }

    @RequestMapping(value = "/editLiterature/{id}/{testId}", method = RequestMethod.GET)
    public ModelAndView updateLiteraturePage(@PathVariable("id") long id,
                                             @PathVariable("testId") long testId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("literature", literatureService.getById(id));
        modelAndView.addObject("testId", testId);
        modelAndView.setViewName("editLiterature");
        return modelAndView;
    }


    @RequestMapping(value = "/editLiterature", method = RequestMethod.POST)
    public ModelAndView updateLiterature(@ModelAttribute(name = "literature") Literature literature,
                                         @RequestParam(name = "link[]") List<String> links,
                                         @RequestParam(name = "linkId[]") List<Long> linksId,
                                         @RequestParam(name = "size") long size,
                                         @RequestParam(name = "questionId") long questionId,
                                         @RequestParam(name = "testId") long testId) {
        ModelAndView modelAndView = new ModelAndView();
        literature.setQuestion(questionService.getById(questionId));
        for (int i = 0; i < size; i++
                ) {
            Link link = new Link();
            link.setId(linksId.get(i));
            link.setLink(links.get(i));
            link.setLiterature(literature);
            linkService.update(link);
        }
        literatureService.update(literature);
        modelAndView.setViewName("redirect:/getTest/" + testId);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteLink/{id}/{testId}", method = RequestMethod.GET)
    public ModelAndView deleteLink(@PathVariable("id") long id,
                                   @PathVariable("testId") Long testId) {
        ModelAndView modelAndView = new ModelAndView();
        linkService.delete(id);
        modelAndView.setViewName("redirect:/getTest/" + testId);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteLiterature/{id}/{testId}", method = RequestMethod.GET)
    public ModelAndView deleteLiterature(@PathVariable("id") long id,
                                         @PathVariable("testId") Long testId) {
        ModelAndView modelAndView = new ModelAndView();
        Literature literature = literatureService.getById(id);
        for (Link link : literature.getLinks()) {
            linkService.delete(link.getId());
        }
        literatureService.delete(id);
        modelAndView.setViewName("redirect:/getTest/" + testId);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteQuestion/{id}/{testId}", method = RequestMethod.GET)
    public ModelAndView deleteQuestion(@PathVariable("id") long id,
                                       @PathVariable("testId") Long testId) {
        ModelAndView modelAndView = new ModelAndView();
        Question question = questionService.getById(id);
        for (Literature literature : question.getLiterature()
                ) {
            for (Link link : literature.getLinks()
                    ) {
                linkService.delete(link.getId());
            }
            literatureService.delete(literature.getId());
        }
        for (Answer answer : question.getAnswers()
                ) {
            answerService.delete(answer.getId());
        }
        questionService.delete(question.getId());
        modelAndView.setViewName("redirect:/getTest/" + testId);
        return modelAndView;
    }
}