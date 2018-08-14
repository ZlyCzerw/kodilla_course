package com.kodilla.testing.forum.statisics;

import com.kodilla.testing.forum.statistics.CalculateStatistics;
import com.kodilla.testing.forum.statistics.Statistics;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculateStatisticsTestSuite {

    @Test
    public void testCalculateAdvStaisticsWithMockAllZeros(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        List<String> usersNames = new ArrayList<>();

        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.postsCount()).thenReturn(0);

        //When
        calculateStatistics.CalculateAdvStatistics(statisticsMock);
        calculateStatistics.ShowStatistics();
        //Then
        Assert.assertEquals(0,calculateStatistics.getCommentsPerUser(), 1e-8);
        Assert.assertEquals(0,calculateStatistics.getCommentsPerPost(),1e-8);
        Assert.assertEquals(0,calculateStatistics.getPostsPerUser(),1e-8);
    }
    @Test
    public void testCalculateAdvStaisticsWithMockHundredUsers(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        List<String> usersNames = new ArrayList<>();
        for (int i = 0; i<100; i++){
            usersNames.add("name");
        }
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.postsCount()).thenReturn(0);

        //When
        calculateStatistics.CalculateAdvStatistics(statisticsMock);
        calculateStatistics.ShowStatistics();
        //Then
        Assert.assertEquals(0,calculateStatistics.getCommentsPerUser(), 1e-8);
        Assert.assertEquals(0,calculateStatistics.getCommentsPerPost(),1e-8);
        Assert.assertEquals(0,calculateStatistics.getPostsPerUser(),1e-8);
    }

    @Test
    public void testCalculateAdvStaisticsWithMockHundredUsers5000commentsLess1000Posts(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        List<String> usersNames = new ArrayList<>();
        for (int i = 0; i<100; i++){
            usersNames.add("name");
        }
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.commentsCount()).thenReturn(5000);
        when(statisticsMock.postsCount()).thenReturn(1000);

        //When
        calculateStatistics.CalculateAdvStatistics(statisticsMock);
        calculateStatistics.ShowStatistics();
        //Then
        Assert.assertEquals(50,calculateStatistics.getCommentsPerUser(), 1e-8);
        Assert.assertEquals(5,calculateStatistics.getCommentsPerPost(),1e-8);
        Assert.assertEquals(10,calculateStatistics.getPostsPerUser(),1e-8);
    }
    @Test
    public void testCalculateAdvStaisticsWithMockHundredUsers0comments1000Posts(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        List<String> usersNames = new ArrayList<>();
        for (int i = 0; i<100; i++){
            usersNames.add("name");
        }
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.postsCount()).thenReturn(1000);

        //When
        calculateStatistics.CalculateAdvStatistics(statisticsMock);
        calculateStatistics.ShowStatistics();
        //Then
        Assert.assertEquals(0,calculateStatistics.getCommentsPerUser(), 1e-8);
        Assert.assertEquals(0,calculateStatistics.getCommentsPerPost(),1e-8);
        Assert.assertEquals(10,calculateStatistics.getPostsPerUser(),1e-8);
    }
    @Test
    public void testCalculateAdvStaisticsWithMockHundredUsersLessCommentsTheanPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        List<String> usersNames = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            usersNames.add("name");
        }
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.commentsCount()).thenReturn(1000);
        when(statisticsMock.postsCount()).thenReturn(2000);

        //When
        calculateStatistics.CalculateAdvStatistics(statisticsMock);
        calculateStatistics.ShowStatistics();
        //Then
        Assert.assertEquals(10, calculateStatistics.getCommentsPerUser(), 1e-8);
        Assert.assertEquals(0.5,calculateStatistics.getCommentsPerPost(),0.0001);
        Assert.assertEquals(20, calculateStatistics.getPostsPerUser(), 1e-8);
    }
    @Test
    public void testCalculateAdvStaisticsWithMockHundredUsersNoPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        List<String> usersNames = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            usersNames.add("name");
        }
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.commentsCount()).thenReturn(100);
        when(statisticsMock.postsCount()).thenReturn(0);

        //When
        calculateStatistics.CalculateAdvStatistics(statisticsMock);
        calculateStatistics.ShowStatistics();
        //Then
        Assert.assertEquals(1, calculateStatistics.getCommentsPerUser(), 1e-8);
        Assert.assertEquals(0, calculateStatistics.getCommentsPerPost(), 1e-8);
        Assert.assertEquals(0, calculateStatistics.getPostsPerUser(), 1e-8);
    }
    @Test
    public void testCalculateAdvStaisticsWithMock0Users() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        List<String> usersNames = new ArrayList<>();

        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.commentsCount()).thenReturn(1000);
        when(statisticsMock.postsCount()).thenReturn(1000);

        //When
        calculateStatistics.CalculateAdvStatistics(statisticsMock);
        calculateStatistics.ShowStatistics();
        //Then
        Assert.assertEquals(0, calculateStatistics.getCommentsPerUser(), 1e-8);
        Assert.assertEquals(1, calculateStatistics.getCommentsPerPost(), 1e-8);
        Assert.assertEquals(0, calculateStatistics.getPostsPerUser(), 1e-8);
    }
}
