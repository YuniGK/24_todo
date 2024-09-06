package org.test.demo.todolist.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@Controller
public class MainController {
    //http://localhost:8080/swagger-ui/index.html

    //http://localhost:8080/
    @GetMapping("/")
    @ResponseBody
    public String root(){
        return "index";
    }

    //http://localhost:8080/
    @GetMapping("/api")
    public List<String> react() {
        return Arrays.asList("1", "2");
    }

    //http://localhost:8080/api/test
    @GetMapping("/api/test")
    public List<String> reactRoot() {
        return Arrays.asList("1", "2");
    }
}
