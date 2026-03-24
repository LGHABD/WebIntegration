package Fibo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Fiboserver {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Remotefibo obj = new Remotefibo();
        LocateRegistry.createRegistry(1099);
        Naming.rebind("rmi://localhost:1099/Bankserver", obj);
        System.out.println("le serveur marche bien 0.....");
    }
}
