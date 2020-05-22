package customCollection;

public class CustomCollection<E> extends AbstractCustomCollection<E> {
//*****************Variables*****************
    //Переменная для хранения размера масива
    private int size = 0;
    /**
     * Массив для хранения элементов коллекции
     */
    private Object [] elements;

    //Переменная для хранения среднеарифметического значения в массиве
    private double averageValue;

    private int MAX_VALUE = 0;
    private int MIN_VALUE = 0;

//*****************Constructors*****************
    public CustomCollection() {
        elements = new Object[11];
    }

    public CustomCollection(int size) {
        elements = new Object[size-1];
        this.size = size;
    }

    private enum MAX_MIN_OPTION {
        DELETE,
        ADD
    }
//*****************Methods*****************

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return elements(index);
    }

    @Override
    public boolean add(E element) {
        if (!(element instanceof Integer))
            throw new NumberFormatException();

            checkSize(size + 1);
            if (size > 0)
                elements = changeValues(elements, element, OPTION_CHANGES.INCREASE, size);

            if (size == 0) {
                MAX_VALUE = MIN_VALUE = (Integer) element;
            } else {
                max_min_Matcher(element, MAX_MIN_OPTION.ADD);
                }

            elements[size++] = element;
            return true;
    }

    @Override
    public void add(int index, E element) {
        if (!(element instanceof Integer))
            throw new IllegalArgumentException();
        checkIndex(index);
        checkSize(size + 1);
        elements = changeValues(elements, element, OPTION_CHANGES.INCREASE, size);
        int length = size - index + 1;
        System.arraycopy(elements, index - 1, elements, index, length);
        elements[index- 1] = element;
        size++;
        max_min_Matcher(element, MAX_MIN_OPTION.ADD);
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E oldValue = elements(index);
        elements = changeValues(elements, element, OPTION_CHANGES.INCREASE, size);
        elements[index] = element;
        max_min_Matcher(oldValue, MAX_MIN_OPTION.DELETE);
        return oldValue;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E removedValue = elements(index);
        if (size - 1 >= 1)
            elements = changeValues(elements, removedValue, OPTION_CHANGES.REDUCE, size);
        int length = size - index;
        System.arraycopy(elements,index , elements, index - 1, length);
        elements[--size] = null;
        max_min_Matcher(removedValue, MAX_MIN_OPTION.DELETE);
        return removedValue;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0;i < size; i++)
                if (elements[i] == null) {
                    remove(i + 1);
                    return true;
                }
        } else {
            for (int i = 0;i < size; i++)
                if (o.equals(elements[i])) {
                    remove(i + 1);
                    return true;
                }
        }
        return false;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0;i < size; i++)
                if (elements[i] == null) {
                    remove(i);
                    return i;
                }
        } else {
            for (int i = 0;i < size; i++)
                if (o.equals(elements[i])) {
                    remove(i);
                    return i;
                }
        }
        return -1;
    }

    @Override
    public int maxValue() {
        return MAX_VALUE;
    }

    @Override
    public int minValue() {
        return MIN_VALUE;
    }

    /**
     * Поиск максимального значения в массиве
     */
    private void findMax() {
        MAX_VALUE = Integer.MIN_VALUE;
        for (int i = 0;i < size;i++) {
            int currentElement = (int)elements[i];
            if (MAX_VALUE < currentElement) MAX_VALUE = currentElement;
        }
    }

    /**
     * Поиск минимального значения в массиве
     */
    private void findMin() {
        MIN_VALUE = Integer.MAX_VALUE;
        for (int i = 0;i < size;i++) {
            int newMin = (int) elements[i];
            if (MIN_VALUE > newMin) MIN_VALUE = newMin;
        }
    }

    /**
     * Поиск среднеарифметического значения значений в массиве
     * @return
     */
    @Override
    public double averageValue() {
        int result = 0;
        for (int i = 0; i < elements.length; i++) {
            int element = (Integer) elements[i];
            result += element;
        }
        averageValue = result / size;
        return averageValue / size;
    }

    E elements(int index) {
        return (E) elements[index-1];
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Выход за пределы массива");
    }

    /**
     * Проверка размера
     * @param currentIndex
     */
    private void checkSize(int currentIndex) {
        int checkSize = Math.min(elements.length, currentIndex);
        if ((checkSize - (size + 1)) < 0)
            growElements();
    }

    /**
     * Метод для увеличения размера массива
     */
    private void growElements() {
        int newLength = elements.length + (elements.length >> 1);
        Object [] tmpArr = new Object[newLength];
        System.arraycopy(elements,0, tmpArr, 0, elements.length);
        elements = tmpArr;
       // tmpArr = null; //нужно ли это для GC или он и так удалит этот объект?
        //Или этого делать вообще нельзя? Так как затрётся ссылка и у elements?
    }

    private void max_min_Matcher(E removedValue, MAX_MIN_OPTION option) {
        int elem = (Integer) removedValue;
        switch (option) {
            case DELETE:
                if (MAX_VALUE == elem || MIN_VALUE == elem) {
                    findMax();
                    findMin();
                }else if (elem > 0) {
                    MAX_VALUE -= elem;
                    MIN_VALUE -= elem;
                }else if (elem < 0) {
                    MAX_VALUE += elem;
                    MIN_VALUE += elem;
                }
                break;
            case ADD:
                if (elem > 0) {
                    MAX_VALUE += elem;
                }else {
                    MAX_VALUE -= elem;
                }
                MIN_VALUE += elem;
                if (MIN_VALUE > elem)
                MIN_VALUE = elem;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(elements[i]+ ", ");
        }
        String r = result.substring(0, result.length()-2);
        r = r.concat("]");
        return r;
    }
}
