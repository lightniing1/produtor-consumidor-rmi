import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor {
    public static void main (String argv[]) throws IOException, NotBoundException {

        System.setProperty("java.rmi.server.hostname", "localhost");
        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        Fila fila = new Fila();

        try {
            System.out.println("Iniciando servidor");
            registry.bind("Fila", fila);
        } catch (Exception e) {
            System.out.println("Erro ao iniciar o servidor: "+e.toString());
        }

        System.out.println("Press <Enter> for exit.");
        System.in.read();

        // Limpa o registro
        UnicastRemoteObject.unexportObject(fila, true);
        registry.unbind("Fila");
        //System.out.println("Remote object unbounded.");

    }
}
