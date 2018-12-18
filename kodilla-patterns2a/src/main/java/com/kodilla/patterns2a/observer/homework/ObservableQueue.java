package com.kodilla.patterns2a.observer.homework;

public interface ObservableQueue {

    void registerObserver(ObserverQueue observer);
    void notifyObservers();
    void removeObserver(ObserverQueue observer);
}