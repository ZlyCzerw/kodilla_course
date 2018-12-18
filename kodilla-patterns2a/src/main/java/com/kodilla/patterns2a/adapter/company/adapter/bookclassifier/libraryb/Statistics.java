package com.kodilla.patterns2a.adapter.company.adapter.bookclassifier.libraryb;

import java.util.Arrays;
import java.util.Map;

public class Statistics implements BookStatistics {
    @Override
    public int avaragePublicationYear(Map<BookSignature, Book> bookMap) {
        if (bookMap.size() == 0){
            return 0;
        }
        int sum = 0;
        for (Map.Entry<BookSignature, Book> entry: bookMap.entrySet()){
            sum += entry.getValue().getPublicationYear();
        }
        return sum/bookMap.size();
    }

    @Override
    public int medianPublicationYear(Map<BookSignature, Book> bookMap) {
        if (bookMap.size() == 0) {
            return 0;
        }
        int[] years = new int[bookMap.size()];
        int n = 0;
        for (Map.Entry<BookSignature, Book> entry : bookMap.entrySet()) {
            years[n] = entry.getValue().getPublicationYear();
            n++;
        }
        Arrays.sort(years);
        if (years.length % 2 == 0) {
            return years[(int) (years.length / 2 + 0.5)];
        } else {
            return years[years.length / 2];
        }
    }
}
