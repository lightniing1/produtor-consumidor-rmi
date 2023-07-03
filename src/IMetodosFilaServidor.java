import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMetodosFilaServidor extends Remote {
    public void consumirItem() throws RemoteException;
    public void produzirItem(int item) throws RemoteException;
}
