package org.test.demo.todolist.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.test.demo.todolist.domain.Todo;
import org.test.demo.todolist.dto.TodoDto;
import org.test.demo.todolist.dto.request.TodoRequest;
import org.test.demo.todolist.service.MainService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@Controller
@RequestMapping("/todo")
public class MainController {
    private final MainService mainService;

    //http://localhost:8080/swagger-ui/index.html

    //목록 조회
    @GetMapping()
    public ResponseEntity<?> root(){
        try {
            List<TodoDto> todoList = mainService.todoList();

            if(todoList.isEmpty()){
                log.info("=== todo list is empty ===");
            }

            return new ResponseEntity<>(todoList, HttpStatus.OK);
        }catch (Exception e){
            log.error("todo list >>> ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //수정
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id
            , TodoRequest request){
        try {
            mainService.updateTodo(id, request.toDto());
            return new ResponseEntity<>("update", HttpStatus.OK);
        }catch (Exception e){
            log.error("todo update >>> ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //등록
    @PostMapping("/insert")
    public ResponseEntity<?> insert(TodoRequest request){
        try {
            mainService.saveTodo(request.toDto());

            return new ResponseEntity<>("insert", HttpStatus.OK);
        }catch (Exception e){
            log.error("todo insert >>> ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //삭제
    @PutMapping("/deleted/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            mainService.deleteTodo(id);
            return new ResponseEntity<>("deleted", HttpStatus.OK);
        }catch (Exception e){
            log.error("todo deleted >>> ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
