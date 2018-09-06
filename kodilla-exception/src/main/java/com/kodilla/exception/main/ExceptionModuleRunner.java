package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import com.kodilla.exception.io.FileReaderWithoutHandling;
import com.kodilla.exception.test.ExceptionHandling;
import com.kodilla.exception.test.FirstChallenge;
import com.kodilla.exception.test.SecondChallenge;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExceptionModuleRunner extends ExceptionHandling {
    public static void main(String args[]){
        FileReader fileReader = new FileReader();
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            secondChallenge.probablyIWillThrowException(2,1);
        } catch ( ExceptionHandling eh ){
            eh.handling();
            }
        }











}
