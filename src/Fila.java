import java.util.concurrent.Semaphore;

public class Fila {

    int item;
    static Semaphore semaphoreConsumer = new Semaphore(0);
    static Semaphore semaphoreProdutor = new Semaphore(1);

    public void consumirItem() {
        try {
            semaphoreConsumer.acquire();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Consumindo item: " +item);
        semaphoreProdutor.release();
    }

    public void produzirItem(int item) {
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
