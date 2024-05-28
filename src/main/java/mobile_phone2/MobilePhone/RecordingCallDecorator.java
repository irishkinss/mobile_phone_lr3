package mobile_phone2.MobilePhone;

public class RecordingCallDecorator implements IPhone{
    private Phone phone;
    public RecordingCallDecorator(Phone phone) {
        this.phone = phone;

    }

    public void call(){
        phone.call();
    }


    @Override
    public void answer() {
        phone.answer();
        System.out.println("Запись разговора начата...");
    }

    @Override
    public void endCall() {
        phone.endCall();
        System.out.println("Запись разговора завершена.");
    }

    @Override
    public void upBalance(double amount) {
        phone.upBalance(amount);
    }

    @Override
    public void printInfo() {
        phone.printInfo();
    }
}
