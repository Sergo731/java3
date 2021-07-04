package ru.geekbrains;

import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {

//      1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);

        String[] arr = {"123", "abc", "77", "731", "aa"};
        System.out.println("Task_1\n" + Arrays.toString(arr));
        swapElements(arr, 2, 3);
        System.out.println(Arrays.toString(arr));

//      2. Написать метод, который преобразует массив в ArrayList;

        List<String> list = converToList(arr);
        System.out.println("Task_2\n" + list.getClass() + " : " + list);

//      3. Большая задача: a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
//      b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта,
//      поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//      c. Для хранения фруктов внутри коробки можете использовать ArrayList;
//      d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и
//      вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
//      e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
//      которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае
//      (коробки с яблоками мы можем сравнивать с коробками с апельсинами);
//      f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов,
//      нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается,
//      а в другую перекидываются объекты, которые были в этой коробке;
//      g. Не забываем про метод добавления фрукта в коробку.

        System.out.println("Task 3");
        Orange orange = new Orange();
        Apple apple = new Apple();
        Box<Orange> orangeBox_1 = new Box();
        Box<Orange> orangeBox_2 = new Box();
        Box<Apple> appleBox = new Box();
        orangeBox_1.add(new Orange());
        orangeBox_1.add(new Orange());

        for (int i = 0; i < 7; i++) {
            orangeBox_2.add(new Orange());
        }
        for (int i = 0; i < 10; i++) {
            appleBox.add(new Apple());
        }

        orangeBox_1.info();
        orangeBox_2.info();
        appleBox.info();

        Float orange1_Weigth = orangeBox_1.getWeight();
        Float orange2_Weigth = orangeBox_2.getWeight();
        Float appleWeigth = appleBox.getWeight();
        System.out.println("Вес 1 коробки с апельсинами: " + orange1_Weigth);
        System.out.println("Вес 2 коробки с апельсинами: " + orange2_Weigth);
        System.out.println("Вес коробки с яблоками: " + appleWeigth);

        System.out.println("Сравнить вес orangeBox_1 и appleBox: " + orangeBox_1.compare(appleBox));
        System.out.println("Сравнить вес orangeBox_2 и appleBox: " + orangeBox_2.compare(appleBox));

        orangeBox_1.moveAt(orangeBox_2);

        orangeBox_1.info();
        orangeBox_2.info();
        appleBox.info();
    }

    private static <T> void swapElements(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static <E> List<E> converToList(E[] array) {
        return Arrays.asList(array);
    }
}
