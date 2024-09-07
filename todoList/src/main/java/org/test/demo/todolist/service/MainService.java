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

    @Transactional(readOnly = true)
    public List<TodoDto> todoList() {
        List<Todo> todos = mainRepository.findAllByDeletedFalse();

        return todos.stream().map(TodoDto::from).toList();
    };

    public void updateTodo(Long id, TodoDto dto) {
        try {
            Todo todo = mainRepository.getReferenceById(id);

            todo.setTitle(dto.title());

            mainRepository.save(todo);
        }catch (Exception e){
            log.warn("service 게시글 업데이트 실패 - {}", e.getMessage());
        }
    }

    public void deleteTodo(Long id) {
        try {
            Todo todo = mainRepository.getReferenceById(id);

            todo.setDeleted(true);

            mainRepository.save(todo);
        }catch (Exception e){
            log.warn("service 게시글 삭제 실패 - {}", e.getMessage());
        }
    }

    public void saveTodo(TodoDto dto) {
        Todo todo = dto.toEntity();

        mainRepository.save(todo);
    }
}
