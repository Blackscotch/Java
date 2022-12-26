package HW5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Likepeople {
    private static HashMap<String, ArrayList<String>> People = new HashMap<>();

    public void AddPeople(String name, String lastname){
        if (People.containsKey(name)) {
            People.get(name).add(lastname);
        }else{
            ArrayList<String> value = new ArrayList<>();
            value.add(lastname);
            People.put(name, value);
        }
    }
    public static void ReadPeople(){
        String[] arr = new String[People.size()];
        People.keySet().toArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
