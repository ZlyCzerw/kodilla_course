package com.kodilla.patterns2a.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TaskQueue implements ObservableQueue {

    private final Deque<String> userTasks;
    private final List<ObserverQueue> observers;
    private final String queueName;

    public TaskQueue(String queueName) {
      userTasks = new ArrayDeque<>();
      observers = new ArrayList<>();
        this.queueName = queueName;
    }

    public void offerToTasks(String task){
        userTasks.offer(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(ObserverQueue observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(ObserverQueue observer: observers){
            observer.update(this);

        }
    }

    @Override
    public void removeObserver(ObserverQueue observer) {
        observers.remove(observer);
    }

    public Deque<String> getUserTasks() {
        return userTasks;
    }

    public List<ObserverQueue> getObservers() {
        return observers;
    }

    public String getQueueName() {
        return queueName;
    }
}
