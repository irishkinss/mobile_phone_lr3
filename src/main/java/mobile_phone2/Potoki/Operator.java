package mobile_phone2.Potoki;

import mobile_phone2.MobilePhone.Phone;

public class Operator extends Thread {
    private Phone phone;
    final CallCenter callCenter;
    private final int id;

    public Operator(Phone phone, CallCenter callCenter, int id) {
        this.phone = phone;
        this.callCenter = callCenter;
        this.id = id;
    }

    public int getOperatorId() {
        return id;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (callCenter != null) {
                callCenter.doOperatorWork(this);
            } else {
                System.err.println("CallCenter is null for operator " + id);
                break;
            }
        }
    }
}
