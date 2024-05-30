package mobile_phone2.Potoki;

public class Client extends Thread {
    final CallCenter callCenter;
    private int id;

    @Override
    public long getId() {
        return id;
    }

    public Client(CallCenter callCenter, int id) {
        this.callCenter = callCenter;
        this.id = id;
    }

    @Override
    public void run() {
        callCenter.addClient(this);
    }
}
