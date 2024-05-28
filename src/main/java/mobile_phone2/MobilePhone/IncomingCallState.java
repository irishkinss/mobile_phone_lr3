package mobile_phone2.MobilePhone;

public class IncomingCallState implements IPhoneState{    //входящий звонок
    private Phone phone;

    public IncomingCallState(Phone phone) {
        this.phone = phone;
    }

    @Override
    public void call() {
        System.out.println("Вам уже звонят.");
    }

    @Override
    public void answer() {
        System.out.println("Звонок принят.");
        phone.setState(new InConversationState(phone));
    }

    @Override
    public void endCall() {
        System.out.println("Звонок отклонен.");
        phone.setState(new WaitingState(phone));
    }
}
