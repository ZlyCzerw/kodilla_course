package com.kodilla.spring.forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class ForumUser {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public ForumUser() {
        userName = "John Smith";
    }
}
