package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

public class BoardTestSuite {

    @Test
    public void testTaskAdd(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        TaskList taskList1 = board.getToDoList();
        taskList1.TaskList().add("aaa");
        System.out.println(taskList1);
        TaskList taskList2 = board.getDoneList();
        taskList2.TaskList().add("bbb");
        System.out.println(taskList1);
        TaskList taskList3 = board.getInProgressList();
        taskList3.TaskList().add("ccc");
        System.out.println(taskList1);
        //Then
        Assert.assertTrue(taskList1.TaskList().contains("aaa"));
    }
}
