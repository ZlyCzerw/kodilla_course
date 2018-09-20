package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    @Test
    public void shopingTaskTest(){
     //Given
     TaskFactory shopingTask = new TaskFactory();
     //When
        Task shopping = shopingTask.makeTask(TaskFactory.SHOPPING);
        shopping.executeTask();

     //Then
        Assert.assertEquals(true,shopping.isTaskExecuted());
        Assert.assertEquals("Groceries",shopping.getTaskName());

    }
    @Test
    public void paintingTaskTest(){
        //Given
        TaskFactory task = new TaskFactory();
        //Whendr
        PaintingTask painting = (PaintingTask) task.makeTask(TaskFactory.PAINTING);
        painting.executeTask();

        //Then
        Assert.assertEquals(true,painting.isTaskExecuted());
        Assert.assertEquals("white",painting.getColor());

    }
    @Test
    public void drivingTaskTest(){
        //Given
        TaskFactory drivingTask = new TaskFactory();
        //When
        DrivingTask driving = (DrivingTask)drivingTask.makeTask(TaskFactory.DRIVING);
        driving.executeTask();

        //Then
        Assert.assertEquals(true,driving.isTaskExecuted());
        Assert.assertEquals("home",driving.getWhere());

    }
}
