package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String DRIVING = "DRIVING";
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case DRIVING:
                return new DrivingTask("Way home", "home", "car");
            case SHOPPING:
                return new ShoppingTask("Groceries", "Corn and Banana", 21d);
            case PAINTING:
                return new PaintingTask("The long rectangle", "white", "long rectangle");
            default:
                return null;
        }
    }
}