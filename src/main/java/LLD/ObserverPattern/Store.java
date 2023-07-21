package LLD.ObserverPattern;
import LLD.ObserverPattern.Observable.IphoneObservableImpl;
import LLD.ObserverPattern.Observable.StocksObservable;
import LLD.ObserverPattern.Observer.EmailAlertObserverImpl;
import LLD.ObserverPattern.Observer.NotificationAlertObserver;
import LLD.ObserverPattern.Observer.SmsAlertObserverImpl;

public class Store {
    public static void main(String args[]) {
        StocksObservable iphoneStocksObservable = new IphoneObservableImpl();
        
        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("xyz1@gmail.com", iphoneStocksObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("xyz2@gmail.com", iphoneStocksObservable);
        NotificationAlertObserver observer3 = new SmsAlertObserverImpl("xyz3", iphoneStocksObservable);

        iphoneStocksObservable.add(observer1);
        iphoneStocksObservable.add(observer2);
        iphoneStocksObservable.add(observer3);
        iphoneStocksObservable.setStockCounts(10);
        iphoneStocksObservable.setStockCounts(0);
        iphoneStocksObservable.setStockCounts(100);
    }
}
