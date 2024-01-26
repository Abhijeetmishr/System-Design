package LLD.SOLID.InterfaceSegregation;

public interface SmsNotification {
    void sendSMS();
    void setRecipient(String phone);
}
