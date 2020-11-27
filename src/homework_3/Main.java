package homework_3;

import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задание 1:");

        String[] words = {"Мир", "Кот", "Собака", "Машина", "Мир", "Собака", "Мышь", "Солнце", "Монитор", "Солнце",
                "Клавиатура", "Мир", "Солнце", "Число", "Строка"};
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word: words) {
            hashMap.put(word,hashMap.getOrDefault(word, 0) + 1);
        }
        System.out.println(Arrays.asList(words));
        System.out.println(hashMap.toString().replace("=",": "));

        System.out.println("==============================");

        System.out.println("Задание 2:");

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Дмитрий", "8973218756");
        phoneBook.add("Мария", "89271209936");
        phoneBook.add("Сергей", "89274054455", "89376458823");
        phoneBook.add("Наталья", "89174873290", "89371037599");
        System.out.println(phoneBook.get("Дмитрий"));
        System.out.println(phoneBook.get("Наталья"));

        System.out.println("==============================");
    }

}
