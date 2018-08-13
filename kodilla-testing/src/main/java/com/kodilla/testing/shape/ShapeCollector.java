package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    ArrayList<Shape> shapesList = new ArrayList();

    public ShapeCollector(ArrayList<Shape> shapesList) {
        this.shapesList = shapesList;
    }

    public void addFigure(Shape shape){

        shapesList.add(shape);

    }
    public void removeFigure(Shape shape){

        shapesList.remove(shape);

    }
    public Shape getFigure(int n){

        Shape wantedFigure = shapesList.get(n);
        System.out.println(wantedFigure);
        return wantedFigure;

    }

    public ArrayList<Shape> showFigures(){
        return shapesList;
    }

}
