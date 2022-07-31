package todo.schedule.management.todo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import todo.schedule.management.repository.TodoMapper;
import todo.schedule.management.service.TodoService;
import todo.schedule.management.dto.TodoDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TodoServiceIntegrationTest {

    private final TodoService todoService;

    @Autowired
    public TodoServiceIntegrationTest(TodoService todoService) {
        this.todoService = todoService;
    }


    @DisplayName("find all todo list")
    @Test
    void findAllTodoList(){
        List<TodoDto.Response> todoList = todoService.getAllTodoList();
        for(TodoDto.Response response : todoList){
            assertNotNull(response);
            assertNotNull(response.getProject());
        }
    }

    @DisplayName("insert todo")
    @Test
    void insertTodo(){
        todoService.insertTodo(TodoDto.Request.builder()
                        .todo("insertTest1")
                        .projectId(1L)
                .build());
        List<TodoDto.Response> todoList = todoService.getAllTodoList();
        for(TodoDto.Response response : todoList){
            assertNotNull(response);
            assertNotNull(response.getProject());
        }
    }
}
