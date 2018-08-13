package com.kodilla.testing.shape;

import java.util.Objects;

public class Square implements Shape {

    double a;


    public Square(double a) {
        this.a = a;
    }

    @Override
    public String getShapeName() {
        String shapeName = "drawing a Square";
        return shapeName;
    }

    @Override
    public double getField() {
        double field = Math.pow(a,2);
        return field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.a, a) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(a);
    }
}
