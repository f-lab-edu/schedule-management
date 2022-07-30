package todo.schedule.management.todoapplication.common;

import lombok.Builder;

@Builder
public class ResponseDto <T>{
    // Some meta fields

    T data;

}
