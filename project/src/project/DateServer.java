package project;
import java.io.*;
import java.net.*;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DateServer {

	 private static final String[] PROVERBES = {
		        "Petit à petit, l’oiseau fait son nid.",
		        "Qui ne risque rien n’a rien.",
		        "Après la pluie, le beau temps.",
		        "Mieux vaut tard que jamais.",
		        "L’habit ne fait pas le moine.",
		        "On ne change pas une équipe qui gagne."
		    };
	

	public DateServer() {
		init();
		
	}

	public  void init() {
try {
	int port=8000;
	ServerSocket ss = new ServerSocket(port);
	System.out.println("server date est en attent.....");
	while(true) {
		System.out.println("server attendre la requete client ........");
		Socket sc=ss.accept();
	ClientProcess(sc);
	
	}
}catch(Exception e) {
	System.out.println(e.getMessage());
	
}
	}
public void ClientProcess(Socket sc) {
	try {
		PrintWriter out = new PrintWriter(sc.getOutputStream());

        Random rnd= new Random();
		String prov = PROVERBES[rnd.nextInt(PROVERBES.length)];
        out.println("<HTML><TITLE>Mon serveur</TITLE>Cette page a été envoyée par mon <B>Serveur</B></HTML>"); 
        out.flush();
		
	}catch(Exception e ) {
		System.out.println(e.getMessage());
	}
}
public static void main(String[] args) {
	new DateServer();
	
}
}
