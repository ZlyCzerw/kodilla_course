package com.kodilla.testing.forum.statistics;

public class CalculateStatistics {

    public int getUsersNo() {
        return usersNo;
    }

    public int getPoststNo() {
        return poststNo;
    }

    public int getCommentsNo() {
        return commentsNo;
    }

    public double getPostsPerUser() {
        return postsPerUser;
    }

    public double getCommentsPerUser() {
        return commentsPerUser;
    }

    public double getCommentsPerPost() {
        return commentsPerPost;
    }

    Statistics statistics;

    public CalculateStatistics(Statistics statistics){
        this.statistics = statistics;
    }
    private int usersNo =0;
    private int poststNo;
    private int commentsNo;
    private double postsPerUser;
    private double commentsPerUser;
    private double commentsPerPost;

    public void CalculateAdvStatistics (Statistics statistics) {


        for (String userName: statistics.usersNames()){
            usersNo ++;
        }

        poststNo = statistics.postsCount();

        commentsNo=statistics.commentsCount();
        if(usersNo!=0) {
            postsPerUser = poststNo / usersNo;
            commentsPerUser = commentsNo / usersNo;
        } else {

            System.out.println("liczba userów wynosi zero, statystyka to kłamstwo");
        }

        if (poststNo!=0){
            commentsPerPost = commentsNo / poststNo;
        }else {

            System.out.println("nikt jeszcze nie postował");
        }


    }
    public void ShowStatistics(){
        System.out.println("number of users" + usersNo );
        System.out.println("number of posts" + poststNo);
        System.out.println("number of comments" + commentsNo);
        System.out.println("posts per user" + postsPerUser);
        System.out.println("comments per user" + commentsPerUser);
        System.out.println("comments per post" +commentsPerPost);
    }

}
