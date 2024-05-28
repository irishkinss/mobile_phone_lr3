package mobile_phone2.Potoki;

public class Client extends Thread{
    final CallCenter callCenter;
   // private int id;

    public Client(CallCenter callCenter) {
        this.callCenter = callCenter;
    }
    @Override
    public void run() {
        callCenter.clientArrived(this);
    }

}
