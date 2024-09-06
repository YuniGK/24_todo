package org.test.demo.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.test.demo.todolist.domain.Todo;

public interface MainRepository extends JpaRepository<Todo, Long>{

}
