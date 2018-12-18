package com.kodilla.patterns2a.observer.forum;

import org.junit.Test;

import static org.junit.Assert.*;

public class ForumUserTestSuite {

    @Test
    public void testUpdate(){
        //given
        ForumTopic javaHelp = new JavaHelpForumTopic();
        ForumTopic javaTools = new JavaToolsForumTopic();
        ForumUser johnSmith = new ForumUser("John Smith");
        ForumUser annaDownes = new ForumUser("Anna Downes");
        ForumUser arthurCallahan = new ForumUser("Arthur Callahan");
        javaHelp.registerObserver(johnSmith);
        javaTools.registerObserver(annaDownes);
        javaHelp.registerObserver(arthurCallahan);
        javaTools.registerObserver(arthurCallahan);
        //when
        javaHelp.addPost("Sun is shining");
        javaHelp.addPost("the weather is sweet");
        javaHelp.addPost("makes you wanna move");
        javaTools.addPost("And dance with me");
        javaTools.addPost("to the resque");
        //then
        assertEquals(5, arthurCallahan.getUpdateCount());
        assertEquals(3,johnSmith.getUpdateCount());
        assertEquals(2,annaDownes.getUpdateCount());
    }

}