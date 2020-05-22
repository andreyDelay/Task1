package withArrayListField;

import customCollection.InterfaceCustomCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class MyArrayList<N> implements InterfaceCustomCollection<N> {

    private ArrayList<N> elements;

    private double averageValue;

    private int MAX_VALUE = 0;
    private int MIN_VALUE = 0;

    private N lastAdded;
    private N lastRemoved;

private enum MAX_MIN_OPTION {
    REMOVE,
    ADD
    }

private enum CHANGE_OPTION {
    REDUCE,
    INCREASE
}

    public MyArrayList() {
        elements = new ArrayList<N>();
    }

    public MyArrayList(int size) {
        elements = new ArrayList<N>(size);
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public Iterator<N> iterator() {
        Iterator<N> itr = elements.iterator();
        return itr;
    }

    @Override
    public N get(int index) {
        return elements.get(index);
    }

    @Override
    public boolean add(N n) {
        checkNumberFormat(n);
        lastAdded = n;
        changeValues(lastAdded,CHANGE_OPTION.INCREASE);
        max_min_Matcher(lastAdded, MAX_MIN_OPTION.ADD);
        return elements.add(n);
    }

    @Override
    public void add(int index, N element) {
        checkNumberFormat(element);
        lastAdded = element;
        if (elements.size() > 1) {
            changeValues(lastAdded, CHANGE_OPTION.INCREASE);
        }
        max_min_Matcher(lastAdded, MAX_MIN_OPTION.ADD);
        elements.add(index, element);
    }

    @Override
    public N set(int index, N element) {
        checkNumberFormat(element);
        lastRemoved = elements.set(index, element);
        lastAdded = element;
        changeValues(lastRemoved,CHANGE_OPTION.REDUCE);
        changeValues(lastAdded,CHANGE_OPTION.INCREASE);
        max_min_Matcher(lastRemoved, MAX_MIN_OPTION.REMOVE);
        max_min_Matcher(lastAdded, MAX_MIN_OPTION.ADD);
        return lastRemoved;
    }

    @Override
    public N remove(int index) {
        lastRemoved = elements.remove(index);
        changeValues(lastRemoved,CHANGE_OPTION.REDUCE);
        max_min_Matcher(lastRemoved, MAX_MIN_OPTION.REMOVE);
        return lastRemoved;
    }

    @Override
    public boolean remove(Object o) {
        checkNumberFormat(o);
        boolean trigger = elements.remove(o);
        if (trigger) {
            changeValues(o, CHANGE_OPTION.REDUCE);
            max_min_Matcher(o, MAX_MIN_OPTION.REMOVE);
            return true;
        }
        return false;
    }

    @Override
    public int indexOf(Object o) {
        return elements.indexOf(o);
    }

    @Override
    public int maxValue() {
        return MAX_VALUE;
    }

    @Override
    public int minValue() {
        return MIN_VALUE;
    }

    @Override
    public double averageValue() {
        int result = 0;
        for (int i = 0; i < elements.size(); i++) {
            int element = (Integer) elements.get(i);
            result += element;
        }
        averageValue = (double)result / elements.size();
        return averageValue;
    }

    /**
     * Проверка типа данных в коллекции
     * @param n
     */
    private void checkNumberFormat(Object n) {
        if (!(n instanceof Integer)) {
            throw new NumberFormatException();
        }
    }

    /**
     * Метод, который определяет максимальное и минимально значения,
     * исходя из добавленного / удалённого элемента
     * @param element - удалённый или добавленный элемент
     * @param option - опция ,которая определяет параметр операции
     */
    private void max_min_Matcher(Object element, MAX_MIN_OPTION option) {
        int currentElement = (Integer) element;
        boolean max = false;
        boolean min = false;
        switch (option) {
            case REMOVE:
                if (MAX_VALUE == currentElement) {
                    MAX_VALUE = Integer.MIN_VALUE;
                    for(N n: elements)
                        if ((Integer)n > MAX_VALUE) MAX_VALUE = (Integer) n;
                        max = true;
                }
                if (MIN_VALUE == currentElement) {
                    MIN_VALUE = Integer.MAX_VALUE;
                    for(N n: elements)
                        if ((Integer)n < MIN_VALUE) MIN_VALUE = (Integer) n;
                        min = true;
                }
                if (currentElement > 0) {
                    if(!max)MAX_VALUE -= currentElement;
                    if(!min)MIN_VALUE -= currentElement;
                }else {
                    if(!max)MAX_VALUE += currentElement;
                    if(!min)MIN_VALUE -= currentElement;
                }
                break;
            case ADD:
                if (currentElement > 0) {
                    MAX_VALUE += currentElement;
                }else {
                    MAX_VALUE -= currentElement;
                }
                MIN_VALUE -= currentElement;
                if (MIN_VALUE > currentElement)
                    MIN_VALUE = currentElement;
        }
    }

    /**
     * Метод меняет значения в коллекции в зависимости от выполняемой операции
     * @param element - удалённый или добавленный элемент
     * @param option - опция ,которая определяет параметр операции
     */
    private void changeValues(Object element, CHANGE_OPTION option) {
        Integer currentElement = (Integer)element;
        if (currentElement < 0) currentElement = currentElement * -1;
        switch (option) {
            case REDUCE:
                    ListIterator<N> itrRed = elements.listIterator();
                    while (itrRed.hasNext()) {
                        Integer currElem = (Integer) itrRed.next();
                        N n = (N) (Object) (currElem - currentElement);
                        itrRed.set(n);
                    }
                break;
            case INCREASE:
                ListIterator<N> itrIncr = elements.listIterator();
                while (itrIncr.hasNext()) {
                    Integer currElem = (Integer) itrIncr.next();
                    N n = (N) (Object) (currElem + currentElement);
                    itrIncr.set(n);
                }
                break;
        }
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
