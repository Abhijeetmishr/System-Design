package LLD.ObserverPattern.Observable;

import LLD.ObserverPattern.Observer.NotificationAlertObserver;

public interface StocksObservable {
    public void add(NotificationAlertObserver observer);
    public void remove(NotificationAlertObserver observer);
    public void notifySubscribers();
    public void setStockCounts(int newStockAdded);
    public int getStockCount();
}