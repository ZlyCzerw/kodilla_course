package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

public class TaskFactoryTestSuite {

    TaskFactory task = new TaskFactory();
    @Test
    public void shopingTaskTest(){
     //Given

     Task spyTask = Mockito.spy(ShoppingTask.class);
     //When
        Task shopping = task.makeTask(TaskFactory.SHOPPING);
        shopping.executeTask();
        spyTask.executeTask();


     //Then
        Assert.assertEquals(true,spyTask.isTaskExecuted());
        Assert.assertEquals(true,shopping.isTaskExecuted());


    }
    @Test
    public void paintingTaskTest(){
        //Given

        //When
        Task painting =  task.makeTask(TaskFactory.PAINTING);
        painting.executeTask();

        //Then
        Assert.assertEquals(true,painting.isTaskExecuted());
        Assert.assertEquals("white",painting.getTaskName());

    }
    @Test
    public void drivingTaskTest(){
        //Given

        //When
        Task driving = task.makeTask(TaskFactory.DRIVING);
        driving.executeTask();

        //Then
        Assert.assertEquals(true,driving.isTaskExecuted());
        Assert.assertEquals("home",driving.getTaskName());

    }
}
