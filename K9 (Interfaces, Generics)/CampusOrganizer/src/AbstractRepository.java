import java.util.HashMap;
import java.util.Map;

// Store multiple T objects that can be extracted via an id.
// type parameters:
// T: type of stored objects
// K: key under which object can be search
abstract public class AbstractRepository<T extends Identifiable<K>, K> implements Repository<T,K> {

    Map<K, T> elements;

    public AbstractRepository() {
        elements = new HashMap<K, T>();
    }

    @Override
    public void add(T element) {
        elements.put(element.getID(), element);
    }

    @Override
    public T search(K key) {
        return elements.get(key);
    }

    @Override
    public boolean delete(K key) {
        return elements.remove(key) == null ? false : true;
    }

    @Override
    public String toString() {
        String result = "";
        for (T element : elements.values()) {
            result += element + "\n";
        }
        return result;
    }
}
