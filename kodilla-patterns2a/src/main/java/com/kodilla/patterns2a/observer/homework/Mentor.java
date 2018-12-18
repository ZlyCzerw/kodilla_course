package com.kodilla.patterns2a.observer.homework;

public class Mentor implements ObserverQueue {

    private final String name;
    private int updateCount;


    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(TaskQueue queue) {
        System.out.println(name + " : New task in queue " + queue.getQueueName() + "\n" + " total: " + queue.getUserTasks().size() + " tasks");
        updateCount++;

    }

    public String getName() {
        return name;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
