package mobile_phone2.Potoki;

public class ClientsProduce {
    public static final int CLIENTS_DELAY = 5000;
    public final CallCenter callCenter;

    public ClientsProduce(CallCenter callCenter) {
        this.callCenter = callCenter;
    }
    //@Override
    public void run() {
        while (true){
            for (int i = 0; i < 3; i++) {
                new Thread(new Client(callCenter)).start();
            }
            try {
                Thread.sleep(CLIENTS_DELAY);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
