package org.test.demo.todolist.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.demo.todolist.domain.Todo;
import org.test.demo.todolist.dto.TodoDto;
import org.test.demo.todolist.repository.MainRepository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class MainService {

    private final MainRepository mainRepository;

    public List<TodoDto> getAll() {
        List<Todo> todos = mainRepository.findAll();

        return todos.stream().map(TodoDto::from).toList();
    };
}
