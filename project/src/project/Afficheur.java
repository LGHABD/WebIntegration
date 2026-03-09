package project;



		public class Afficheur implements Runnable {
	        @Override
	        public void run() {
	            String nom = Thread.currentThread().getName();

	            if (nom.equals("T1")) {
	                for (int i = 1; i <= 10; i++) {
	                	System.out.print( "\n thread "+nom+"est a la valeur"+i);
	                }
	            } else if (nom.equals("T2")) {
	                for (char c = 'a'; c <= 'z'; c++) {
	                	System.out.print( "\n thread "+nom +"est a la valeur"+c);
	                }
	            }
	        }
	    }
	


