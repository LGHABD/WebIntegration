package TP3;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Bankserver {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        RemoteBank obj = new RemoteBank();
        obj.addcompte(new Compte(1000, "ahmed"));
        obj.addcompte(new Compte(10000, "khadija"));
        LocateRegistry.createRegistry(1099);
        Naming.rebind("rmi://localhost:1099/Bankserver", obj);
        System.out.println("le serveur marche bien 0.....");
    }
}
