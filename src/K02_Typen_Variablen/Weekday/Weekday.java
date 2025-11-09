package K02_Typen_Variablen.Weekday;
    
import java.util.Scanner;

// Wir verwenden die Gaußsche Wochentagsformel (siehe z.B. https://de.wikipedia.org/wiki/Gaußsche_Wochentagsformel)
// zur Berechnung des Wochentags des 1. Januar eines Jahres.
// Im berechneten Ergebnis sind die Wochentage von 0 bis 6 durchnummeriert, wobei 0 für Sonntag, 1 für Montag, etc.
// steht.

class Weekday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Bitte geben Sie eine Jahreszahl ein: ");
        int year = sc.nextInt();
        int t1 = (year - 1) % 4;
        int t2 = (year - 1) % 100;
        int t3 = (year - 1) % 400;
        int t4 = 1 + 5*t1 + 4*t2 + 6*t3;
        int weekDay = t4 % 7;
        System.out.println("1. Januar im Jahr " + year
            + " ist Wochentag Nr. " + weekDay);
    }
}