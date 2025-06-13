package K10_Recursion.MergeSort;

public class Sorting {

    // sort array (in-place), but only from indices i to j-1
    public static void mergeSort(int[] a, int i, int j) {
        if (i == j || i+1 == j) {
            // Basisfall: leerer Arrayausschnitt oder mit nur einem Element
            return;
        } else {
            // rekursiver Fall: sortiere 1. und 2. Hälfte getrennt
            int p = (i+j)/2;
            mergeSort(a, i, p);
            mergeSort(a, p, j);

            // "Merge" unter Verwendung eines neuen Arrays (res)
            int[] res = new int[a.length];
            int c1 = i;   // c1: Index in erster Hälfte
            int c2 = p;   // c2: Index in zweiter Hälfte
            int ins = i;  // "insert" Index
            while(c1 < p && c2 < j) {
                if (a[c1] < a[c2]) {
                    res[ins] = a[c1];
                    c1++;
                } else {
                    res[ins] = a[c2];
                    c2++;
                }
                ins++;
            }
            // Rest kopieren
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
            // Ergebnis zurückkopieren von res nach a.
            for (int k = i; k < j; k++) {
                a[k] = res[k];
            }
        }
    }
}