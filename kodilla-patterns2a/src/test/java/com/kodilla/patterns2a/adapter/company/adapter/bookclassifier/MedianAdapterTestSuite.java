package com.kodilla.patterns2a.adapter.company.adapter.bookclassifier;

import com.kodilla.patterns2a.adapter.company.adapter.bookclassifier.librarya.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest(){

        //given
        MedianAdapter adapter = new MedianAdapter();
        Book book1 = new Book("xxx","asd",1990,"oquiery2134");
        Book book2 = new Book("xty","afggd",1933,"oquiery2134");
        Book book3 = new Book("xrsx","34d",1950,"oquiery2134");
        Set<Book>testSet = new HashSet<>();
        testSet.add(book1);
        testSet.add(book2);
        testSet.add(book3);
        //When
        double mediana = adapter.publicationYearMedian(testSet);
        System.out.println(mediana);
        //then
        Assert.assertEquals(1950,mediana,0);
    }
    @Test
    public void publicationYearMedianEvenBooksNumberTest(){

        //given
        MedianAdapter adapter = new MedianAdapter();
        Book book1 = new Book("xxx","asd",1934,"oquiery2134");
        Book book2 = new Book("xty","afggd",1933,"oquiery2134");
        Set<Book>testSet = new HashSet<>();
        testSet.add(book1);
        testSet.add(book2);
        //When
        double mediana = adapter.publicationYearMedian(testSet);
        System.out.println(mediana);
        //then
        Assert.assertEquals(1933.5,mediana,0);

    }

}