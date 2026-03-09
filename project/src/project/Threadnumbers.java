package project;

public class Threadnumbers extends Thread{
	public Threadnumbers() { super();} 
	public Threadnumbers(String n) { super(n);} 
	public void run() {
		for	(int i =0; i<=10;i++) {
			System.out.print( "\n thread "+Thread.currentThread()+"est a la valeur"+i);
		};
	}
}
