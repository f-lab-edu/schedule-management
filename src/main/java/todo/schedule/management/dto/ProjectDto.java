package todo.schedule.management.dto;

import lombok.*;

import java.util.List;

public class ProjectDto {
    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Request{
        Long id;
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
