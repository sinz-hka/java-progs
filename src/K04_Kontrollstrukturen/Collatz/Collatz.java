package K04_Kontrollstrukturen.Collatz;

class Collatz {
    public static void main(String[] args) {
        
        long c = Long.parseLong(args[0]);
        
        while (c != 1) {
            System.out.print(c + " → ");
            if (c % 2 == 0) {
                c = c/2;
            } else {
                // c ungerade
                c = 3*c + 1;
            }
        }
        System.out.println(1);
        
    }
}
