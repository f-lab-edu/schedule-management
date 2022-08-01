package todo.schedule.management.common;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ResponseDto <T>{
    // Some meta fields

    T data;

}
