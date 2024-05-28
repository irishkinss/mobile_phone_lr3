package mobile_phone2.MobilePhone;

import java.util.Objects;

public class Phone implements IPhone{
    private String number;
    private double balance;
    private double callProbability;
    private IPhoneState state;
    private String brand;

    public Phone() {
    }

    public Phone(String number, double balance, double callProbability, IPhoneState state, String brand) {
        this.number = number;
        this.balance = balance;
        this.callProbability = callProbability;
        this.state = state;
        this.brand = brand;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCallProbability() {
        return callProbability;
    }

    public void setCallProbability(double callProbability) {
        this.callProbability = callProbability;
    }

    public IPhoneState getState() {
        return this.state;
    }

    public void setState(IPhoneState state) {
        this.state = state;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Double.compare(balance, phone.balance) == 0 && Double.compare(callProbability, phone.callProbability) == 0 && Objects.equals(number, phone.number) && Objects.equals(state, phone.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, balance, callProbability, state);
    }


//--------------------------Действия с телефоном через состояния--------------------------------------
    public void call(){ //позвонить
        this.state.call();
    } //позвонить
    public void answer(){ //позвонить
        this.state.answer();
    } //ответить на звонок
    public void endCall(){ //позвонить
        this.state.endCall();
    } // завершить звонок
    public void upBalance(double amount){
        this.balance += amount;
        if (balance >= 0 && state instanceof BlockedState) {
            state = new WaitingState(this);
        }
    }

    @Override
    public void printInfo() {
        System.out.println("Номер телефона: " + this.number);
        System.out.println("Вероятность звонка: " + this.callProbability);
        System.out.println("Баланс: " + this.balance);
        System.out.println("Состояние телефона: " + this.state);
        System.out.println("Бренд: " + this.brand);
    }

    public Phone clone(){
        Phone phone = new Phone();
        phone.state = this.state;
        phone.callProbability = this.callProbability;
        phone.balance =  this.balance;
        phone.number = this.number;
        phone.brand = this.brand;
        return phone;
    }

    public void recovery(PhoneMemento memento){
        this.balance = memento.getBalance();
        this.state = memento.getState();

    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                ", balance=" + balance +
                ", callProbability=" + callProbability +
                ", state=" + state +
                ", brand='" + brand + '\'' +
                '}';
    }
}
