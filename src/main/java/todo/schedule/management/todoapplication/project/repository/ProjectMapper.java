package todo.schedule.management.todoapplication.project.repository;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import todo.schedule.management.todoapplication.project.entity.Project;

@Mapper
@Repository
public interface ProjectMapper {
    Project findById(Long id);
}
