public class Produtor implements Runnable {
    private Fila fila;
    private int i = 0;

    Produtor (Fila fila) {
        this.fila = fila;
        new Thread(this, "Produtor").start();
    }

    public void run() {
        while (true) {
            fila.produzirItem(i);
            i++;
        }
    }

}
