package project;
public class NewtSQRT {

    public static double sqrtNewton(double x) {
        if (x < 0) throw new IllegalArgumentException("x negatif");
        if (x == 0) return 0;
        double g = x;             
        double eps = 1e-12;        
        int maxIter = 50;
        for (int i = 0; i < maxIter; i++) {
            double ng = 0.5 * (g + x / g);
            if (Math.abs(ng - g) < eps) return ng;
            g = ng;
        }
        return g;
    }
}
