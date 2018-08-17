package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

import static java.lang.Character.toUpperCase;

public class StreamMain {
    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");
        SaySomething saySomething = new SaySomething();
        saySomething.say();

        Processor processor = new Processor();

        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor.execute(executeSaySomething);

        Executor codeToExecute = () -> System.out.println("example of lambda");
        processor.execute(codeToExecute);

        System.out.println("Calculating expressions with lambdas");
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        expressionExecutor.executeExpression(10,20, (a,b) -> a + b );
        expressionExecutor.executeExpression(154,0,(a,b) -> a/b);
        expressionExecutor.executeExpression(0, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 0.8, (a, b) -> a * b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(10, 20, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(154, 0, FunctionalCalculator::divideAByB);
        expressionExecutor.executeExpression(0, 5, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(10, 0.8, FunctionalCalculator::multiplyAByB);

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.Beautify("The poem is so pretty, lambda makes my day shitty" ,(s) -> s.toUpperCase() );
        poemBeautifier.Beautify("The poem is so pretty, lambda makes my day shitty" ,(s) -> s + "Lambda rhymes with nothing, gonna go and eat my muffin" );
        poemBeautifier.Beautify("The poem is so pretty, lambda makes my day shitty" ,(s) -> s.toLowerCase() );
        poemBeautifier.Beautify("The poem is so pretty, lambda makes my day shitty" ,(s) ->  s.concat("  lalala ") + "Lambda rhymes with nothing, i hear my brain cracking ");

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(40);
    }
}