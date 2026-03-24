package project;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class RootTask implements Callable<List<String>> {
	    private final int debut, fin;

	    public RootTask(int debut, int fin) {
	        this.debut = debut;
	        this.fin = fin;
	    }

	    @Override
	    public List<String> call() {
	        List<String> lignes = new ArrayList<>();
	        for (int i = debut; i <= fin; i++) {
	            double r =NewtSQRT .sqrtNewton(i);
	            lignes.add("sqrt(" + i + ") = " + r);
	        }
	        return lignes;
	    }
	}

