package todo.schedule.management.todoapplication.todo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import todo.schedule.management.todoapplication.project.entity.Project;
import todo.schedule.management.todoapplication.project.repository.ProjectMapper;
import todo.schedule.management.todoapplication.todo.dto.TodoDto;
import todo.schedule.management.todoapplication.todo.entity.Todo;
import todo.schedule.management.todoapplication.todo.repository.TodoMapper;
import todo.schedule.management.todoapplication.todo.service.TodoService;

import java.util.List;

@SpringBootTest
public class TodoServiceIntegrationTest {

    private final TodoMapper todoMapper;
    private final TodoService todoService;
    private final ProjectMapper projectMapper;

    @Autowired
    public TodoServiceIntegrationTest(TodoMapper todoMapper, TodoService todoService, ProjectMapper projectMapper) {
        this.todoMapper = todoMapper;
        this.todoService = todoService;
        this.projectMapper = projectMapper;
    }


    @DisplayName("find all todo list")
    @Test
    void findAllTodoList(){
//        List<TodoDto.Response> todoList = todoService.findAllTodoList();
        List<Todo> todoList = todoMapper.findAll();
        Project project = projectMapper.findById(1L);
        System.out.println(todoList.get(0).getProject());
        System.out.println(todoList);
        System.out.println(project);

    }
}
