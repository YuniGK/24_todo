package org.test.demo.todolist.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.test.demo.todolist.domain.Todo;
import org.test.demo.todolist.service.MainService;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@Controller
public class MainController {
    private final MainService mainService;

    //http://localhost:8080/swagger-ui/index.html

    //http://localhost:8080
    @GetMapping("/")
    public String root(ModelMap map){
        map.addAttribute("todos", mainService.getAll());

        log.info("todos = {}", mainService.getAll());
        System.out.println("todos = " + mainService.getAll());

        return "index";
    }

    //http://localhost:8080/api
    @GetMapping("/api")
    public List<String> react() {
        return Arrays.asList("1", "2");
    }

}
