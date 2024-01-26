package LLD.SOLID.DI;

public class SMSNotifier {

    public SMSProvider smsProvider;
    
    void SMSNotifier(SMSProvider smsProvider){
        this.smsProvider = smsProvider;
    }

    void sendSMS(String recipient, String message){
        smsProvider.sendSMS(recipient, message);
    }
}
