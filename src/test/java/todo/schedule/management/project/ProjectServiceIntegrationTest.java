package todo.schedule.management.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import todo.schedule.management.dto.ProjectDto;
import todo.schedule.management.service.ProjectService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProjectServiceIntegrationTest {
    private final ProjectService projectService;

    @Autowired
    public ProjectServiceIntegrationTest(ProjectService projectService) {
        this.projectService = projectService;
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

    @DisplayName("update project")
    @Test
    void updateProject() {
        final String projectName = "updated";
        List<ProjectDto.Response> beforeProjectList = projectService.getAllProjectList();
        ProjectDto.Response temp = beforeProjectList.get(0);
        ProjectDto.Request target = ProjectDto.Request.builder().id(temp.getId()).name(projectName).build();

        projectService.updateProject(target);

        ProjectDto.Response project = projectService.getProject(temp.getId());
        assertEquals(projectName, project.getName());

    }

    @DisplayName("delete project")
    @Test
    void deleteProject() {
        List<ProjectDto.Response> beforeProjectList = projectService.getAllProjectList();
        int count = beforeProjectList.size();
        projectService.deleteProject(1L);
        List<ProjectDto.Response> projectList = projectService.getAllProjectList();
        assertEquals(Math.max(count -1 , 0), projectList.size());

    }
}
