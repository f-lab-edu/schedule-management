package todo.schedule.management.dto;

import lombok.*;
import todo.schedule.management.entity.Todo;

import java.time.LocalDateTime;
import java.util.List;

public class ProjectDto {
    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Request{
        String name;
    }
    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Response{
        Long id;
        String name;
        String createdAt;
        String updatedAt;

        List<TodoDto.Response> todoList;
    }
}
