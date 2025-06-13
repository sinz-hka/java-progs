package K09_Interfaces_Generics.CampusOrganizer;

import java.util.HashMap;
import java.util.Map;

abstract public class AbstractRepository<E extends Identifiable<K>, K> implements Repository<E,K> {

    private Map<K,E> elements;

    public AbstractRepository() {
        elements = new HashMap<K,E>();
    }

    @Override
    public void add(E element) {
        // put(): from interface Map<K,E>
        // getID(): from type constraint Identifiable<K> on E
        elements.put(element.getID(), element);
    }

    @Override
    public E search(K key) {
        // get(): from interface Map<K,E>
        return elements.get(key);
    }

    @Override
    public boolean delete(K key) {
        // remove(): from interface Map<K,E>
        return elements.remove(key) == null ? false : true;
    }

    @Override
    public String toString() {
        // StringBuilder is more efficient than using String
        StringBuilder result = new StringBuilder();
        for (E element : elements.values()) {
            result.append(element + "\n");
        }
        return result.toString();
    }
}