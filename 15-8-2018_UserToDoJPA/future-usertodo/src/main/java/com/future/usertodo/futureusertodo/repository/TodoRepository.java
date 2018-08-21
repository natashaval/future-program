package com.future.usertodo.futureusertodo.repository;

import com.future.usertodo.futureusertodo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
    List<Todo> findByTodoId(Long todoId);
}
