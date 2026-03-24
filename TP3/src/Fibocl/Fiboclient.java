package Fibocl;

import Fibo.IRemotefibo;

import java.rmi.Naming;

public class Fiboclient {
    public static void main(String[] args) {
        try {
            IRemotefibo inter = (IRemotefibo) Naming.lookup("rmi://localhost:1099/Bankserver");
            System.out.println("Connexion au serveur réussie.");
            System.out.println("le suite 1 est de ." + inter.fibonacci(1));
            System.out.println("le suite  2 est de ." + inter.fibonacci(2));
            System.out.println("le suite  100 est de ." + inter.fibonacci(15));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
