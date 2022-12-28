package HW5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        // System.out.println(People);
    }

    public static void ReadPeople(){
        // Map<String, Integer> sortMap = new LinkedHashMap<>();
        // int max  = 1;
        // for (int value : People.values()) {
            
        // }
        // for (var item : People.entrySet()) {
        //     if (item.getValue().size() > 1){
        //         System.out.printf("[%s]: [%s]\n", item.getKey(), item.getValue().size());
        //     }
            
        // }
        // System.out.println(People.values());
    }
}
