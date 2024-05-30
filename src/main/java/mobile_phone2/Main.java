package mobile_phone2;

import mobile_phone2.Potoki.CallCenter;
import mobile_phone2.Potoki.GenerateResourcesClient;
import mobile_phone2.Potoki.GenerateResourcesOperators;
import mobile_phone2.Potoki.Operator;

public class Main {
    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter();
        GenerateResourcesOperators genresop = new GenerateResourcesOperators();
        callCenter.setOperators(genresop.getOperators());
        genresop.setCallCenter(callCenter);
        genresop.run();
        callCenter.WakeUpCallCenter(genresop.getOperators());
        GenerateResourcesClient genresclients = new GenerateResourcesClient(callCenter);
        genresclients.start();

        try {
            Thread.sleep(60000); // Run for 60 seconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        genresclients.interrupt();
        for (Operator operator : genresop.getOperators()) {
            operator.interrupt();
        }
    }
}
