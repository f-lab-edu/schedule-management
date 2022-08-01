package todo.schedule.management.contorller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todo.schedule.management.common.ResponseDto;
import todo.schedule.management.dto.ProjectDto;
import todo.schedule.management.service.ProjectService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/hello")
    String hello(){
        return "hello";
    }

    @GetMapping("/id/{id}")
    ResponseEntity<ResponseDto<ProjectDto.Response>> getProject(@PathVariable Long id){
        return ResponseEntity.ok().body(ResponseDto.<ProjectDto.Response>builder().data(
                projectService.getProject(id)
        ).build());
    }

    @GetMapping("/list")
    ResponseEntity<ResponseDto<List<ProjectDto.Response>>> getAllProjectList(){
        return ResponseEntity.ok().body(ResponseDto.<List<ProjectDto.Response>>builder().data(
               projectService.getAllProjectList()
        ).build());
    }

    @PostMapping("")
    ResponseEntity<ResponseDto<String>> insertProject(@RequestBody ProjectDto.Request projectDto){
        projectService.insertProject(projectDto);
        return ResponseEntity.ok().body(ResponseDto.<String>builder().data("success").build());
    }

    @PostMapping("/deletion-id/{id}")
    ResponseEntity<ResponseDto<String>> deleteProject(@PathVariable Long id){
        projectService.deleteProject(id);
        return ResponseEntity.ok().body(ResponseDto.<String>builder().data("success").build());
    }
}
