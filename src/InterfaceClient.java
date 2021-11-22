

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceClient extends Remote{

    public void setResponse(int response) throws RemoteException;
}
