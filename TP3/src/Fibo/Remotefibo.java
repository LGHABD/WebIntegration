package Fibo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Remotefibo extends UnicastRemoteObject implements IRemotefibo {
    public Remotefibo() throws RemoteException {
        super();
    }

    @Override
    public double fibonacci(int n) throws RemoteException {
        int a = 0;
        int b = 1;
        int c = 0;

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
