package customCollection;

import java.util.Iterator;

public interface InterfaceCustomCollection<E> extends Iterable<E> {
    int size();

    boolean isEmpty();

    Iterator<E> iterator();


//********************Поиск элемента по индексу********************
    E get(int index);

//********************Добавление элементов********************
    boolean add(E e);

    void add(int index, E element);

    E set(int index, E element);
//********************Удаление элементов********************
    E remove(int index);

    boolean remove(Object o);
//********************Поиск элемента по значению********************
    int indexOf(Object o);

//********************Поиск MAX & MIN элемента********************
    int maxValue();

    int minValue();

//********************Поиск average элемента********************
    double averageValue();
}
