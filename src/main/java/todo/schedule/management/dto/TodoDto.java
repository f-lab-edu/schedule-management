package todo.schedule.management.dto;

import lombok.*;

import java.time.LocalDateTime;

public class TodoDto {

    @Getter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class Request{
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
