package com.kodilla.testing.shape;

import org.junit.*;

import java.util.ArrayList;

public class ShapeCollectorTestSuite {

    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }
    @After
    public void after(){
        System.out.println("Test Case: end");
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }

    @Test
    public void testAddFigure(){

        //Given
        ArrayList list = new ArrayList();
        ShapeCollector shapeCollector = new ShapeCollector(list);
        Shape shape = new Triangle(1,1);
        //When
        shapeCollector.addFigure(shape);
        //Then
        Assert.assertEquals(1,list.size());
    }
    @Test
    public void testRemoveFigure(){

        //Given
        ArrayList list = new ArrayList();
        Shape shape = new Triangle(1,1);
        list.add(shape);
        ShapeCollector shapeCollector = new ShapeCollector(list);

        //When
        shapeCollector.removeFigure(shape);
        //Then
        Assert.assertEquals(0,list.size());
    }
    @Test
    public void testGetFigure(){
        //Given
        double a=6;
        double h=3;
        double r = 1;
        Shape shape =new Triangle(a,h);
        Shape shape1 = new Square(a);
        Shape shape2 = new Circle(r);
        ArrayList list = new ArrayList();
        list.add(shape);
        list.add(shape1);
        list.add(shape2);
        ShapeCollector shapeCollector = new ShapeCollector(list);
        //When
        Shape wantedfigure = shapeCollector.getFigure(1);
        //Then
         Assert.assertEquals(shape1, wantedfigure);
    }
    @Test
    public void testShowFigures(){
        //Given
        double a=6;
        double h=3;
        double r = 1;
        Shape shape =new Triangle(a,h);
        Shape shape1 = new Square(a);
        Shape shape2 = new Circle(r);
        ArrayList list = new ArrayList();
        list.add(shape);
        list.add(shape1);
        list.add(shape2);
        ShapeCollector shapeCollector = new ShapeCollector(list);
        //When
        ArrayList<Shape> allFigures = shapeCollector.showFigures();
        //Then
        Assert.assertEquals(list, allFigures);
    }
    @Test
    public void testGetShapeName(){
        //Given
        double a=6;
        double h=3;
        double r = 1;
        Shape shape =new Triangle(a,h);
        Shape shape1 = new Square(a);
        Shape shape2 = new Circle(r);
        //When
        String name = shape.getShapeName();
        String name1 = shape1.getShapeName();
        String name2 = shape2.getShapeName();
        //Then
        Assert.assertEquals("drawing a Triangle", name );
        Assert.assertEquals("drawing a Square", name1 );
        Assert.assertEquals("drawing a Circle", name2 );
    }
    @Test
    public void testGetField(){
        //Given
        double a=6;
        double h=3;
        double r = 1;
        Shape shape =new Triangle(a,h);
        Shape shape1 = new Square(a);
        Shape shape2 = new Circle(r);
        //When
        double field = shape.getField();
        double field1  = shape1.getField();
        double field2 = shape2.getField();
        //Then

        Assert.assertEquals(9.0,field,1e-8);
        Assert.assertEquals(36.0, field1,1e-8);
        Assert.assertEquals(Math.PI, field2, 1e-8);
    }
}
