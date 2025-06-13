package K09_Interfaces_Generics.CampusOrganizer;

public interface Repository<T,K> {
    void add(T element); // T must have a key
    T search(K key);
    boolean delete(K key); // returns true iff an element was deleted
}
