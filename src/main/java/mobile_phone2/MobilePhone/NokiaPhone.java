package mobile_phone2.MobilePhone;

public class NokiaPhone implements IPhone{
    private String number;
    private double balance;
    private double callProbability;
    private IPhoneState state;
    private final String brand = "Nokia";

    public NokiaPhone(String number, double balance, double callProbability, IPhoneState state) {
        this.number = number;
        this.balance = balance;
        this.callProbability = callProbability;
        this.state = state;
    }

    @Override
    public void call() {
        this.state.call();
    }

    @Override
    public void answer() {
        this.state.answer();
    }

    @Override
    public void endCall() {
        this.state.endCall();
    }

    @Override
    public void upBalance(double amount) {
        this.balance += amount;
        if (balance >= 0 && state instanceof BlockedState) {
            state = new WaitingState();
        }
    }
    public void printInfo(){
        System.out.println("Номер телефона: " + this.number);
        System.out.println("Вероятность звонка: " + this.callProbability);
        System.out.println("Состояние телефона: " + this.state);
        System.out.println("Бренд: " + this.brand);
    }
}
