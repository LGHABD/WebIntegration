package TP3;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteBank extends Remote {
    int getsolde(int i) throws RemoteException;
    String getproprietaire(int i) throws RemoteException;
}
