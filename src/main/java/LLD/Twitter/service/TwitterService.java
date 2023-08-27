package LLD.Twitter.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import LLD.Twitter.model.Tweet;
import LLD.Twitter.model.User;

public class TwitterService {
    private Map<Integer, User> userMap;

    public TwitterService() {
        userMap = new HashMap<Integer, User>();
    }

    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)) {
            User user = new User(userId);
            userMap.put(userId, user);
        }
        userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        if(!userMap.containsKey(userId)) return res;

        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> q = new PriorityQueue<>(users.size(), (a, b) -> (b.timeStamp - a.timeStamp));
        for(int user: users){
            Tweet t = userMap.get(user).tweet_head;
            if(t!=null){
                q.add(t);
            }
        }
        int n = 0;
        while(!q.isEmpty() && n < 10) {
            Tweet t = q.poll();
            res.add(t.id);
            n++;
            if(t.next_tweet != null) {
                q.add(t.next_tweet);
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)) {
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        if(!userMap.containsKey(followeeId)){
			User u = new User(followeeId);
			userMap.put(followeeId, u);
		}
		userMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || followerId==followeeId)
			return;
		userMap.get(followerId).unfollow(followeeId);
    }
}
