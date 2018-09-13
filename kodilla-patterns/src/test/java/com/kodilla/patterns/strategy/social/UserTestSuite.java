package com.kodilla.patterns.strategy.social;

import javafx.beans.binding.When;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies(){

       //Given
        User Zbigniew = new Millenials("Zbigniew");
        User Marlena = new XGeneration("Marlena");
        User Swietopelk = new YGeneration("Świętopełk");
        //When
        String zbigniewPublishAt = Zbigniew.socialPublisher.Share();
        System.out.println( Zbigniew.getName() + zbigniewPublishAt);
        String marlenaPublishAt = Marlena.socialPublisher.Share();
        System.out.println(Marlena.getName() + marlenaPublishAt);
        String swietopelkPublishAt = Swietopelk.socialPublisher.Share();
        System.out.println(Swietopelk.getName() + Swietopelk.socialPublisher.Share());
        //Then
        Assert.assertEquals(" publikuje na Facebooku",zbigniewPublishAt);
        Assert.assertEquals( " Tweetuje",marlenaPublishAt);
        Assert.assertEquals(" publikuje na Snapie", swietopelkPublishAt);




    }
    @Test
    public void testIndividualSharingStrategy(){
        //Given
        User Zbigniew = new Millenials("Zbigniew");
       ;
        //When
        Zbigniew.setSocialPublisher(new TwitterPublisher());
        String zbigniewPublishAt = Zbigniew.socialPublisher.Share();
        //Then
        Assert.assertEquals(" Tweetuje", zbigniewPublishAt );

    }
}
