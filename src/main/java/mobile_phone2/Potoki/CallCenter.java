package mobile_phone2.Potoki;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CallCenter {
    private final Lock lock = new ReentrantLock();
    private final Condition operatorAvailable = lock.newCondition();
    private Vector<Operator> operators;
    public static final int WORK_DELAY = 20000;
    public static final int MAX_WAITING_LINES = 10;
    private final Queue<Client> clients = new LinkedList<>();
    private final Queue<Client> waitingLines = new LinkedList<>();

    public void setOperators(Vector<Operator> operators) {
        this.operators = operators;
    }

    public CallCenter() {}

    public void WakeUpCallCenter(Vector<Operator> operators) {
        for (Operator operator : operators) {
            operator.start();
        }
    }

    public void addClient(Client client) {
        lock.lock();
        try {
            if (clients.size() < operators.size()) {
                clients.add(client);
                operatorAvailable.signal();
            } else if (waitingLines.size() < MAX_WAITING_LINES) {
                System.out.println("Клиент " + client.getId() + " в очереди под номером " + waitingLines.size());
                waitingLines.add(client);
            } else {
                System.out.println("Для клиента " + client.getId() + " нет места");
            }
        } finally {
            lock.unlock();
        }
    }

    public Client getNextClient() {
        lock.lock();
        try {
            while (clients.isEmpty()) {
                try {
                    operatorAvailable.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return null;
                }
            }
            return clients.poll();
        } finally {
            lock.unlock();
        }
    }

    public void doOperatorWork(Operator operator) {
        while (!Thread.currentThread().isInterrupted()) {
            lock.lock();
            try {
                if (!waitingLines.isEmpty() && clients.size() < operators.size()) {
                    clients.add(waitingLines.poll());
                    operatorAvailable.signal();
                }
            } finally {
                lock.unlock();
            }

            Client client = getNextClient();
            if (client != null) {
                System.out.println("Оператор " + operator.getOperatorId() + " обслуживает клиента " + client.getId());
                try {
                    Thread.sleep(WORK_DELAY);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                System.out.println("Клиент " + client.getId() + " ушел");
            }
        }
    }
}
