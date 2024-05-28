package mobile_phone2.Potoki;

import mobile_phone2.MobilePhone.IPhoneState;
import mobile_phone2.MobilePhone.Phone;
import mobile_phone2.MobilePhone.WaitingState;

import java.util.Random;
import java.util.Vector;

public class GenerateResourcesOperators extends Thread{
    private Vector<Operator> operators = new Vector<>();
    private CallCenter callCenter;

    private double balance = 100000000;
    private double callProbability = 1;
    private IPhoneState state = new WaitingState();

    // Массив строк с брендами телефонов
    private static final String[] PHONE_BRANDS = {
            "Nokia",
            "Samsung",
            "iPhone"
    };
    public GenerateResourcesOperators() {
    }

    public Vector<Operator> getOperators() {
        return operators;
    }

    public void setOperators(Vector<Operator> operators) {
        this.operators = operators;
    }

    public CallCenter getCallCenter() {
        return callCenter;
    }

    public void setCallCenter(CallCenter callCenter) {
        this.callCenter = callCenter;
    }

    // Метод для генерации случайного номера телефона
    public static String generatePhoneNumber() {
        Random random = new Random();

        // Сгенерировать первую цифру, она не должна быть нулем
        int firstDigit = random.nextInt(9) + 1;
        StringBuilder phoneNumber = new StringBuilder(String.valueOf(firstDigit));

        // Сгенерировать остальные цифры (10 в общей сложности)
        for (int i = 0; i < 9; i++) {
            phoneNumber.append(random.nextInt(10));
        }

        // Форматировать номер телефона (XXX) XXX-XXXX
        phoneNumber.insert(0, "(").insert(4, ") ").insert(9, "-");

        return phoneNumber.toString();
    }


    // Метод для генерации случайного бренда телефона из предопределенного списка
    public static String generatePhoneBrand() {
        Random random = new Random();

        // Случайным образом выбрать один из брендов телефонов
        return PHONE_BRANDS[random.nextInt(PHONE_BRANDS.length)];
    }
    public void addOperator(Operator operator){
        operators.add(operator);
    }

    public void run(){
        while(true) {
            if (Thread.currentThread().isInterrupted()) {
                break;
            };
            Phone phone = new Phone(generatePhoneNumber(),balance, callProbability, state, generatePhoneBrand());
            Operator operator = new Operator(phone, callCenter);
            addOperator(operator);
        }

    }


}