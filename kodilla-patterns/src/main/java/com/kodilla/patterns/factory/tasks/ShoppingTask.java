package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {

    private String taskName;
    private String whatToBuy;
    private double quantity;
    private int executed = 0;

    public ShoppingTask() {
    }

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    public String getWhatToBuy() {
        return whatToBuy;
    }

    public double getQuantity() {
        return quantity;
    }

    @Override
    public void executeTask() {
        executed++;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        if (executed != 0) {
            return true;
        } else {
            return false;
        }
    }
}
