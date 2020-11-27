package homework_3;

import java.util.*;

public class PhoneBook {
    protected final HashMap<String, List<String>> phoneBook = new HashMap<>();

    public void add(String name, String phoneNumber) {
        phoneBook.put(name, new LinkedList<>(Collections.singletonList(phoneNumber)));
    }

    public void add(String name, String... phoneNumbers) {
        phoneBook.put(name, new LinkedList<>(Arrays.asList(phoneNumbers)));
    }

    public String get(String name) {
        return name + ":" + "\nТелефон:" + phoneBook.get(name);
    }

}
