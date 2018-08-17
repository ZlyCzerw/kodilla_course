package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Character.toUpperCase;

public class StreamMain {
    public static void main(String[] args) {




        Forum forum = new Forum();

        Map<Integer,ForumUser> mapOfForumUsers = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex()=='M')
                .filter(forumUser -> forumUser.getBirthDate().isBefore(LocalDate.of(1998,12,31)))
                .filter((forumUser -> forumUser.getPostNo()>0))
                .collect(Collectors.toMap(ForumUser::getUniqeId,forumUser -> forumUser));

        mapOfForumUsers.entrySet().stream()
                .map(entry -> entry.getKey()+ ": "+ entry.getValue())
                .forEach(System.out::println);


 /*       System.out.println("Welcome to module 7 - Stream");
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

        People.getList().stream()
                .map(s -> s.toUpperCase())
                .filter(s -> s.length()>11)
                .map(s -> s.substring(0,s.indexOf(" ")+2)+".")
                .filter(s -> s.substring(0,1).equals("M"))
                .forEach(System.out::println);

        BookDirectory theBookDirectory = new BookDirectory();
        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

        */
        /*
        BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n ","<<",">>"));

        System.out.println(theResultStringOfBooks);
        */
    }
}





