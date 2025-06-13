## Campus Organizer

In diesem Projekt soll ein einfaches Hochschul-Verwaltungs-System implementiert
werden, mit dem sich Kurse und Studierende verwalten lassen. Die Verwendung von
Interfaces und Generics soll hierbei geübt werden.

Der Campus Organizer soll folgendes ermöglichen:
* Speicherung von Studierenden und Kursen
* Suche nach Studierenden (anhand der Matrikelnummer) und Kursen (anhand eines Kurs-Kürzels)
* Löschen von Studierenden und Kursen aus dem System

Die Basisfunktionalität für Studierende und Kurse ist also gleich: es soll eine Speicherung
von Objekten (Studenten, Kurse) möglich sein, die dann unter einem Suchbegriff
(Schlüssel) wiedergefunden werden können. Der Schlüssel kann sich unterscheiden
(Matr.-Nr. vs. Kurs-Kürzel).

Die Speicherung der Daten soll in sogenannten "Repositories" erfolgen, je eines für
jeden Objekt-Typ. Es bietet sich an, die gemeinsame Funktionalität aller Repositories
über ein (generisches) Java-Interface festzulegen. Die Interface-Methoden wären dann:
* `add`: Fügt ein neues Element dem Repository hinzu.
* `search`: Sucht nach einem Element anhand eines gegebenen Schlüssels.
* `delete`: Löscht ein Element aus dem Repository.

#### Generisches Interface für Repositories

Das Interface soll für das Speichern beliebiger Objekte verwendbar sein, weshalb wir
für den Objekttyp einen Typ-Parameter `E` (für Element) verwenden. Der Typ des
Suchschlüssels soll auch frei gewählt werden können, sodass wir dafür einen weiteren
Typ-Parameter `K` (für Key) einsetzen.

Damit sieht das Interface wie folgt aus:

```java
public interface Repository<E,K> {
    void add(E element);   // E must possess a key
    E search(K key);       // returns null if no element was found
    boolean delete(K key); // returns true iff an element was deleted
}
```

Wie wir am Kommentar zur `add`-Methode sehen, sind die beiden Typen `E` und `K`
nicht unabhängig. Der Typ `E` muss so gewählt sein, dass er ein Suche anhand
eines Schlüssels vom Typ `K` zulässt. Dies kann (notfalls) durch einen Kommentar, wie oben, spezifiziert werden.
Besser wäre es aber noch, wenn wir die Abhängigkeit explizit und vom Compiler
überprüfbar machen könnten. Aber wie geht das?

Wir wollen erreichen, dass ein Typ, z.B. `E`, einen Suchschlüssel besitzt, den wir
mit einer Methode wie `getKey()` uns zurückgeben lassen können. Ein Interface
erlaubt uns, diese Anforderung für einen beliebigen Typ als Typ-Constraint festzulegen.
In vielen Programmiersprachen hat sich der Name `Identifiable` für ein solches Interface
eingebürgert. Die Methode heißt dann meist `getID()` statt `getKey()`, und wir können
daher definieren:

```java
public interface Identifiable<K> {
    K getID();
}
```

Wenn wir nun wollen, dass für den Typ-Parameter `E` im Interface `Repository<E,K>`
nur solche Typen eingesetzt werden dürfen, die das Interface `Identifiable<K>` 
implementieren, können wir einen Typ-Constraint wie folgt verwenden:

```java
public interface Repository<E extends Identifiable<K>, K> {
    void add(E element);   // E must have a key
    E search(K key);       // returns null if no element is found
    boolean delete(K key); // returns true iff an element was deleted
}
```

Mit dem Typ-Constraint `E extends Identifiable<K>` erlauben wir für den Typ `E`
nur solche Typen, die das Interface `Identifiable<K>` implementieren und damit
mittels `getID()` einen Suchschlüssel vom Typ `K` zurückgeben können.
Es ist zu beachten, dass dies derselbe Typ ist, der auch als zweiter Typ-Parameter
von `Repository` angegeben ist, also als Suchschlüssel für das Repository verwendet werden soll.

