package com.kodilla.spring.portfolio;

import com.sun.org.glassfish.gmbal.NameValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    @Autowired
    @Qualifier("toDoList")
    TaskList taskList;

    @Autowired
    @Qualifier("doneList")
    TaskList doneList;

    @Autowired
    @Qualifier("inProgressList")
    TaskList inProgressList;

    @Bean(name = "toDoList")
    public TaskList toDokList(){
        return new TaskList();
    }
    @Bean(name = "doneList")
    public TaskList doneList(){
        return new TaskList();
    }
    @Bean(name = "inProgressList")
    public TaskList inProgressList(){
        return new TaskList();
    }

    @Bean
    public Board board(){
        return new Board();
    }
}
