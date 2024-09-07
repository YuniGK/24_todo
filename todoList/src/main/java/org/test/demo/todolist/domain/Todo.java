package org.test.demo.todolist.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import java.util.Objects;

@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "createdAt")
})
@Entity
public class Todo extends AuditingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String title;

    @Setter
    private String deleted; // 삭제여부

    public Todo(String title, String deleted) {
        this.title = title;
        this.deleted = deleted;
    }

    public static Todo of(String title, String deleted) {
        return new Todo(title, deleted);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Todo todo)) return false;
        return Objects.equals(id, todo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
