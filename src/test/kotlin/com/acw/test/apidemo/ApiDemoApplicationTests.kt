package com.acw.test.apidemo

import com.acw.test.apidemo.model.Todo
import com.acw.test.apidemo.service.TodoService
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.junit.jupiter.api.Assertions.assertEquals

@SpringBootTest
class ApiDemoApplicationTests {

	private val todoService: TodoService = TodoService();

	@Test
	fun contextLoads() {
	}

	@Test
	fun `test getting list of todos`() {
		val expectedTodos = listOf(Todo("1", "Create base service", "Alex CW", "base service with all the base parts"));
		val todosReturned = todoService.getTodos();
		assertEquals(todosReturned, expectedTodos)
	}

}
