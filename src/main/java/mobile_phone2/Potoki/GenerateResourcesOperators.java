package mobile_phone2.Potoki;

import mobile_phone2.MobilePhone.IPhoneState;
import mobile_phone2.MobilePhone.Phone;
import mobile_phone2.MobilePhone.WaitingState;

import java.util.Random;
import java.util.Vector;

public class GenerateResourcesOperators extends Thread {
    private final Vector<Operator> operators = new Vector<>();
    private CallCenter callCenter;

    private final double balance = 1000000;
    private final double callProbability = 1;
    private final IPhoneState state = new WaitingState();
    private static final String[] PHONE_BRANDS = {"Nokia", "Samsung", "iPhone"};

    public GenerateResourcesOperators() {}

    public Vector<Operator> getOperators() {
        return operators;
    }

    public void setCallCenter(CallCenter callCenter) {
        this.callCenter = callCenter;
    }

    public static String generatePhoneNumber() {
        Random random = new Random();
        int firstDigit = random.nextInt(9) + 1;
        StringBuilder phoneNumber = new StringBuilder(String.valueOf(firstDigit));
        for (int i = 0; i < 9; i++) {
            phoneNumber.append(random.nextInt(10));
        }
        phoneNumber.insert(0, "(").insert(4, ") ").insert(9, "-");
        return phoneNumber.toString();
    }

    public static String generatePhoneBrand() {
        Random random = new Random();
        return PHONE_BRANDS[random.nextInt(PHONE_BRANDS.length)];
    }

    public void addOperator(Operator operator) {
        operators.add(operator);
    }

    public void run() {
        int id = 0;
        for (int i = 0; i < 20; i++) {
            Phone phone = new Phone(generatePhoneNumber(), balance, callProbability, state, generatePhoneBrand());
            Operator operator = new Operator(phone, callCenter, id);
            addOperator(operator);
            id++;
        }
    }
}
