package com.kodilla.patterns.strategy.social;

public class User {
    final private String name;
    SocialPublisher socialPublisher = new SnapchatPublisher();

    public User(String name) {
        this.name = name;
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }

    public String getName() {
        return name;
    }

    public String publish(){
        return socialPublisher.Share();
    }

}
