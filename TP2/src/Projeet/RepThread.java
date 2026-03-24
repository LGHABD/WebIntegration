package Projeet;

import java.io.BufferedReader;

public class RepThread extends Thread {
    private BufferedReader in;

    public RepThread(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println(message);
            }
        } catch (Exception e) {
            System.out.println("Déconnecté du serveur.");
        }
    }
}