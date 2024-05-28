package mobile_phone2.MobilePhone;

// Класс хранителя, который отвечает за хранение и предоставление снимков состояния телефона
public class PhoneCareTaker {
    private final int MAX_HISTORY_SIZE = 10; // Максимальный размер истории
    private PhoneMemento[] history = new PhoneMemento[MAX_HISTORY_SIZE];
    private int currentIndex = -1; // Индекс текущего снимка

    public PhoneCareTaker() {
    }

    public PhoneMemento[] getHistory() {
        return history;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void saveMemento(PhoneMemento memento) {
        if (currentIndex < MAX_HISTORY_SIZE - 1) {
            currentIndex++;
            history[currentIndex] = memento;
        } else {
            // Если история переполнена, удаляем самый старый элемент и сдвигаем остальные
            for (int i = 0; i < MAX_HISTORY_SIZE - 1; i++) {
                history[i] = history[i + 1];
            }
            history[MAX_HISTORY_SIZE - 1] = memento;
        }
    }

    public PhoneMemento getMemento(int index) {
        if (index >= 0 && index <= currentIndex) {
            return history[index];
        }
        return null;
    }
}