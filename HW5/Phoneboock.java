package HW5;

import java.util.ArrayList;
import java.util.HashMap;

public class Phoneboock {
    private static HashMap<String, ArrayList<String>> PhNumbers = new HashMap<>();

    public void AddContact(String name, String number){
        if (PhNumbers.containsKey(name)) {
            PhNumbers.get(name).add(number);
        }else{
            ArrayList<String> value = new ArrayList<>();
            value.add(number);
            PhNumbers.put(name, value);
        }
    }
    public void FindName(String name){
        if (PhNumbers.containsKey(name)) {
            System.out.println("Телефоны: "+PhNumbers.get(name));
        }else{
            System.out.println("Контакт не найден");
        }
    }
}
