package LLD.Twitter.controller;

import java.util.Scanner;

import LLD.Twitter.service.TwitterService;

public class Twitter {
    public static void main(String args[]) {
        TwitterService twitterService = new TwitterService();
        final String POST = "post";
        final String GET_NEWS_FEED = "getNewsFeed";
        final String FOLLOW = "follow";
        final String UNFOLLOW = "unfollow";
        final String EXIT = "exit";

        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Command: ");
            String cmd = sc.next();
            switch(cmd) {
                case POST: 
                    twitterService.postTweet(sc.nextInt(), sc.nextInt());
                    break;
                case GET_NEWS_FEED:
                    twitterService.getNewsFeed(sc.nextInt());
                    break;  
                case FOLLOW:
                    twitterService.follow(sc.nextInt(), sc.nextInt());
                    break;
                case UNFOLLOW:
                    twitterService.unfollow(sc.nextInt(), sc.nextInt());
                    break;  
                case EXIT: return;  
            }
        }
    }
}
