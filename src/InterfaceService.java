

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceService extends Remote{

    public void horloge(int x, int n, InterfaceClient instanceClient) throws RemoteException;
}
