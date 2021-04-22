package com.example.todolist.repr;

import com.example.todolist.persist.entity.ToDo;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ToDoRepr {

    private Long id;

    @NotEmpty
    private String description;

    private String userName;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate targetDate;

    public ToDoRepr() {
    }

    public ToDoRepr(Long id, @NotEmpty String description, String username, @NotNull LocalDate targetDate) {
        this.id = id;
        this.description = description;
        this.userName = username;
        this.targetDate = targetDate;
    }

    public ToDoRepr(ToDo toDo) {
        this.id = toDo.getId();
        this.description = toDo.getDescription();
        this.targetDate = toDo.getTargetDate();
        this.userName = toDo.getUser().getUsername();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }
}
