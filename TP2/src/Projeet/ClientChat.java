package Projeet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {
    private static final String HOST = "localhost";
    private static final int PORT = 5000;

    public void demarrer() {
        Scanner clavier = new Scanner(System.in);

        try {
            System.out.print("Entrez votre pseudo : ");
            String pseudo = clavier.nextLine();

            Socket socket = new Socket(HOST, PORT);
            System.out.println("Connecté au serveur.");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println(pseudo);

            RepThread reception = new RepThread(in);
            reception.start();

            while (true) {
                String message = clavier.nextLine();
                out.println(message);

                if (message.equalsIgnoreCase("/quit")) {
                    break;
                }
            }

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ClientChat().demarrer();
    }
}