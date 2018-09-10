package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Board {

    private final TaskList toDoList;
    private final TaskList doneList;
    private final TaskList inProgressList;

    public Board(TaskList toDoList, TaskList doneList, TaskList inProgressList) {
    this.toDoList = toDoList;
    this.doneList = doneList;
    this.inProgressList = inProgressList;
    }

    public TaskList getToDoList() {
        return toDoList;
    }

    public TaskList getDoneList() {
        return doneList;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }
}
