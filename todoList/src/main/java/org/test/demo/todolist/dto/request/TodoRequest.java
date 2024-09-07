package org.test.demo.todolist.dto.request;

import org.test.demo.todolist.dto.TodoDto;

public record TodoRequest (
        String title
        , String deleted
) {
    public static TodoRequest of(String title, String deleted) {
        return new TodoRequest(title, deleted);
    }

    public TodoDto toDto() {
        return TodoDto.of(
                title
                , deleted
        );
    }
}
