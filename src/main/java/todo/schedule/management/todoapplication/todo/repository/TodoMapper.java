package todo.schedule.management.todoapplication.todo.repository;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import todo.schedule.management.todoapplication.todo.entity.Todo;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface TodoMapper {

    List<Todo> findAll();
    List<Todo> findById();

}
