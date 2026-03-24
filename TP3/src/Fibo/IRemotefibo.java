package Fibo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemotefibo extends Remote {
    double fibonacci(int n) throws RemoteException;
}
