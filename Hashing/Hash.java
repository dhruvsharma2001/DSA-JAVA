import java.util.*;
public class Hash {
    public static void main(String args[]){
        //create
        HashMap<String, Integer> hp = new HashMap<>();

        //insert
        hp.put("india", 100);
        hp.put("china", 150);
        hp.put("us", 50);

        System.out.println(hp);

        //get
        int popu = hp.get("india");
        System.out.println(popu);

        //contains key
        System.out.println(hp.containsKey("south africa"));

        //Iteration
        Set<String> keys = hp.keySet();
        System.out.println(keys);
        //foreach
        for (String k:keys){
            System.out.println("key=" + k);
        
        }
    }
    
}
