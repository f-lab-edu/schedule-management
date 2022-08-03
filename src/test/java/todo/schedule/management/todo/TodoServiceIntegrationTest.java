package todo.schedule.management.todo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import todo.schedule.management.dto.ProjectDto;
import todo.schedule.management.service.ProjectService;
import todo.schedule.management.service.TodoService;
import todo.schedule.management.dto.TodoDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TodoServiceIntegrationTest {

	private final TodoService todoService;
	private final ProjectService projectService;

	@Autowired
	public TodoServiceIntegrationTest(TodoService todoService,
		ProjectService projectService) {
		this.todoService = todoService;
		this.projectService = projectService;
	}

	@DisplayName("find all todo list")
	@Test
	void findAllTodoList() {
		List<TodoDto.Response> todoList = todoService.getAllTodoList();
		for (TodoDto.Response response : todoList) {
			assertNotNull(response);
			assertNotNull(response.getProject());
		}
	}

	@DisplayName("insert todo")
	@Test
	void insertTodo() {
		List<ProjectDto.Response> projectList = projectService.getAllProjectList();
		todoService.insertTodo(TodoDto.Request.builder()
			.todo("insertTest1")
			.projectId(projectList.get(0).getId())
			.build());
		List<TodoDto.Response> todoList = todoService.getAllTodoList();
		for (TodoDto.Response response : todoList) {
			assertNotNull(response);
			assertNotNull(response.getProject());
		}
	}

	@DisplayName("update todo")
	@Test
	void updateProject() {
		final String todo = "updated";
		List<TodoDto.Response> beforeTodoList = todoService.getAllTodoList();
		TodoDto.Response temp = beforeTodoList.get(0);
		TodoDto.Request target = TodoDto.Request.builder()
			.id(temp.getId())
			.todo(todo)
			.projectId(temp.getProjectId())
			.build();

		todoService.updateTodo(target);

		TodoDto.Response todoResponse = todoService.getTodo(temp.getId());
		assertEquals(todo, todoResponse.getTodo());

	}

	@DisplayName("delete todo")
	@Test
	void deleteProject() {
		List<TodoDto.Response> beforeTodoList = todoService.getAllTodoList();
		int count = beforeTodoList.size();
		todoService.deleteTodo(1L);
		List<TodoDto.Response> todoList = todoService.getAllTodoList();
		assertEquals(Math.max(count - 1, 0), todoList.size());

	}
}
