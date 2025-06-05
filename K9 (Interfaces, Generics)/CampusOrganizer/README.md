## Hochschul-Verwaltungs-System

In diesem Projekt soll ein einfaches Hochschul-Verwaltungs-System implementiert
werden, mit dem sich Räume und Studierende verwalten lassen.

Die Basisfunktionalität für Studierende und Räume ist gleich: es soll eine Speicherung
von Objekten mögich sein, die dann unter einem Suchbegriff (Schlüssel) wiedergefunden
werden können. Der Schlüssel kann z.B. eine Nummer oder ein Text sein.

Die Speicherung der Daten soll in sogenannten "Repositories" erfolgen. Die gemeinsame
Funktionalität aller Repositories wird über ein Java-Interface festgelegt:
* `add`: Fügt ein neues Element dem Speicher hinzu.
* `search`: Sucht nach einem Element anhand eines gegebenen Schlüssels.
* `delete`: Löscht ein Element aus dem Repository.

Das Interface soll für das Speichern beliebiger Objekte verwendbar sein, weshalb wir
für den Objekttyp einen Typ-Parameter `T` verwenden. Der Typ des Suchschlüssels soll
auch frei gewählt werden können, so dass wir dafür einen weiteren Typ-Parameter `K` (für Key)
einsetzen.

Damit sieht das Interface wie folgt aus:
```java
public interface Repository<T,K> {
    void add(T element);   // T must have a key
    T search(K key);
    boolean delete(K key); // returns true iff an element was deleted
}
```
