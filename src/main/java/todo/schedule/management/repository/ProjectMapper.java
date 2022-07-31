package todo.schedule.management.repository;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import todo.schedule.management.entity.Project;

@Mapper
@Repository
public interface ProjectMapper {
    Project findById(Long id);
}
