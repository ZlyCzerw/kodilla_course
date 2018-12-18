package com.kodilla.patterns2a.adapter.company.adapter.bookclassifier.libraryb;

import java.util.Map;

public interface BookStatistics {

    int avaragePublicationYear(Map<BookSignature, Book> bookMap);
    int medianPublicationYear(Map<BookSignature, Book> bookMap);
}
