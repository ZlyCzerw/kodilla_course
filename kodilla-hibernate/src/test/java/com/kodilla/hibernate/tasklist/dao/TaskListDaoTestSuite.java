package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;


    @Test
    public void testFindByListName(){

        //Given

        TaskList taskList = new TaskList("lista1","lista rzeczy ważnych");
        //When
        taskListDao.save(taskList);
        String listName = taskList.getListName();
        //Then
        List<TaskList> list = taskListDao.findByListName(listName);
        String name = list.get(0).getListName();
        Assert.assertEquals(listName,name);
        //CleanUp
        int id = list.get(0).getId();
        taskListDao.delete(id);
    }


}