#### Implementierung der Interfaces

Damit können wir nun mit der Implementierung der beiden Repositories (für
Studierende und für Kurse) beginnen.
Nach etwas überlegen stellt man fest, dass fast alle Methoden der Repositories
unabhängig von den Typen `E` und `K`  sind. Wir können also eine
generische Klasse mit zwei Typ-Parametern zur Implementierung verwenden.
Da wir nicht wollen, dass von dieser Klasse direkt Objekte erzeugt werden, wählen wir eine abstrakte Klasse:

```java
import java.util.*;

abstract public class AbstractRepository<E extends Identifiable<K>, K> implements Repository<E,K> {
    private Map<K,E> elements;

    public AbstractRepository() {
        elements = new HashMap<K,E>();
    }

    @Override
    public void add(E element) {
        // put(): from interface Map<K,E>; getID(): from constraint Identifiable<K> on E
        elements.put(element.getID(), element); 
    }

    @Override
    public E search(K key) {
        // get(): from interface Map<K,E>
        return elements.get(key); 
    }

    ...
}
```

Zur Speicherung der Schlüssel-Wert-Paare im Repository verwenden wir eine [`HashMap`](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html) aus `java.util`.

Nun erstellen wir Klassen für die Objekte, die wir speichern wollen, also 
Studenten und Kurse. Diese müssen den Typ `K` eines Suchschlüssels festlegen und
das Interface `Identifiable<K>` implementieren, also eine Methode `getID()` bereitstellen. Da die Klassen sehr ähnlich
zu implementieren sind, hier nur die Umsetzung für Studierende:

```java
public class Student implements Identifiable<Integer> {
    private String name;
    private Integer number;

    public Student(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    ...

    @Override
    public Integer getID() {
        return number;
    }
}
```

Suchschlüssel ist hier eine Ganzzahl vom Typ `Integer`, also z.B. eine Matrikelnummer.

Nun können wir sehr einfach eine Klasse `StudentRepository` (und analog auch eine weitere Klasse `CourseRepository`)
anlegen:

```java
public class StudentRepository extends AbstractRepository<Student, Integer> { }
```

Diese Klasse fügt keine weiteren Attribute oder Methoden dem `AbstractRepository` hinzu, sondern legt
nur die Typen der Elemente und des Suchschlüssels fest.

Damit ist die Implementierung des einfachen Hochschul-Verwaltungs-Systems abgeschlossen.

## Was sollten Sie gelernt haben?

* Verwendung mehrerer Typ-Parameter (`E` und `K`).
* Wie Interfaces als Typ-Constraints verwendet werden können.
* Das Zusammenspiel von mehreren generischen Interfaces und Klassen.
* Verwendung der Java-API mit dem Interface `Map` und der Klasse `HashMap`.

## Aufgaben

* Erweitern Sie das Hochschul-Verwaltungs-System um die Möglichkeit, auch Räume zu verwalten.
  Welchen Typ würden Sie als Suchschlüssel für Räume verwenden?
* Erweitern Sie die Repositories um
  * eine Methode, die es erlaubt, alle gespeicherten Objekte im Repository zu löschen;
  * die Funktionalität, die Anzahl der gespeicherten Objekte zurückzugeben.
* Überlegen Sie sich eine Implementierungs-Alternative, die auf das Interface `Identifiable<K>` verzichtet.
  D.h., dass auch der Typ-Constraint im Interface `Repository<E,K>` und in der abstrakten Klasse
  `AbstractRepository<E,K>` wegfällt. Um dies auszugleichen, müsste man dann der Klasse `AbstractRepository<E,K>`
  eine abstrakte Methode `K getID(E element)` hinzufügen, die dann z.B. in der Klasse `StudentRepository`
  implementiert werden müsste.
  Programmieren Sie diese Alternative und überlegen Sie sich die Vor- und Nachteile.

## Fragen

* Wie könnte eine Suche mit mehreren alternativen Schlüsseln implementiert werden,
  sodass also eine Suche sowohl nach Matrikelnummer als auch nach Name möglich wäre?