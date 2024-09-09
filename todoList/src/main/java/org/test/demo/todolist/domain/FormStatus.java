package org.test.demo.todolist.domain;

import lombok.Getter;

public enum FormStatus {
    CREATE("저장", false),
    UPDATE("삭제", true);

    @Getter private final String description;
    @Getter
    private final Boolean update;

    FormStatus(String description, Boolean update) {
        this.description = description;
        this.update = update;
    }
}
