package project;


    public class NewtRunnable implements Runnable {
        private final int debut;
        private final int fin;

        public NewtRunnable(int debut, int fin) {
            this.debut = debut;
            this.fin = fin;
        }

        @Override
        public void run() {
            String nom = Thread.currentThread().getName();
            for (int i = debut; i <= fin; i++) {
                double r = NewtSQRT.sqrtNewton(i);
                System.out.println(nom + " : sqrt(" + i + ") = " + r);
            }
        }
    }
