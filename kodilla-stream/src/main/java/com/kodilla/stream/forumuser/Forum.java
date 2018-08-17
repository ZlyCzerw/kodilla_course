package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> listOfUsers = new ArrayList<>();

    public Forum(){

        listOfUsers.add(new ForumUser(100,"Marian",'M',LocalDate.of(1995,02,15),11));
        listOfUsers.add(new ForumUser(101,"Szczepan",'M',LocalDate.of(2000,02,15),99));
        listOfUsers.add(new ForumUser(102,"Joanna",'K',LocalDate.of(1998,02,15),2));
        listOfUsers.add(new ForumUser(103,"Marianna",'K',LocalDate.of(1999,01,01),1));
        listOfUsers.add(new ForumUser(104,"Krzysztof",'M',LocalDate.of(1998,12,30),1));
        listOfUsers.add(new ForumUser(105,"Marian",'M',LocalDate.of(2012,02,15),4));
        listOfUsers.add(new ForumUser(106,"Marcin",'M',LocalDate.of(1900,02,15),0));

    }


    public List<ForumUser> getUserList() {
        return listOfUsers;
    }
}
