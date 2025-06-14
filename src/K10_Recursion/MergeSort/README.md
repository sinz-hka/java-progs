# Merge-Sort

Rekursives Sortieren eines Arrays.

Idee:
1. Teile das Array in der Mitte.
2. Sortiere dann beide Hälften durch zwei rekursive Aufrufe von Merge-Sort.
3. Jetzt haben wir zwei sortierte Hälften, die wir einfach zu einer Sortierung des gesamten Arrays umbauen können.

Am aufwändigsten ist Schritt 3.
Die Idee beim Zusammenführen ist, dass wir die beiden Hälften gleichzeitig
von links nach rechts durchlaufen (aufsteigende Indizes) und
dabei in jedem Schritt das kleinere Element ins Ergebnisarray übernehmen.

Details siehe Implementierung.

## Aufgaben

* Ändern Sie das Programm so ab, dass das Array in absteigender Reihenfolge sortiert wird.
* Überlegen Sie sich eine andere Idee zum rekursiven Sortieren, z.B.:
  sortiere alle Elemente bis auf das letzte (das wäre dann der rekursive Aufruf).
  Das letzte Element muss jetzt nur noch an der passenden Stelle eingefügt werden
  (d.h. nachfolgende Elemente müssen dann eins nach rechts
  verschoben werden). \[Dieser Algorithmus ist eine rekursive Variante von Insertion-Sort.\]