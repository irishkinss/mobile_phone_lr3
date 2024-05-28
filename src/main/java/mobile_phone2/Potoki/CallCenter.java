package mobile_phone2.Potoki;

import java.util.Vector;

public class CallCenter extends Thread{
    public static final int WORK_DELAY = 1000;
    //private Operator operator;
    private Vector<Operator> operators = new Vector<>();
    private Vector<Client> clients = new Vector<>();

    public CallCenter() {
        // Запускаем все потоки
        for (Thread thread : operators) {
            thread.start();
        }
    }
    public synchronized void addClient(Client client){
        clients.add(client);
    }
    public synchronized boolean hasClients(){
        return !clients.isEmpty();
    }
    public synchronized void doOperatorWork(){
        while (hasClients()){
            Client client = clients.get(0);
            System.out.println("Оператор обслуживает клиента");
            try {
                Thread.sleep(WORK_DELAY);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clients.remove(client);
            System.out.println(clients.size() + " клиент ушел");
        }
        System.out.println("Оператор засыпает");
        try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
    }
    public synchronized void clientArrived(Client client){
        if(hasClients()) addClient(client);
        else {
            addClient(client);
            notify();
        }
    }
}
