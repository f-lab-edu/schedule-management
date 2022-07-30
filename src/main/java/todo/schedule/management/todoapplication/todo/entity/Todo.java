package todo.schedule.management.todoapplication.todo.entity;

import lombok.*;
import todo.schedule.management.todoapplication.project.entity.Project;

import java.time.LocalDateTime;

@Getter
@Builder // Not recommend to use like this
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Todo {
    private Long id;
    private String todo;
    private String createdAt;
    private String updatedAt;
    private Project project;
}
