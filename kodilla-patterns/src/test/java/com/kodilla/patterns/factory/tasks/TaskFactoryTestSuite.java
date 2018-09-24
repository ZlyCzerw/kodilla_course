package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

public class TaskFactoryTestSuite {

    @Test
    public void shopingTaskTest(){
     //Given
     TaskFactory shopingTask = new TaskFactory();
     Task spyTask = Mockito.spy(ShoppingTask.class);
     //When
        Task shopping = shopingTask.makeTask(TaskFactory.SHOPPING);
        shopping.executeTask();
        spyTask.executeTask();


     //Then
        Assert.assertEquals(true,spyTask.isTaskExecuted());
        Assert.assertEquals(true,shopping.isTaskExecuted());


    }
    @Test
    public void paintingTaskTest(){
        //Given
        TaskFactory task = new TaskFactory();
        //Whendr
        Task painting =  task.makeTask(TaskFactory.PAINTING);
        painting.executeTask();

        //Then
        Assert.assertEquals(true,painting.isTaskExecuted());
        Assert.assertEquals("white",painting.getTaskName());

    }
    @Test
    public void drivingTaskTest(){
        //Given
        TaskFactory drivingTask = new TaskFactory();
        //When
        Task driving = drivingTask.makeTask(TaskFactory.DRIVING);
        driving.executeTask();

        //Then
        Assert.assertEquals(true,driving.isTaskExecuted());
        Assert.assertEquals("home",driving.getTaskName());

    }
}
