package com.kodilla.stream.array;

import java.util.Arrays;

class Array implements ArrayOperations{

    private int[] numbers;

    Array(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array array = (Array) o;
        return Arrays.equals(numbers, array.numbers);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(numbers);
    }

    public int[] getNumbers() {

        return numbers;
    }





}