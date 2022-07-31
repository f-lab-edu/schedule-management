package todo.schedule.management.entity;

import lombok.*;

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
