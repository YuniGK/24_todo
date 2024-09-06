package org.test.demo.todolist.dto.request;

import org.test.demo.todolist.dto.TodoDto;

public record TodoRequest (
        String title
) {
    public static TodoRequest of(String title) {
        return new TodoRequest(title);
    }

    public TodoDto toDto() {
        return TodoDto.of(
                title
        );
    }
}
