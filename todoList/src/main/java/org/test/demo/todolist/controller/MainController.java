package org.test.demo.todolist.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.test.demo.todolist.dto.TodoDto;
import org.test.demo.todolist.service.MainService;

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
    public List<TodoDto> root(){
        return mainService.getAll();
    }

    //http://localhost:8080/api
    @GetMapping("/api")
    public List<TodoDto> react() {
        return mainService.getAll();
    }

}
