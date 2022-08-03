package todo.schedule.management.contorller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todo.schedule.management.common.ResponseDto;
import todo.schedule.management.dto.TodoDto;
import todo.schedule.management.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/id/{id}")
    ResponseEntity<ResponseDto<TodoDto.Response>> getTodo(@PathVariable Long id){
        return ResponseEntity.ok().body(ResponseDto.<TodoDto.Response>builder().data(
            todoService.getTodo(id)
        ).build());
    }

    @GetMapping("/list")
    ResponseEntity<ResponseDto<List<TodoDto.Response>>> getAllTodoList() {

        return ResponseEntity.ok().body(ResponseDto.<List<TodoDto.Response>>builder().data(
                todoService.getAllTodoList()
        ).build());
    }
    @PostMapping("")
    ResponseEntity<ResponseDto<String>> insertTodo(@RequestBody TodoDto.Request todoDto){
        todoService.insertTodo(todoDto);
        return ResponseEntity.ok().body(ResponseDto.<String>builder().data("success").build());
    }

    @PostMapping("/update-todo")
    ResponseEntity<ResponseDto<String>> updateTodo(@RequestBody TodoDto.Request todoDto){
        todoService.updateTodo(todoDto);
        return ResponseEntity.ok().body(ResponseDto.<String>builder().data("success").build());
    }

    @PostMapping("/deletion-id/{id}")
    ResponseEntity<ResponseDto<String>> deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
        return ResponseEntity.ok().body(ResponseDto.<String>builder().data("success").build());
    }
}
