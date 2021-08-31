package lesson4;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SimpleLinkedListImpl<E> implements LinkedList<E>, Iterable<E> {

    protected Node<E> firstElement;
    protected int size;

    @Override
    public void insertFirst(E value) {
        firstElement = new Node<>(value, firstElement);
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = firstElement;
        firstElement = removedNode.next;
        removedNode.next = null;
        size--;

        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        } else if (current == firstElement) {
            removeFirst();
            return true;
        } else {
            previous.next = current.next;
        }

        current.next = null;
        size--;

        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");
        Node<E> current = firstElement;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }

            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }

    @Override
    public E getFirst() {
        return getValue(firstElement);
    }

    protected E getValue(Node<E> eNode) {
        return eNode != null ? eNode.item : null;
    }

    @Override
    public Iterator iterator() {
        Node<E> current = firstElement;
        Iterator<E> iterator = new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return firstElement != null;
            }

            @Override
            public E next() {
                Node<E> current = firstElement;
                E result = current.item;
                firstElement = current.next;
                return result;
            }
        };
        return iterator;

    }

    @Override
    public void forEach(Consumer action) {
        Objects.requireNonNull(action);
        Node<E> current = firstElement;
        while (current != null) {
            action.accept(current.item);
            current = current.next;
        }
    }


    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }
}
