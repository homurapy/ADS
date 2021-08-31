package lesson4;

public class DequeImpl<E> extends TwoSideLinkedListImpl<E>{
    public boolean removeLast() {
        remove(getLast());
        return true;
    }
}
