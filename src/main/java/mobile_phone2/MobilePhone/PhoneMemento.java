package mobile_phone2.MobilePhone;

//Класс снимка, содержащий состояние телефона
public class PhoneMemento {
    private double balance;

    private IPhoneState state;

    public PhoneMemento() {
    }

    public PhoneMemento(String number, double balance, IPhoneState state) {
        this.balance = balance;
        this.state = state;
    }


    public double getBalance() {
        return balance;
    }

    public IPhoneState getState() {
        return state;
    }

    public PhoneMemento createMemento(Phone phone){
        PhoneMemento memento = new PhoneMemento();
        memento.balance = phone.getBalance();
        memento.state = phone.getState();
        return memento;
    }

    @Override
    public String toString() {
        return "PhoneMemento{" +
                "balance=" + balance +
                ", state=" + state +
                '}';
    }
}
