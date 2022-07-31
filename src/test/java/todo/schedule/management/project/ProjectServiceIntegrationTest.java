package todo.schedule.management.project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import todo.schedule.management.entity.Project;
import todo.schedule.management.repository.ProjectMapper;

@SpringBootTest
public class ProjectServiceIntegrationTest {
    private final ProjectMapper projectMapper;

    @Autowired
    public ProjectServiceIntegrationTest(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }


    @DisplayName("find project by id")
    @Test
    void findProjectById(){
        Project project = projectMapper.findById(1L);
        System.out.println(project);

    }
}
