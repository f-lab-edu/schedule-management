package todo.schedule.management.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import todo.schedule.management.dto.ProjectDto;
import todo.schedule.management.entity.Project;
import todo.schedule.management.repository.ProjectMapper;
import todo.schedule.management.service.ProjectService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProjectServiceIntegrationTest {
    private final ProjectService projectService;
    private final ProjectMapper projectMapper;

    @Autowired
    public ProjectServiceIntegrationTest(ProjectService projectService, ProjectMapper projectMapper) {
        this.projectService = projectService;
        this.projectMapper = projectMapper;
    }

    @BeforeEach
    void setting(){
        // name is not unique
        projectService.insertProject(ProjectDto.Request.builder().name("startData").build());
    }

    @DisplayName("find project list")
    @Test
    void findProjectById(){
        List<ProjectDto.Response> projectList = projectService.getAllProjectList();
        assertNotNull(projectList);
        assertTrue(projectList.size() > 0);
    }

    @DisplayName("insert project")
    @Test
    void insertProject() {
        List<ProjectDto.Response> beforeProjectList = projectService.getAllProjectList();
        int count = beforeProjectList.size();
        projectService.insertProject(ProjectDto.Request.builder().name("testProject1").build());
        List<ProjectDto.Response> projectList = projectService.getAllProjectList();
        assertEquals(count + 1, projectList.size());

    }

    @DisplayName("delete project")
    @Test
    void deleteProject() {
        List<ProjectDto.Response> beforeProjectList = projectService.getAllProjectList();
        int count = beforeProjectList.size();
        projectService.deleteProject(1L);
        List<ProjectDto.Response> projectList = projectService.getAllProjectList();
        assertEquals(count - 1, projectList.size());

    }
}
