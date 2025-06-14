package K10_Recursion.MergeSort;

public class Sorting {

    public static void sort(int[] a) {
        sort(a, 0, a.length);
    }

    // Sortiere das Array a von Index i (einschließlich) bis Index j (ausschließlich)
    // in aufsteigender Reihenfolge.
    // Falls i > j, ist das Ergebnis undefiniert.
    private static void sort(int[] a, int i, int j) {
        if ( i == j-1 || i == j) {
            // Basisfall: Arrayausschnitt mit nur einem Element oder leeres Array soll sortiert werden.
            // In diesem Fall ist gar nichts zu tun!
            return;
        } else {
            // Rekursiver Fall: Sortiere 1. und 2. Hälfte getrennt und führe dann das Ergebnis zusammen.
            int p = (i+j)/2;
            sort(a, i, p);      // sortiere erste Hälfte a[i .. p-1]
            sort(a, p, j);      // sortiere zweite Hälfte a[p .. j-1]
            merge(a, i, p, j);  // füge die beiden Hälften zusammen
        }
    }

    // Füge zwei sortierte Array-Ausschnitte zusammen.
    // Der erste Array-Ausschnitt ist a[i .. p-1], der zweite a[p .. j-1].
    // Keines der beiden Ausschnitte ist leer, d.h. es gilt i < p < j.
    private static void merge(int[] a, int i, int p, int j) {
        // "Merge" unter Verwendung eines neuen Arrays (res).
        // Wir wählen als Größe von res die gleiche Größe wie a (obwohl eigentlich nur
        // j-i Elemente benötigt würden), damit wir die Indizes in a und res gleich lassen können.
        int[] res = new int[a.length];
        // Idee von merge: Wir gehen mit zwei Zeigern (c1, c2) durch die linke und rechts Hälfte
        // aufsteigend durch und kopieren das jeweils kleinere der beiden Elemente, auf die c1
        // und c2 zeigen ins Ergebnis-Array (an Position ins).
        int c1 = i;   // c1: Index in erster Hälfte
        int c2 = p;   // c2: Index in zweiter Hälfte
        int ins = i;  // "insert" Index
        while(c1 < p && c2 < j) {
            // Wir sind in beiden Hälften mit c1 und c2 noch auf gültigen Positionen.
            if (a[c1] < a[c2]) {
                // kopiere das nächste Element aus der linken Hälfte
                res[ins] = a[c1];
                c1++;
            } else {
                // kopiere das nächste Element aus der rechten Hälfte
                res[ins] = a[c2];
                c2++;
            }
            ins++;
        }
        // Jetzt sind wir in einer Hälfte am Ende angekommen und müssen aus der anderen
        // Hälfte noch verbleibende Elemente kopieren.
        if (c1 < p) {
            // ...aus erster Hälfte
            while (c1 < p) {
                res[ins++] = a[c1++];
            }
        } else {
            // ...aus zweiter Hälfte
            while (c2 < j) {
                res[ins++] = a[c2++];
            }
        }
        // Jetzt noch das Ergebnis zurückkopieren von res nach a.
        for (int k = i; k < j; k++) {
            a[k] = res[k];
        }
    }
}