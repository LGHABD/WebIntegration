package Projeet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Serveur {
	 private static final String[] PROVERBES = {
		        "Petit à petit, l’oiseau fait son nid.",
		        "Qui ne risque rien n’a rien.",
		        "Après la pluie, le beau temps.",
		        "Mieux vaut tard que jamais.",
		        "L’habit ne fait pas le moine.",
		        "On ne change pas une équipe qui gagne."
		    };
	

	public Serveur() {
		init();
		
	}
 public List<String> ChargerProverbes( String fname){
	 List<String> prov= new ArrayList<String>();
	 try {
		 BufferedReader bf =new BufferedReader(new FileReader(fname));
		 String ligne;
		 while ((ligne = bf.readLine()) != null) {
			 prov.add(ligne);
		 }
	 }catch(Exception e) {
		 System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
	 }
	return prov;
	 
 }
	public  void init() {
try {
	int port=10;
	ServerSocket ss = new ServerSocket(port);
	System.out.println("Serveur démarré ...... ");
	List<String> proverbes = ChargerProverbes("C:\\Users\\DELL\\eclipse-workspace\\TP2\\src\\Projeet\\Proverbes.txt");
	while(true) {
		System.out.println("serveur attendre la requête client ........");
		Socket sc=ss.accept();
		

        ClientThread handler = new ClientThread(sc, proverbes);
        handler.start();
         
	//ClientProcess(sc);
	
	}
}catch(Exception e) {
	System.out.println(e.getMessage());
	
}
	}
public void ClientProcess(Socket sc) {
	
	try {
		PrintWriter out = new PrintWriter(sc.getOutputStream());
		List<String> proverbes = ChargerProverbes("C:\\Users\\DELL\\eclipse-workspace\\TP2\\src\\Projeet\\Proverbes.txt");

     Random rnd= new Random();
     String prov = proverbes.get(rnd.nextInt(proverbes.size()));
		//String prov = PROVERBES[rnd.nextInt(PROVERBES.length)];
     out.println(prov); 
     out.flush();
		
	}catch(Exception e ) {
		System.out.println(e.getMessage());
	}
}
public static void main(String[] args) {
	new Serveur();
	
}

}
