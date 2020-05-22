package withArrayListField;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(-2);
        myArrayList.add(-5);
        System.out.println("Коллекция после добавления 5 элементов : " + myArrayList);
        System.out.println("Max элемент: " + myArrayList.maxValue());
        System.out.println("Min элемент: " + myArrayList.minValue());

        myArrayList.remove(new Integer(-5));
        System.out.println("Коллекция после удаления значения 5 : " + myArrayList);
        System.out.println("Max элемент: " + myArrayList.maxValue());
        System.out.println("Min элемент: " + myArrayList.minValue());

        myArrayList.remove(3);
        System.out.println("Коллекция после удаления 3-го элемента : " + myArrayList);
        System.out.println("Max элемент: " + myArrayList.maxValue());
        System.out.println("Min элемент: " + myArrayList.minValue());

        System.out.println(myArrayList.averageValue());
        System.out.println(myArrayList);
    }
}
