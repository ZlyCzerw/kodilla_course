package com.kodilla.patterns2a.adapter.company.adapter.bookclassifier;


import com.kodilla.patterns2a.adapter.company.adapter.bookclassifier.librarya.Classifier;
import com.kodilla.patterns2a.adapter.company.adapter.bookclassifier.libraryb.BookSignature;


import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    @Override
    public int publicationYearMedian(Set<com.kodilla.patterns2a.adapter.company.adapter.bookclassifier.librarya.Book> bookSet) {
       Map<BookSignature, com.kodilla.patterns2a.adapter.company.adapter.bookclassifier.libraryb.Book> bookMap = bookSet.stream()
               .collect(Collectors.toMap(
                       b -> new BookSignature(b.getSignature()),
                       b->new com.kodilla.patterns2a.adapter.company.adapter.bookclassifier.libraryb.Book(
                               b.getAuthor(),
                               b.getTitle(),
                               b.getPublicationYear())));

        return medianPublicationYear(bookMap);

    }
}

