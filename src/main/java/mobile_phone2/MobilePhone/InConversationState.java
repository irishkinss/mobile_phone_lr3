package MobilePhone;

public class InConversationState implements IPhoneState{ // в разговоре
    private Phone phone;

    public InConversationState(Phone phone) {
        this.phone = phone;
    }

    @Override
    public void call() {
        System.out.println("Вы уже в разговоре.");
    }

    @Override
    public void answer() {
        System.out.println("Вы уже в разговоре.");
    }

    @Override
    public void endCall() {
        System.out.println("Разговор завершен.");
        phone.setState(new WaitingState(phone));
    }
}
