import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.Semaphore;

public class Fila extends UnicastRemoteObject implements IMetodosFilaServidor {

    int item;
    static Semaphore semaphoreConsumer = new Semaphore(0);
    static Semaphore semaphoreProdutor = new Semaphore(1);

    public Fila() throws RemoteException {
        System.out.println("Fila instanciada");
    }

    public void consumirItem() throws RemoteException {
        try {
            semaphoreConsumer.acquire();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Consumindo item: " +item);
        semaphoreProdutor.release();
    }

    public void produzirItem(int item) throws RemoteException {
        try {
            semaphoreProdutor.acquire();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        this.item = item;
        System.out.println("Produzindo item: "+item);
        semaphoreConsumer.release();
    }
}
