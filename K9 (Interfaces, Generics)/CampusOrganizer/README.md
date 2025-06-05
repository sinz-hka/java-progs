## Hochschul-Verwaltungs-System

In diesem Projekt soll ein einfaches Hochschul-Verwaltungs-System implementiert
werden, mit dem sich Räume und Studierende verwalten lassen. Die Verwendung von
Interfaces und Generics soll hierbei nochmals demonstriert werden.

Die Basisfunktionalität für Studierende und Räume ist gleich: es soll eine Speicherung
von Objekten (Studenten, Räume) mögich sein, die dann unter einem Suchbegriff
(Schlüssel) wiedergefunden werden können. Der Schlüssel kann z.B. eine Nummer (Matr.-Nr.)
oder ein Text (z.B. Raumbezeichnung) sein.

Die Speicherung der Daten soll in sogenannten "Repositories" erfolgen, je eines für
jeden Objekt-Typ (Studenten, Räume). Die gemeinsame Funktionalität aller
Repositories wird über ein Java-Interface festgelegt:
* `add`: Fügt ein neues Element dem Speicher hinzu.
* `search`: Sucht nach einem Element anhand eines gegebenen Schlüssels.
* `delete`: Löscht ein Element aus dem Repository.

Das Interface soll für das Speichern beliebiger Objekte verwendbar sein, weshalb wir
für den Objekttyp einen Typ-Parameter `E` (für Element) verwenden. Der Typ des
Suchschlüssels soll auch frei gewählt werden können, so dass wir dafür einen weiteren
Typ-Parameter `K` (für Key) einsetzen.

Damit sieht das Interface wie folgt aus:

```java
public interface Repository<E, K> {
    void add(E element);   // E must have a key
    E search(K key);
    boolean delete(K key); // returns true iff an element was deleted
}
```

Wie wir am Kommentar zur `add`-Methode sehen, sind die beiden Typen `E` und `K`
nicht unabhängig. Der Typ `E` muss so gewählt sein, dass er einen Suchschlüssel
vom Typ `K` zulässt. Dies kann durch einen Kommentar, wie oben, spezifiziert werden.
Besser wäre es aber noch, wenn wir die Abhängigkeit explizit und vom Compiler
prüfbar machen könnten. Aber wie geht das?

Wir wollen erreichen, dass ein Typ, z.B. `E`, einen Suchschlüssel besitzt, den wir
mit einer Methode wie `getKey()` uns zurückgeben lassen können. Ein Interface
erlaubt uns, dies für einen Typ `E` festzulegen. In vielen Programmiersprachen
hat sich der Name `Identifiable` für ein solches Interface eingebürgert.
Die Methode heißt dann meist `getID()` statt `getKey()`, und wir können
daher definieren:

```java
public interface Identifiable<K> {
    K getID();
}
```

Damit können wir nun den Typ-Constraint im Interface `Repository` explizit angeben
und damit vom Compiler prüfbar machen:

```java
public interface Repository<E extends Identifiable<K>, K> {
    void add(E element);   // E must have a key
    E search(K key);
    boolean delete(K key); // returns true iff an element was deleted
}
```

Mit dem Typ-Constraint `E extends Identifiable<K>` erlauben wir für den Typ `E`
nur solche Typen, die das Interface `Identifiable<K>` implementieren und damit
mittels `getID()` einen Suchschlüssel vom Typ `K` zurückgeben können.

