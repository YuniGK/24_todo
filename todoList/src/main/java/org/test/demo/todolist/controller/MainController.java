package org.test.demo.todolist.controller;

import io.netty.handler.codec.socks.SocksSubnegotiationVersion;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.test.demo.todolist.domain.Todo;
import org.test.demo.todolist.dto.TodoDto;
import org.test.demo.todolist.dto.request.TodoRequest;
import org.test.demo.todolist.dto.response.TodoResponse;
import org.test.demo.todolist.service.MainService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

@Controller
@RestController
@RequestMapping("/todo")
public class MainController {
    private final MainService mainService;

    //http://localhost:8080/swagger-ui/index.html

    //목록 조회
    @GetMapping()
    public ResponseEntity<?> getAll(){
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

    @GetMapping("/list/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            TodoResponse todo = TodoResponse.from(mainService.todos(id));

            return new ResponseEntity<>(todo, HttpStatus.OK);
        }catch (Exception e){
            log.error("todo one >>> ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //수정
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id
            , @RequestBody TodoRequest req){
        try {
            mainService.updateTodo(id, req.toDto());
            return new ResponseEntity<>("update", HttpStatus.OK);
        }catch (Exception e){
            log.error("todo update >>> ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //등록
    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody TodoRequest req){
        try {
            mainService.saveTodo(req.toDto());

            return new ResponseEntity<>("insert", HttpStatus.CREATED);
        }catch (Exception e){
            log.error("todo insert >>> ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //삭제
    @PutMapping("/deleted/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            log.info("id {}", id);
            mainService.deleteTodo(id);
            return new ResponseEntity<>("deleted", HttpStatus.OK);
        }catch (Exception e){
            log.error("todo deleted >>> ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
