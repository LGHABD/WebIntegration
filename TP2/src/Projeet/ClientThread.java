package Projeet;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Random;

public class ClientThread extends Thread {
    private Socket socket;
    private List<String> proverbes;
    private Random random;

    public ClientThread(Socket socket, List<String> proverbes) {
        this.socket = socket;
        this.proverbes = proverbes;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            String proverbe = proverbes.get(random.nextInt(proverbes.size()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(proverbe);

            System.out.println("Proverbe envoyé à " + socket.getInetAddress());
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
