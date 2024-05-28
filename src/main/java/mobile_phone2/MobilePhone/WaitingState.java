package MobilePhone;

public class WaitingState implements IPhoneState{ //ожидание
    private Phone phone;

    public WaitingState(Phone phone) {
        this.phone = phone;
    }

    public WaitingState() {
    }

    @Override
    public void call() {
        double random = Math.random(); //ранодом возвращает случайное число 0 до 1
        if (random < phone.getCallProbability()) {
            System.out.println("Входящий звонок...");
            phone.setState(new IncomingCallState(phone));
        } else {
            System.out.println("Пропущенный звонок.");
        }
    }

    @Override
    public void answer() {
        System.out.println("Нет входящего звонка.");
    }

    @Override
    public void endCall() {
        System.out.println("Нет активного разговора.");
    }
}
