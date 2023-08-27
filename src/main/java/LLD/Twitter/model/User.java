package LLD.Twitter.model;

import java.util.HashSet;
import java.util.Set;

public class User {
    public int id;
    public Set<Integer> followed;
    public Tweet tweet_head;

    public User(int id){
        this.id = id;
        followed = new HashSet<>();
        follow(id);
        tweet_head = null;
    }

    public void follow(int id){
        followed.add(id);
    }

    public void unfollow(int id){
        followed.remove(id);
    }

    public void post(int id){
        Tweet t = new Tweet(id);
        t.next_tweet = tweet_head;
        tweet_head = t;
    }
}
