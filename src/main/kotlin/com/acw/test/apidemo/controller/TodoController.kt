package com.acw.test.apidemo.controller

import com.acw.test.apidemo.model.Todo
import com.acw.test.apidemo.service.TodoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController;

@RestController
class TodoController (val todoService: TodoService) {
    @GetMapping("/todos")
    fun getTodo() :List<Todo> {
        return todoService.getTodos();
    }
}