package todo.schedule.management.todoapplication.todo.service;

import org.springframework.stereotype.Service;
import todo.schedule.management.todoapplication.todo.dto.TodoDto;
import todo.schedule.management.todoapplication.todo.entity.Todo;

import java.util.List;

public interface TodoService {

    TodoDto.Response toDto(Todo todo);
    List<TodoDto.Response> findAllTodoList();
}
