package todo.schedule.management.dto;

import lombok.*;

public class TodoDto {

    @Getter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class Request{
        Long id;
        String todo;
        Long projectId;
    }

    @Getter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class Response {
        Long id;
        String todo;
        String createdAt;
        String updatedAt;
        Long projectId;
        String project;
    }
}
