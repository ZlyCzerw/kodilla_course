package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void Beautify(String s, PoemDecorator poemDecorator){
       String result = poemDecorator.Decorate(s);
        System.out.println(result);

    }
}
