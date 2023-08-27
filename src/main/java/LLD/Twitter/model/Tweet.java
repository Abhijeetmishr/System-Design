package LLD.Twitter.model;

public class Tweet {
    public int id;
    public int timeStamp = 0;
    public Tweet next_tweet;

    public Tweet(int id){
        this.id = id;
        timeStamp++;
        next_tweet = null; 
    }
}
