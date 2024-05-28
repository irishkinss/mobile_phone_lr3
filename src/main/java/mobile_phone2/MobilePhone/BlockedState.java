package mobile_phone2.MobilePhone;

public class BlockedState implements IPhoneState{   //заблокирован
        private Phone phone;

    public BlockedState() {
    }

    public BlockedState(Phone phone) {
        this.phone = phone;
    }

    @Override
        public void call() {
            System.out.println("Телефон заблокирован.");
        }

        @Override
        public void answer() {
            System.out.println("Телефон заблокирован.");
        }

        @Override
        public void endCall() {
            System.out.println("Телефон заблокирован.");
        }

}
