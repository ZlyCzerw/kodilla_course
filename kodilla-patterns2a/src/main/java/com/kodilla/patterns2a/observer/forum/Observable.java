package com.kodilla.patterns2a.observer.forum;

public interface Observable {

    void registerObserver(Observer observer);
    void notifyObservers();
    void removeObserver(Observer observer);
}
