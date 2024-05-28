package mobile_phone2.MobilePhone;
import java.util.Scanner;

public class PhoneProxy implements IPhone{
    private Phone phone;
    private final String password;

    public PhoneProxy(Phone phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    // Метод для проверки пароля
    private boolean authenticate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пароль: ");
        String inputPassword = scanner.nextLine();
        return inputPassword.equals(password);
    }

    @Override
    public void call() {
        if (authenticate()) {
            phone.call();
        } else {
            System.out.println("Доступ запрещен! Неверный пароль.");
        }
    }

    @Override
    public void answer() {
        if (authenticate()) {
            phone.answer();
        } else {
            System.out.println("Доступ запрещен! Неверный пароль.");
        }
    }

    @Override
    public void endCall() {
        if (authenticate()) {
            phone.endCall();
        } else {
            System.out.println("Доступ запрещен! Неверный пароль.");
        }
    }

    @Override
    public void upBalance(double amount) {
        if (authenticate()) {
            phone.upBalance(amount);
        } else {
            System.out.println("Доступ запрещен! Неверный пароль.");
        }
    }

    @Override
    public void printInfo() {
        if (authenticate()) {
            System.out.println("Номер телефона: " + phone.getNumber());
            System.out.println("Вероятность звонка: " + phone.getCallProbability());
            System.out.println("Баланс: " + phone.getBalance());
            System.out.println("Состояние телефона: " + phone.getState());
            System.out.println("Бренд: " + phone.getBrand());
        } else {
            System.out.println("Доступ запрещен! Неверный пароль.");
        }

    }

}
