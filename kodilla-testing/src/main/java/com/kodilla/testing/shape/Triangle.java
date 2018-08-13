package com.kodilla.testing.shape;

import java.util.Objects;

public class Triangle implements Shape {

    double h;
    double a;


    public Triangle(double h, double a) {
        this.h = h;
        this.a = a;
    }

    @Override
    public String getShapeName() {
        String shapeName = "drawing a Triangle";
        return shapeName;
    }

    @Override
    public double getField() {
       double field = (a/2)*h;

        return field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.h, h) == 0 &&
                Double.compare(triangle.a, a) == 0 ;
    }

    @Override
    public int hashCode() {

        return Objects.hash(h, a);
    }
}
