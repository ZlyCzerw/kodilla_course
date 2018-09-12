package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.IntStream;

public class LibraryTestSuite {

    @Test
    public void getBooksTest(){
        //given
        Library library = new Library("Original Library");
        IntStream.iterate(1,n->n+1)
                .limit(10)
                .forEach(n-> library.getBooks().add(new Book("title"+n,"author"+n, LocalDate.now())));

        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            shallowClonedLibrary.setName("Shallow Copy Library");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Deep Copy Library");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
     //when
        Set<Book> bookSet1 = library.getBooks();
        Set<Book> bookSet2 = shallowClonedLibrary.getBooks();
        Set<Book> bookSet3 = deepClonedLibrary.getBooks();
        bookSet3.removeIf(book -> book.title.equals("title1"));
        //Then
        Assert.assertEquals(bookSet1,bookSet2);
        Assert.assertNotEquals(bookSet1,bookSet3);
    }
}
