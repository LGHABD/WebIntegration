package Projeet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientchatThread extends Thread{

	    private Socket socket;
	    private ServeurChat serveur;
	    private PrintWriter out;
	    private BufferedReader in;
	    private String pseudo;

	    public ClientchatThread(Socket socket, ServeurChat serveur) {
	        this.socket = socket;
	        this.serveur = serveur;
	    }

	    public void envoyerMessage(String message) {
	        if (out != null) {
	            out.println(message);
	        }
	    }

	    @Override
	    public void run() {
	        try {
	            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	            out = new PrintWriter(socket.getOutputStream(), true);

	            pseudo = in.readLine();

	            if (pseudo == null || pseudo.trim().isEmpty()) {
	                pseudo = "Anonyme";
	            }

	            serveur.ajouterClient(this);

	            out.println("Bienvenue " + pseudo + " !");
	            serveur.diffuser(">> " + pseudo + " a rejoint le chat.", this);

	            String message;
	            while ((message = in.readLine()) != null) {
	                if (message.equalsIgnoreCase("/quit")) {
	                    break;
	                }

	                System.out.println(pseudo + " : " + message);
	                serveur.diffuser(pseudo + " : " + message, this);
	            }

	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        } finally {
	            try {
	                serveur.supprimerClient(this);

	                if (pseudo != null) {
	                    serveur.diffuser(">> " + pseudo + " a quitté le chat.", this);
	                }

	                if (socket != null) {
	                    socket.close();
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}

