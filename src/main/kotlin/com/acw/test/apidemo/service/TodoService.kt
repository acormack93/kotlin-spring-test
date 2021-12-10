package com.acw.test.apidemo.service

import com.acw.test.apidemo.model.Todo
import org.springframework.stereotype.Service

@Service
class TodoService {
    fun getTodos(): List<Todo> {
        return listOf(Todo("1", "Create base service", "Alex CW", "base service with all the base parts"))
    }
}