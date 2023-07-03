import java.rmi.RemoteException;

public class Produtor implements Runnable {
    private IMetodosFilaServidor fila;

    Produtor (IMetodosFilaServidor fila) {
        this.fila = fila;
        new Thread(this, "Produtor").start();
    }

    public void run() {
        for (int i = 0; i < 5000; i++){
            try {
                fila.produzirItem(i);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
