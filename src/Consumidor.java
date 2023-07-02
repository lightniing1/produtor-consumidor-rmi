public class Consumidor implements Runnable {

    private Fila fila;
    private int i = 0;
    Consumidor (Fila fila) {
        this.fila = fila;
        new Thread(this, "Consumidor").start();
    }

    public void run() {
        while(true) {
            fila.consumirItem();
        }
    }
}
