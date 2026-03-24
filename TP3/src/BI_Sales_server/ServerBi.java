package BI_Sales_server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServerBi {
    public static void main(String[] args) {
        try {
            RemoteSalesServices obj = new RemoteSalesServices();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost:1099/ServerBi", obj);
            System.out.println("le serveur marche bien 0.....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
