package com.kodilla.testing.shape;


import java.util.Objects;

public class Circle implements Shape{

    double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public String getShapeName() {
        String shapeName = "drawing a Circle";
        return shapeName;
    }

    @Override
    public double getField() {
        double field = Math.pow(r,2)*Math.PI;
        return field;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.r, r) == 0 ;
    }
    @Override
    public int hashCode() {

        return Objects.hash(r);
    }
}
