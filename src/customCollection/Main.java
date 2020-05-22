package customCollection;

public class Main {
    public static void main(String[] args) {
        CustomCollection<Integer> customCollection = new CustomCollection<>();

        customCollection.add(2);
        System.out.println("Массив после добавления 2 : " + customCollection.toString());
        System.out.println("size:  " + customCollection.size());
        System.out.println("MIN: " + customCollection.minValue());
        System.out.println("MAX: " + customCollection.maxValue());
        System.out.println("======================================");

        customCollection.add(3);
        System.out.println("Массив после добавления 3 : " + customCollection.toString());
        System.out.println("size:  " + customCollection.size());
        System.out.println("MIN: " + customCollection.minValue());
        System.out.println("MAX: " + customCollection.maxValue());
        System.out.println("======================================");

        customCollection.add(10);
        System.out.println("Массив после добавления 10 : " + customCollection.toString());
        System.out.println("size:  " + customCollection.size());
        System.out.println("MIN: " + customCollection.minValue());
        System.out.println("MAX: " + customCollection.maxValue());
        System.out.println("======================================");

        customCollection.add(-50);
        System.out.println("Массив после добавления -50 : " + customCollection.toString());
        System.out.println("size:  " + customCollection.size());
        System.out.println("MIN: " + customCollection.minValue());
        System.out.println("MAX: " + customCollection.maxValue());
        System.out.println("======================================");

        customCollection.add(13);
        System.out.println("Массив после добавления 13 : " + customCollection.toString());
        System.out.println("size:  " + customCollection.size());
        System.out.println("MIN: " + customCollection.minValue());
        System.out.println("MAX: " + customCollection.maxValue());
        System.out.println("======================================");

        customCollection.remove(5);
        System.out.println("Массив после удаления 13 : " + customCollection.toString());
        System.out.println("size:  " + customCollection.size());
        System.out.println("MIN: " + customCollection.minValue());
        System.out.println("MAX: " + customCollection.maxValue());
        System.out.println("======================================");

        customCollection.remove(new Integer(-9));
        System.out.println("Массив после удаления -9 : " + customCollection.toString());
        System.out.println("size:  " + customCollection.size());
        System.out.println("MIN: " + customCollection.minValue());
        System.out.println("MAX: " + customCollection.maxValue());
        System.out.println("======================================");

        customCollection.add(222);
        System.out.println("Массив после добавления 222 : " + customCollection.toString());
        System.out.println("size:  " + customCollection.size());
        System.out.println("MIN: " + customCollection.minValue());
        System.out.println("MAX: " + customCollection.maxValue());
        System.out.println("======================================");

        System.out.println("size:  " + customCollection.size());
        customCollection.remove(customCollection.size());
        System.out.println("Массив после удаления последнего элемента : " + customCollection.toString());
        System.out.println("size:  " + customCollection.size());
        System.out.println("MIN: " + customCollection.minValue());
        System.out.println("MAX: " + customCollection.maxValue());
        System.out.println("======================================");

        customCollection.add(1, 1);
        customCollection.add(1, 1);
        customCollection.add(1, 1);
        customCollection.add(1, 1);
        customCollection.add(1, 1);
        customCollection.add(1, 1);
        customCollection.add(1, 1);
        customCollection.add(1, 1);
        customCollection.add(1, 1);
        customCollection.add(1, 1);
        customCollection.add(1, 1);
        customCollection.add(1, 1);
        customCollection.add(1, 1);
        customCollection.add(1, 1);
        customCollection.add(1, 1);
        customCollection.add(1, 1);

        System.out.println(customCollection.size());
        System.out.println(customCollection.toString());
        System.out.println(customCollection.maxValue());
        System.out.println(customCollection.minValue());
    }
}
