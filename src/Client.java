
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

@SuppressWarnings("serial")
public class Client implements InterfaceClient, Serializable {

    static Scanner scan = new Scanner(System.in);

    public Client() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    public static void main(String[] args) {
        try {
            Client c = new Client();
            System.out.println("Recherche de l'objet.");
            sendRequest(c);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void sendRequest(Client c) throws MalformedURLException, RemoteException, NotBoundException {
        String url = "rmi://localhost/TodoService";
        InterfaceService objdist = (InterfaceService) Naming.lookup(url);
        System.out.println("Entrer n:");
        int n = scan.nextInt();
        System.out.print("Entrer x :");
        int x = scan.nextInt();

        objdist.horloge(x, n, c);

        for (int i = 0; i < 100000; i++) {
            System.out.println("test");

        }

    }

    @Override
    public void setResponse(int response) throws RemoteException {
        System.out.println("Nombre recuperer depuis le serveur est : " + response);
    }

}
