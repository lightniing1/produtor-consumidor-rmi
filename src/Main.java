import java.rmi.RemoteException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws RemoteException {

        Fila fila = new Fila();
        Produtor produtor = new Produtor(fila);
        Produtor produtor2 = new Produtor(fila);
        Consumidor consumidor = new Consumidor(fila);
        //Consumidor consumidor2 = new Consumidor(fila);

    }
}