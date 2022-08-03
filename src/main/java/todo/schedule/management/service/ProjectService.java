package todo.schedule.management.service;

import todo.schedule.management.dto.ProjectDto;
import todo.schedule.management.entity.Project;

import java.util.List;

public interface ProjectService {
    ProjectDto.Response toDto(Project project);
    Project toEntity(ProjectDto.Request project);
    ProjectDto.Response getProject(Long id);
    List<ProjectDto.Response> getAllProjectList();
    void insertProject(ProjectDto.Request projectDto);
    void updateProject(ProjectDto.Request projectDto);
    void deleteProject(Long id);
}
