package todo.schedule.management.common;

import lombok.Builder;

@Builder
public class ResponseDto <T>{
    // Some meta fields

    T data;

}
