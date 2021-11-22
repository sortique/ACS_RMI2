import java.rmi.Naming;

public class Server {
    public static void main(String[] args) {
        ImpInterfaceServer objserv = null;
        try {
            objserv = new ImpInterfaceServer();
            System.out.println("Enregistrement de l'objet.");
            Naming.rebind("TodoService", objserv);
            System.out.println("serveur operationnel.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}