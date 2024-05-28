package MobilePhone;

// Фабрика для создания телефонов разных брендов
public class PhoneFactory {
    public static IPhone createPhone(String brand, String number, double balance, double callProbability, IPhoneState state) {
        switch (brand.toLowerCase()) {
            case "nokia":
                return new NokiaPhone(number, balance, callProbability, new WaitingState());
            case "samsung":
                return new SamsungPhone(number, balance, callProbability, new WaitingState());
            case "iphone":
                return new IPhonePhone(number, balance, callProbability, new BlockedState());
            default:
                throw new IllegalArgumentException("Unsupported phone brand: " + brand);
        }
    }
}

