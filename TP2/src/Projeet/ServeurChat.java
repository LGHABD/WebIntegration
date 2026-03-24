package Projeet;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
public class ServeurChat {
    private Set<ClientchatThread> clients = Collections.synchronizedSet(new HashSet<>());

 public ServeurChat() {
	 init();
	 
 }
 public void init() {
	 int port=5000;
	   try (ServerSocket ss = new ServerSocket(port)) {
           System.out.println("Serveur de chat démarré........");

           while (true) {
               Socket socket = ss.accept();
               

               ClientchatThread cl = new ClientchatThread(socket, this);
               cl.start();
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
 public void ajouterClient(ClientchatThread client) {
     clients.add(client);
 }

 public void supprimerClient(ClientchatThread client) {
     clients.remove(client);
 }

 public void diffuser(String message, ClientchatThread expediteur) {
     synchronized (clients) {
         for (ClientchatThread client : clients) {
             if (client != expediteur) {
                 client.envoyerMessage(message);
             }
         }
     }
 }

 public void diffuserATous(String message) {
     synchronized (clients) {
         for (ClientchatThread client : clients) {
             client.envoyerMessage(message);
         }
     }
 }
   public static void main(String[] args) {
     new ServeurChat();
     
   }
}

