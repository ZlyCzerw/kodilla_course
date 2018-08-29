package com.kodilla.exception.nullpointer;

public class NullPointerExceptionRunner {
    public static void main(String[] args) {
        User user = new User("boguś");

        MessageSender messageSender = new MessageSender();
        try {
            messageSender.sendMessageTo(user, "Hello!");
        }catch (MessageNotSentException mns){
            System.out.println("nastąpiło wyjątek");
        }

    }
}