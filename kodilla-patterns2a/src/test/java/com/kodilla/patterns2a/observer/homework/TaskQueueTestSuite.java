package com.kodilla.patterns2a.observer.homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaskQueueTestSuite {

    @Test
    public void testUpdateQueue() {
        //Given
        TaskQueue marysiaQueue = new TaskQueue("Kolejka zadań Marysi");
        TaskQueue janekQueue = new TaskQueue("Kolejka zadań Janka");
        TaskQueue helutQueue = new TaskQueue("Kolejka zadań Helmuta");
        Mentor zbigniew = new Mentor("Zbigniew Stonoga");
        Mentor nieLubiePoniedzialkow = new Mentor("Marek Poniedziałek");
        marysiaQueue.registerObserver(nieLubiePoniedzialkow);
        janekQueue.registerObserver(zbigniew);
        helutQueue.registerObserver(nieLubiePoniedzialkow);
        helutQueue.registerObserver(zbigniew);
        //When
        marysiaQueue.offerToTasks("Siku");
        marysiaQueue.offerToTasks("Miku");
        janekQueue.offerToTasks("Z bagnetem na czołgi");
        helutQueue.offerToTasks("Ales phantastisch");

        //then
        assertEquals(3,nieLubiePoniedzialkow.getUpdateCount());
        assertEquals(2,zbigniew.getUpdateCount());

    }
}