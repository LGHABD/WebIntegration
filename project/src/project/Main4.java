package project;
import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.*;

public class Main4 {
	
		public Main4() throws InterruptedException, ExecutionException {
			//sequentielle();
			//Executorserviceseq();
			//RunnableNewt();
			callablenewt();
			
	 }
	//1
	public void sequentielle() {
		long start = System.currentTimeMillis();

        for (int i = 0; i <= 5000; i++) {
            double r = NewtSQRT.sqrtNewton(i);
            System.out.println("sqrt(" + i + ") = " + r);
        }

        long end = System.currentTimeMillis();
        System.out.println("\nTemps séquentiel = " + (end - start) + " ms");
    }
	//2
	public void Executorserviceseq() {
		long start = System.currentTimeMillis();
    ExecutorService pool = Executors.newFixedThreadPool(5);
    int bloc = 100; 
    for (int debut = 0; debut <= 5000; debut += bloc) {
        int fin = Math.min(debut + bloc - 1, 5000);
        final int s = debut; 
        final int e= fin; 
        pool.submit(() -> {
            String nom = Thread.currentThread().getName();
            for (int i = s; i <= e; i++) {
                double r = NewtSQRT.sqrtNewton(i);
                System.out.println(nom + " : sqrt(" + i + ") = " + r);
            }
        });
    }
    long end = System.currentTimeMillis();
    System.out.println("\nTemps sequentiel = " + (end - start) + " ms");
	}
	//3-4
	public void RunnableNewt() {
		 long start = System.currentTimeMillis();

	        ExecutorService pool = Executors.newFixedThreadPool(5);

	        int bloc = 100;
	        for (int debut = 0; debut <= 5000; debut += bloc) {
	            int fin = Math.min(debut + bloc - 1, 5000);
	            pool.submit(new NewtRunnable(debut, fin));
	        }

	        pool.shutdown();

	        long end = System.currentTimeMillis();
	        System.out.println("\nTemps Runnable = " + (end - start) + " ms");
	}
	
	
	//5_6
	 public void callablenewt() throws InterruptedException, ExecutionException {
	        long start = System.currentTimeMillis();
	        ExecutorService pool = Executors.newFixedThreadPool(5);
	        List<Future<List<String>>> futures = new ArrayList<>();
	        int bloc = 100;
	        for (int debut = 0; debut <= 5000; debut += bloc) {
	            int fin = Math.min(debut + bloc - 1, 5000);
	            futures.add(pool.submit(new RootTask(debut, fin)));
	        }
	        pool.shutdown(); 
	        for (Future<List<String>> f : futures) {
	            for (String ligne : f.get()) {
	                System.out.println(ligne);
	            }
	        }
	        long end = System.currentTimeMillis();
	        System.out.println("\nTemps Callable  = " + (end - start) + " ms");
	    }
	 public static void main(String[] args) throws InterruptedException, ExecutionException {
		 new Main4();
	 }
	}


