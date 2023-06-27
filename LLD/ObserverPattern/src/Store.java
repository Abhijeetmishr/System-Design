import Observable.IphoneObservableImpl;
import Observable.StocksObservable;
import Observer.EmailAlertObserverImpl;
import Observer.NotificationAlertObserver;
import Observer.SmsAlertObserverImpl;

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
