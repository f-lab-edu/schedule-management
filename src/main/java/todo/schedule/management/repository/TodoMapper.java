package todo.schedule.management.repository;

import org.apache.ibatis.annotations.*;
import todo.schedule.management.entity.Todo;

import java.util.List;

@Mapper
public interface TodoMapper {

    List<Todo> findAll();
    Todo findById(Long id);
    int insertTodo(@Param("Todo") Todo todo);
    int deleteTodo(Long id);

}
