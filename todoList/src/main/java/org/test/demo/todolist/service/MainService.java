package org.test.demo.todolist.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.demo.todolist.domain.FormStatus;
import org.test.demo.todolist.domain.Todo;
import org.test.demo.todolist.dto.TodoDto;
import org.test.demo.todolist.repository.MainRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class MainService {

    private final MainRepository mainRepository;

    @Transactional(readOnly = true)
    public List<TodoDto> todoList() {
        List<Todo> todos = mainRepository.findByDeletedContaining(FormStatus.CREATE.getDescription());

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

            todo.setDeleted(FormStatus.UPDATE.getDescription());

            mainRepository.save(todo);
        }catch (Exception e){
            log.warn("service 게시글 삭제 실패 - {}", e.getMessage());
        }
    }

    public void saveTodo(TodoDto req) {
        mainRepository.save(req.toEntity());
    }

    @Transactional(readOnly = true)
    public TodoDto todos(Long id) {
        return mainRepository.findById(id)
                .map(TodoDto::from)
                .orElseThrow(() -> new EntityNotFoundException("게시글이 없습니다 - id: " + id));
    }
}
