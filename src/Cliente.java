import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main (String argv[]) throws RemoteException, NotBoundException, InterruptedException {

        Registry registry = LocateRegistry.getRegistry("localhost", Registry.REGISTRY_PORT);
        IMetodosFilaServidor fila = (IMetodosFilaServidor) registry.lookup("Fila");

        System.out.println("Iniciando cliente");

        Produtor produtor = new Produtor(fila);
        Consumidor consumidor = new Consumidor(fila);
        Consumidor consumidor2 = new Consumidor(fila);

        //Thread.sleep(5000);
        //Produtor produtor2 = new Produtor(fila);

    }
}