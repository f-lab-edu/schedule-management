package todo.schedule.management.service.implementation;

import org.springframework.stereotype.Service;
import todo.schedule.management.dto.ProjectDto;
import todo.schedule.management.entity.Project;
import todo.schedule.management.repository.ProjectMapper;
import todo.schedule.management.service.ProjectService;
import todo.schedule.management.service.TodoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final TodoService todoService;
    private final ProjectMapper projectMapper;

    public ProjectServiceImpl(TodoService todoService, ProjectMapper projectMapper) {
        this.todoService = todoService;
        this.projectMapper = projectMapper;
    }

    @Override
    public ProjectDto.Response toDto(Project project) {
        if(project == null){
            throw new RuntimeException("project is null");
        }
        return ProjectDto.Response.builder()
                .id(project.getId())
                .name(project.getName())
                .createdAt(project.getCreatedAt().toString())
                .updatedAt(project.getUpdatedAt().toString())
                .todoList(project.getTodoList().stream()
                        .map(todoService::toDto)
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public Project toEntity(ProjectDto.Request project) {
        return Project.builder()
                .name(project.getName())
                .build();
    }

    @Override
    public ProjectDto.Response getProject(Long id) {
        return toDto(projectMapper.findById(id));
    }

    @Override
    public List<ProjectDto.Response> getAllProjectList() {
        return projectMapper.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void insertProject(ProjectDto.Request projectDto) {
        projectMapper.insertProject(toEntity(projectDto));
    }

    @Override
    public void deleteProject(Long id) {
        projectMapper.deleteProject(id);
    }
}
