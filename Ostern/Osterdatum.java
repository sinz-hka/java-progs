public class Osterdatum {
    public static void main(String[] args) {
        int year = Integer.parseInt(args[0]);
        System.out.println("Oster-Berechnung für das Jahr " + year + ":");
        // Berechnung des Osterdatums anhand der Gaußschen Osterformel von 1816

        int a, b, c, k, p, q, M, d, N, e;

        a = year % 19;
        b = year % 4;
        c = year % 7;
        k = year / 100;
        p = (8*k + 13) / 25;
        q = k / 4;
        M = (15+k-p-q) % 30;
        d = (19*a + M) % 30;
        N = (4+k-q) % 7;
        e = (2*b + 4*c + 6*d + N) % 7;

        int easter = 22 + d + e;
        
        if (easter <= 31) {
            System.out.println("Ostern ist am " + easter + ". März.");
        } else {
            System.out.println("Ostern ist am " + (easter-31) + ". April.");
        }
    }
}
