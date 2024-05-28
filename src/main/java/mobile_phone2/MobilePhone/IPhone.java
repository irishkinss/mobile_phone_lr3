package mobile_phone2.MobilePhone;

public interface IPhone {
    void call();// позвонить
    void answer();// ответить
    void endCall();// завершить звонок
    void upBalance(double amount);
    void printInfo();
}
