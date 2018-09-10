package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;

public class Board {

   @Autowired
    private TaskList toDoList;
   @Autowired
    private TaskList doneList;
   @Autowired
    private TaskList inProgressList;

    public Board() {
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
