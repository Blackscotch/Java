package HW5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
    }

    public static void ReadPeople(){
        Map<String, Integer> sortMap = new LinkedHashMap<>();
        int max = 0;
        for (var item : People.entrySet()) {
            if (item.getValue().size() > max) {
                max = item.getValue().size();
            }    
        }
        System.out.println(People);
        
        for (int i = max; i > 1; i--){
            for (var item : People.entrySet()) {
                if (item.getValue().size() == i){
                    sortMap.put(item.getKey(), item.getValue().size());
                }
            }
            
        }
        System.out.println(sortMap);
    }
}
