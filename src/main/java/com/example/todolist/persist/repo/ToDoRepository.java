package com.example.todolist.persist.repo;

import com.example.todolist.persist.entity.ToDo;
import com.example.todolist.repr.ToDoRepr;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long> {

    @Query("select new com.example.todolist.repr.ToDoRepr(t) from ToDo t " +
            "where t.user.id = :userId")
    List<ToDoRepr> findToDoByUserId(@Param("userId") Long userId);
}
