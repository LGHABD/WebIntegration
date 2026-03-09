package project;

import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client {
	 public static void main(String[] args) throws UnknownHostException, IOException {
	try {	Socket s= new Socket("host",9000);
		Scanner in = new Scanner(s.getInputStream());
		  
          System.out.println("Proverbe reçu : " + in.nextLine());
        		  
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	}

}
