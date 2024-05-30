package mobile_phone2.Potoki;

import java.util.Vector;

public class GenerateResourcesClient extends Thread {
    public static final int CLIENTS_DELAY = 500;
    public final CallCenter callCenter;


    public GenerateResourcesClient(CallCenter callCenter) {
        this.callCenter = callCenter;
    }

    @Override
    public void run() {
        int id = 0;
        while (!Thread.currentThread().isInterrupted()) {
                    new Client(callCenter, id++).start();
            try {
                Thread.sleep(CLIENTS_DELAY);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}