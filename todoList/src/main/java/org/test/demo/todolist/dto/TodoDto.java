package org.test.demo.todolist.dto;

import org.test.demo.todolist.domain.Todo;

import java.time.LocalDateTime;

public record TodoDto(
        Long id
        , String title
        , LocalDateTime createdAt
        , LocalDateTime modifiedAt
        , Boolean deleted
) {
    public static TodoDto of(
            Long id
            , String title
            , LocalDateTime createdAt
            , LocalDateTime modifiedAt
            , Boolean deleted) {
        return new TodoDto(id, title, createdAt, modifiedAt, deleted);
    }

    public static TodoDto of(String title) {
        return new TodoDto(null, title, null, null, null);
    }

    public static TodoDto from(Todo entity){
        return new TodoDto(
                entity.getId()
                , entity.getTitle()
                , entity.getCreatedAt()
                , entity.getModifiedAt()
                , entity.getDeleted()
        );
    }

    public Todo toEntity(){
        return Todo.of(
                title
                , createdAt
                , modifiedAt
                , deleted
        );
    }
}
