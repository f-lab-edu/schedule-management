package todo.schedule.management.todoapplication.todo.dto;

import lombok.*;
import todo.schedule.management.todoapplication.common.ResponseDto;

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
        Long projectId;
        String project;
    }
}
