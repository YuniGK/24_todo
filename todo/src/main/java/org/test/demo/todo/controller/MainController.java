package org.test.demo.todo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MainController {
    //http://localhost:8080/swagger-ui/index.html

    //http://localhost:8080/
    @GetMapping("/")
    public String root(){
        return "index";
    }
}
