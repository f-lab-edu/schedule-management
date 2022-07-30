package todo.schedule.management.todoapplication.project.entity;

import lombok.*;
import todo.schedule.management.todoapplication.todo.entity.Todo;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Project {
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Todo> todoList;
}
