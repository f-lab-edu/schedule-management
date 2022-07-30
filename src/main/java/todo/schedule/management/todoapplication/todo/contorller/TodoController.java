package todo.schedule.management.todoapplication.todo.contorller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import todo.schedule.management.todoapplication.common.ResponseDto;
import todo.schedule.management.todoapplication.todo.dto.TodoDto;
import todo.schedule.management.todoapplication.todo.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/list")
    ResponseEntity<ResponseDto<List<TodoDto.Response>>> getAllTodoList() {

//        return ResponseEntity.ok().body(TodoDto.Response.builder()
//                .id(1L).todo("test").build());
        return ResponseEntity.ok().body(ResponseDto.<List<TodoDto.Response>>builder().build());
    }
}
