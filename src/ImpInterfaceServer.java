import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class ImpInterfaceServer extends UnicastRemoteObject implements InterfaceService {

    protected ImpInterfaceServer() throws RemoteException {
        super();
    }

    @Override
    public void horloge(int x, int n, InterfaceClient instanceClient) throws RemoteException {
        for (int i = 0; i < n; i++) {
            System.err.println("aa");
            try {
                Thread.sleep(x*1000);
                instanceClient.setResponse((int) (Math.random()*1000));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
