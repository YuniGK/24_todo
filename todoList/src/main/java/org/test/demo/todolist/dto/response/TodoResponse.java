package org.test.demo.todolist.dto.response;

import org.test.demo.todolist.dto.TodoDto;

import java.time.LocalDateTime;

public record TodoResponse(
        Long id
        , String title
        , LocalDateTime createdAt
        , LocalDateTime modifiedAt
        , String deleted
) {
    public static TodoResponse of(long id, String title, LocalDateTime createdAt, LocalDateTime modifiedAt, String deleted){
        return new TodoResponse(id, title, createdAt, modifiedAt, deleted);
    }

    public static TodoResponse from(TodoDto dto){
        return new TodoResponse(
                dto.id()
                , dto.title()
                , dto.createdAt()
                , dto.modifiedAt()
                , dto.deleted()
        );
    }
}
