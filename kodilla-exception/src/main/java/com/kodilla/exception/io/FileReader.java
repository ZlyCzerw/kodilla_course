package com.kodilla.exception.io;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {
    public void readFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("files/names.txt").getFile());
        System.out.println(file.getPath());
      //  Path path = Paths.get(file.getPath());
        //Path path = Paths.get("wrong path");
        try (Stream<String> fileLines = Files.lines(Paths.get(file.getPath()))){
            fileLines.forEach(System.out::println);
        }catch (IOException exception){
            System.out.println("nie tym razem. wystąpił wyjątek: "+exception);
        } finally {
            System.out.println("co tam sobie oglądasz?");
        }


    }
}
