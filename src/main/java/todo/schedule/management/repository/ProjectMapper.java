package todo.schedule.management.repository;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import todo.schedule.management.entity.Project;
import todo.schedule.management.entity.Todo;

import java.util.List;

@Mapper
@Repository
public interface ProjectMapper {
    Project findById(Long id);
    List<Project> findAll();
    int insertProject(Project project);
    int deleteProject(Long id);
}
