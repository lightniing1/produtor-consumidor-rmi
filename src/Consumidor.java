import java.rmi.RemoteException;

public class Consumidor implements Runnable {

    private IMetodosFilaServidor fila;
    Consumidor (IMetodosFilaServidor fila) {
        this.fila = fila;
        new Thread(this, "Consumidor").start();
    }

    public void run() {
        for (int i = 0; i < 5000; i++){
            try {
                fila.consumirItem();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
