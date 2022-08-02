package todo.schedule.management.service;

import todo.schedule.management.dto.TodoDto;
import todo.schedule.management.entity.Todo;

import java.util.List;

public interface TodoService {

    TodoDto.Response toDto(Todo todo);
    Todo toEntity(TodoDto.Request todo);
    List<TodoDto.Response> getAllTodoList();
    void insertTodo(TodoDto.Request todo);
    void updateTodo(TodoDto.Request todo);
    void deleteTodo(Long id);
}
