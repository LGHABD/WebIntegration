package TP3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteBank extends UnicastRemoteObject implements IRemoteBank {
    private ArrayList<Compte> comptes;

    public RemoteBank() throws RemoteException {
        super();
        comptes = new ArrayList<>();
    }

    @Override
    public int getsolde(int i) throws RemoteException {
        return comptes.get(i).getsolde();
    }

    @Override
    public String getproprietaire(int i) throws RemoteException {
        return comptes.get(i).getname();
    }

    public void addcompte(Compte compte) {
        comptes.add(compte);
    }
}
