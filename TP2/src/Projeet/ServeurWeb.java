package Projeet;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class ServeurWeb {
	
	

	public ServeurWeb() {
		init();
		
	}

	public String LireFichier(String fname) {

		String Corps ="";
		try {
			
			BufferedReader bf =new BufferedReader(new FileReader(fname));
			 String ligne;
	            while ((ligne = bf.readLine()) != null) {
	                Corps+=ligne;
	            }
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return Corps;
		
	}
	public  void init() {
		int port = 8000;
		String fhtml = "C:\\Users\\DELL\\eclipse-workspace\\TP2\\src\\Projeet\\Untitled-2.html";

try {
	
	ServerSocket ss = new ServerSocket(port);
	System.out.println("Serveur démarré ...... ");
	while(true) {
		System.out.println("serveur attendre la requête client ........");
		Socket sc=ss.accept();
		
		String corps =LireFichier(fhtml);
	//NavigateurProcess(sc);
	WebThread client=new WebThread(sc,corps);
	client.start();
	
	}
}catch(Exception e) {
	System.out.println(e.getMessage());
	
}
	}
public void NavigateurProcess(Socket sc) {
	String fhtml = "C:\\Users\\DELL\\eclipse-workspace\\TP2\\src\\Projeet\\Untitled-2.html";

	try {
		//String corps = "<HTML><TITLE>Mon serveur</TITLE>Cette page a été envoyée par mon <B>Serveur</B></HTML>";
        String corps =LireFichier(fhtml);
        
		String rep = "HTTP/1.0 200 OK\n\n"
		           + corps;
               
		PrintWriter out = new PrintWriter(sc.getOutputStream());

  
  out.println(rep); 
  out.flush();
		sc.close();
	}catch(Exception e ) {
		System.out.println(e.getMessage());
	}
}
public static void main(String[] args) {
	new ServeurWeb();
	
}

}
