package mobile_phone2;

import mobile_phone2.Potoki.CallCenter;
import mobile_phone2.Potoki.ClientProducer;

public class Main {
    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter();
        ClientProducer work = new ClientProducer(callCenter);
        work.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        work.interrupt();
    }
}
