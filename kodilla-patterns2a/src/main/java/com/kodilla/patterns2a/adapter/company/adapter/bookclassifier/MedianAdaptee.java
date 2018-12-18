package com.kodilla.patterns2a.adapter.company.adapter.bookclassifier;

import com.kodilla.patterns2a.adapter.company.adapter.bookclassifier.libraryb.Book;
import com.kodilla.patterns2a.adapter.company.adapter.bookclassifier.libraryb.BookSignature;
import com.kodilla.patterns2a.adapter.company.adapter.bookclassifier.libraryb.BookStatistics;
import com.kodilla.patterns2a.adapter.company.adapter.bookclassifier.libraryb.Statistics;

import java.util.Map;

public class MedianAdaptee implements BookStatistics {



    @Override
    public int avaragePublicationYear(Map<BookSignature, Book> bookMap) {
        Statistics statistics = new Statistics();
        return statistics.avaragePublicationYear(bookMap);
    }

    @Override
    public int medianPublicationYear(Map<BookSignature, Book> bookMap) {
        Statistics statistics = new Statistics();
        return statistics.medianPublicationYear(bookMap);
    }
}
