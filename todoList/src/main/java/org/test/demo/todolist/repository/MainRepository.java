package org.test.demo.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.test.demo.todolist.domain.FormStatus;
import org.test.demo.todolist.domain.Todo;

import java.util.List;

public interface MainRepository extends JpaRepository<Todo, Long>{
    List<Todo> findByDeletedContaining(String formStatus);
}
