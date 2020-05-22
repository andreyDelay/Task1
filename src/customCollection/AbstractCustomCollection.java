package customCollection;

import java.util.Iterator;

public abstract class AbstractCustomCollection<E> implements InterfaceCustomCollection<E> {

    public enum OPTION_CHANGES {
        REDUCE,
        INCREASE
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int maxValue() {
        return 0;
    }

    @Override
    public int minValue() {
        return 0;
    }

    @Override
    public double averageValue() {
        return 0;
    }

    public static Object [] changeValues(Object [] elements,Object newElement, OPTION_CHANGES t, int size) {
        int newEl = (Integer) newElement;
        if (newEl < 0) newEl = newEl * -1;
        switch (t) {
            case REDUCE:
                for (int i = 0; i < size; i++) {
                    int currentElement = (Integer) elements[i];
                    elements[i] = currentElement - newEl;
                }
                break;
            case INCREASE:
                for (int i = 0; i < size; i++) {
                    int currentElement = (Integer) elements[i];
                    elements[i] = currentElement + newEl;
                }
                break;
        }
        return elements;
    }
}
