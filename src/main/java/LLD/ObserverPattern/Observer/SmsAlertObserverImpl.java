package LLD.ObserverPattern.Observer;

import LLD.ObserverPattern.Observable.StocksObservable;

public class SmsAlertObserverImpl implements NotificationAlertObserver{
    String username;
    StocksObservable observable;

    //Constructor Injection
    public SmsAlertObserverImpl(String username, StocksObservable observable) {
        this.username = username;
        this.observable = observable;
    }
    @Override
    public void update() {
        sendMsg(username, "product is in stock hurry up");
    }
    private void sendMsg(String user, String msg) {
        System.out.println("sms sent to user: " + user);
    }
    
}
