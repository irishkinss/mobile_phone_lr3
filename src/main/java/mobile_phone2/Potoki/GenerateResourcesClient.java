package mobile_phone2.Potoki;

public class ClientProducer extends Thread{
    public static final int CLIENTS_DELAY = 5000;
    public final CallCenter callCenter;

    public ClientProducer(CallCenter callCenter) {
        this.callCenter = callCenter;
    }
    //@Override
    public void run() {
        while (true){
            for (int i = 0; i < 3; i++) {
                new Client(callCenter).start();
            }
            try {
                Thread.sleep(CLIENTS_DELAY);
            } catch (InterruptedException e) {
                //throw new RuntimeException(e);
                break;
            }
        }
    }
}
