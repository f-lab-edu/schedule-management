package todo.schedule.management.todoapplication.todo.service.implementation;

import org.springframework.stereotype.Service;
import todo.schedule.management.todoapplication.todo.dto.TodoDto;
import todo.schedule.management.todoapplication.todo.entity.Todo;
import todo.schedule.management.todoapplication.todo.repository.TodoMapper;
import todo.schedule.management.todoapplication.todo.service.TodoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoMapper todoMapper;

    public TodoServiceImpl(TodoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    @Override
    public TodoDto.Response toDto(Todo todo) {
        return TodoDto.Response.builder()
                .id(todo.getId())
                .todo(todo.getTodo())
                .projectId(todo.getProject().getId())
                .project(todo.getProject().getName())
                .build();
    }

    @Override
    public List<TodoDto.Response> findAllTodoList() {
        List<Todo> todoList = todoMapper.findAll();
        System.out.println(todoList);
        return todoList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
