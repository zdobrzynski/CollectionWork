package us.mattgreen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private final static FileInput indata = new FileInput("C:\\Users\\zdobe\\Documents\\Advanced Java\\Collection Work\\Collection Work\\src\\the_book.csv");
    private final static Map<String, Integer> map = new HashMap<String, Integer>();

    public static void main(String[] args) {
        String line;
        String[] words;
        Object wordFound;
     //   String[] fields;
        ArrayList<String> singleUse = new ArrayList<String>();
        String[] topWords = new String[]{"String,0","String,0","String,0","String,0","String,0","String,0","String,0","String,0","String,0","String,0"};


        while ((line = indata.fileReadLine()) != null) {
            line=line.replace(",","").replace(".","")
                    .replace(";","").replace(":","")
                    .replace("'","").replace("\"","")
                    .replace("-","").replace("!","")
                    .replace("#","").replace("(","")
                    .replace(")","").replace("?","")
                    .replace("_"," ").replace("?","")
                    .toLowerCase().trim();
            words = line.split(" ");
            for (String s:words) {
                wordFound = map.get(s);
                if (wordFound == null) {
                    map.put(s, new Integer(1));
                }
                else {
                    map.put(s, map.get(s) + 1);
                }

            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                //System.out.println(entry.getKey() + " " + entry.getValue());
                System.out.println("Getting all of the words......Please Wait....");
            }
        }


        for (String i : map.keySet()){
            if(map.get(i) == 1){
                singleUse.add(i);
            }
        }

        System.out.println("The number of words used once is: " + singleUse.size());

    }
    
}