package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class SlidingWindowStringInclusion {

    public static void main(String[] args) {
        SlidingWindowStringInclusion sw = new SlidingWindowStringInclusion();
        System.out.println(sw.checkInclusion("walmdart","tar"));
    }

    public boolean checkInclusion(String mainString, String searchString) {

        Hashtable<Character , Integer> hashtable1 = new Hashtable<>();
        Hashtable<Character , Integer> hashtable2 = new Hashtable<>();
        List<Character> res = new ArrayList<>();

        for(char c: searchString.toCharArray()){
            hashtable1.put(c, hashtable1.getOrDefault(c,0)+1);
        }

        for(int i =0; i<mainString.length(); i++){
            char c1 = mainString.charAt(i);
            hashtable2.put(c1, hashtable2.getOrDefault(c1,0)+1);
            res.add(c1);

            if(i >= searchString.length()){
                char c2 = mainString.charAt(i-searchString.length());
                if(hashtable2.get(c2) == 1){
                    hashtable2.remove(c2);
                }else{
                    hashtable2.put(c2, hashtable2.getOrDefault(c2, 1)-1);
                }
                res.remove(0);
            }

            if(hashtable1.equals(hashtable2)){
                System.out.println("Found Match of search string");
                System.out.println(Arrays.toString(res.toArray()));
                return true;
            }
        }
        return false;
    }
}
