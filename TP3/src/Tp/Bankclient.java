package Tp;

import TP3.IRemoteBank;

import java.rmi.Naming;

public class Bankclient {
    public static void main(String[] args) {
        try {
            IRemoteBank inter = (IRemoteBank) Naming.lookup("rmi://localhost:1099/Bankserver");
            System.out.println("Connexion au serveur réussie.");
            System.out.println("le compte 1 est de ." + inter.getproprietaire(0));
            System.out.println("le solde du compte  2 est de ." + inter.getsolde(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
