package com.dev_incubator.dits.controller;

import com.dev_incubator.dits.config.security.CustomUserDetails;
import com.dev_incubator.dits.exception.TopicNotFoundException;
import com.dev_incubator.dits.persistence.entity.*;
import com.dev_incubator.dits.service.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
@AllArgsConstructor
public class TestPageControllerY {

    private static int counter;
    private static CustomUserDetails user;
    private static int max;
    private static Timestamp date;
    private static List<Question> questionList;

    private UserService userService;

    private TestService testService;

    private QuestionServiceY questionService;

    private AnswerServiceY answerService;

    private StatisticService statisticService;

//    private ChooseTestControllerY chooseTestControllerY;

    private final TopicService topicService;

    @GetMapping(value = "/goTest")
    public String goTest(@RequestParam String testName, ModelMap modelMap,
                         Model model) {
        clearCounter();
        initVariables(testName);
        fillTestDB();
        if (questionList != null && questionList.size() != 0) {
            modelMap.addAttribute("questions", questionList.get(counter)
                    .getDescription());
            modelMap.addAttribute("answers", questionService.getAnswersByQuestionId
                    (questionList.get(counter).getId()));
        } else {
            model.addAttribute("topics", topicService.findAll());
            return "userChoose";
            //return "redirect:/chooseTest";
            //return chooseTestControllerY.chooseTest(model);
            //throw new TopicNotFoundException("");
        }
        return "testPageY";
    }

//    @GetMapping(value = "/chooseTest")
//    public String redirect(Model model) {
//        model.addAttribute("topics", topicService.findAll());
//        return "userChoose";
//    }

    @GetMapping(value = "/nextTestPage")
    public String nextTestPage(
            @RequestParam(value = "choosenAns", defaultValue = "-1") Long
                    id, ModelMap modelMap) {
        if (id != -1) {
            changeCorrectValue(answerService.getCorrectByDescription(id));
        }
        counter++;
        return chooseNextPage(modelMap);
    }

    public String chooseNextPage(ModelMap modelMap) {
        if (counter < max) {
            modelMap.addAttribute("questions", questionList.get(counter)
                    .getDescription());
            modelMap.addAttribute("answers", questionService.getAnswersByQuestionId
                    (questionList.get(counter).getId()));

            return "testPageY";
        } else {
            return resultPageFill(modelMap);
        }
    }

    @GetMapping("/resultPage")
    public String resultPageFill(ModelMap modelMap) {
        clearCounter();
        modelMap.addAttribute("statistic",
                statisticService.getAllByDate(date));
        return "resultPageY";
    }

    @GetMapping(value = "/logout")
    public String logout() {
        clearCounter();
        return "main";
    }

    private void initVariables(String testName) {
        user = (CustomUserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        date = new Timestamp(new Date().getTime());
        StatisticService.statList.clear();
        questionList = testService.getQuestionsByTestName(testName);
        max = questionList.size();
    }

    private Statistic configureStatistic() {
        Statistic statistic = new Statistic();
        statistic.setCorrect(false);
        statistic.setQuestion(questionList.get(counter));
        statistic.setUser(userService.findUserById(user.getId()));
        statistic.setDate(date);
        return statistic;
    }

    void fillTestDB() {
        while (StatisticService.statList.size() != max) {
            statisticService.statList
                    .put(String.valueOf(questionList.get(counter)
                            .getId()), configureStatistic());
            counter++;
        }
        statisticService.saveMapOfStat(StatisticService.statList, date);
        clearCounter();
    }

    private void changeCorrectValue(Answer answer) {
        if (answer.isCorrect()) {
            statisticService.changeCorrectValue(date,
                    userService.findUserById(user.getId()),
                    questionList.get(counter), answer.isCorrect());
        }
    }

    private void clearCounter() {
        counter = 0;
    }

}
