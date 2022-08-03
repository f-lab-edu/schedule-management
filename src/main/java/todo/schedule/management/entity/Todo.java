package todo.schedule.management.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder // Not recommend to use like this
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Todo {
    private Long id;
    private String todo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Project project;
}
