package todo.schedule.management.service.implementation;

import org.springframework.stereotype.Service;
import todo.schedule.management.entity.Project;
import todo.schedule.management.dto.TodoDto;
import todo.schedule.management.entity.Todo;
import todo.schedule.management.repository.TodoMapper;
import todo.schedule.management.service.TodoService;

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
                .projectId(todo.getProject() == null ? null : todo.getProject().getId())
                .project(todo.getProject() == null ? null : todo.getProject().getName())
                .createdAt(todo.getCreatedAt().toString())
                .updatedAt(todo.getUpdatedAt().toString())
                .build();
    }

    @Override
    public Todo toEntity(TodoDto.Request todo) {
        return Todo.builder()
                .todo(todo.getTodo())
                .project(Project.builder().id(todo.getProjectId()).build())
                .build();
    }

    @Override
    public List<TodoDto.Response> getAllTodoList() {
        List<Todo> todoList = todoMapper.findAll();
        return todoList.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public TodoDto.Response getTodo(Long id) {
        return toDto(todoMapper.findById(id));
    }

    @Override
    public void insertTodo(TodoDto.Request todo) {
        int result = todoMapper.insertTodo(toEntity(todo));
    }

    @Override
    public void updateTodo(TodoDto.Request todo) {
        Todo target = toEntity(todo);
        target.setId(todo.getId());
        int result = todoMapper.updateTodo(target);
    }

    @Override
    public void deleteTodo(Long id) {
        int result = todoMapper.deleteTodo(id);
    }
}
