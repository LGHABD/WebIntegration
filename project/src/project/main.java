package project;

public class main {
	public main() throws InterruptedException {
	//sequentiel();
	//concurente();
	ConcurrentRunnable() ;
 }
//1
public void sequentiel() {
	   for (int i = 1; i <= 10; i++) {
           System.out.println(i);
       }
       for (char c = 'a'; c <= 'z'; c++) {
           System.out.println(c);
       }
}
//2
 public void concurente() throws InterruptedException {
	 
	 Thread t1=new Threadnumbers("t1");
	Thread t2=new threadletters("t2");
	t2.start();
	//t2.join();
	t1.start();
	//t1.join();
	
	
	//t2.setPriority(Thread.MAX_PRIORITY);
	//t1.setPriority(Thread.MIN_PRIORITY); 
 }
 


 /* 3
  * Cas séquentiel 
l'ordre déterministe (toujours identique).
Cas concurrent 
l’ordre d’affichage est non déterministe :*/
 //4_6_7
 public void ConcurrentRunnable() throws InterruptedException { 
	 Runnable r = new Afficheur();

   
     Thread t1 = new Thread(r, "T1");
     Thread t2 = new Thread(r, "T2");
     t2.setPriority(Thread.MAX_PRIORITY);
     t1.setPriority(Thread.MIN_PRIORITY);
     t1.start();
     t1.join();
     t2.start();
 }
 //5
 /*
Thread:représente un thread (un “fil d’exécution”). On crée un thread en héritant (extends Thread) et en redéfinissant run().

Runnable:représente une tâche à exécuter. On passe l’objet Runnable à un Thread
*/
 public static void main(String[] args) throws InterruptedException {
	 new main();
	 
 }
}
