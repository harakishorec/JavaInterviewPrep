package DynamicProgramming;

import java.awt.image.ImageProducer;
import java.util.*;

public class Practice2_StringInclusion {

    public static void main(String[] args) {
        Practice2_StringInclusion si = new Practice2_StringInclusion();
        System.out.println(si.StringInclusion("Morning","gin"));
    }

    public boolean StringInclusion(String mainString, String searchString){

        Map<Character,Integer> searchStringMap = new HashMap<>();
        Map<Character,Integer> mainStrMap = new HashMap<>();
        List<Character> result = new ArrayList<>();

        for(Character c : searchString.toCharArray()){
            searchStringMap.put(c, searchStringMap.getOrDefault(c,0)+1);
        }

        for(int i=0; i<mainString.length();i++){
            char c1 = mainString.charAt(i);
            mainStrMap.put(c1, mainStrMap.getOrDefault(c1,0)+1);
            result.add(c1);

            if(i >= searchString.length()){
                char c2 = mainString.charAt(i - searchString.length());
                if(mainStrMap.get(c2) == 1)
                    mainStrMap.remove(c2);
                else
                    mainStrMap.put(c2,mainStrMap.getOrDefault(c2,1)-1);
                result.remove(0);
            }

            if(mainStrMap.equals(searchStringMap)){
                System.out.println("Match Found");
                System.out.println(Arrays.toString(result.toArray()));
                return true;
            }
        }
        return false;
    }
}
