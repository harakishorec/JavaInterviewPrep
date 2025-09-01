package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice2_subStrWithKDist {

    public static void main(String[] args) {
        Practice2_subStrWithKDist subStrWithKDist = new Practice2_subStrWithKDist();
        System.out.println(subStrWithKDist.isSubWithKPresent("eeeba",2));
        System.out.println(subStrWithKDist.isSubWithKPresent("abcaab",2));
        System.out.println(subStrWithKDist.isSubWithKPresent("aaa",2));

        System.out.println(subStrWithKDist.maxSubstrWithK("eeeba",2));
        System.out.println(subStrWithKDist.maxSubstrWithK("abcaab",2));
        System.out.println(subStrWithKDist.maxSubstrWithK("aaa",2));
    }

    public int maxSubstrWithK(String mainString, int k){
        int maxCharLen = 0;

        Map<Character,Integer> map = new HashMap<>();
        List<Character> result = new ArrayList<>();
        int left = 0;
        String longestSubString = "";

        for(int right = 0; right < mainString.length(); right++){
            char c1 = mainString.charAt(right);
            map.put(c1, map.getOrDefault(c1,0)+1);
            result.add(c1);

            while(map.size() > k){
                char c2 = mainString.charAt(left);
                if(map.get(c2)==1)
                    map.remove(c2);
                else
                    map.put(c2, map.getOrDefault(c2,1)-1);
                result.remove(0);
                left++;
            }

            if(map.size() == k && result.size() > maxCharLen){
                maxCharLen = result.size();
                StringBuilder sb = new StringBuilder();
                for(char c: result){
                    sb.append(c);
                }
                longestSubString = sb.toString();
            }
        }
        System.out.println("Longest SubString: "+ longestSubString);
        return maxCharLen;
    }


    public boolean isSubWithKPresent(String mainString, int k){

        Map<Character,Integer> mainStrMap = new HashMap<>();
        List<Character> result = new ArrayList<>();
        int left = 0;

        for(int right =0; right<mainString.length();right++){
            char c1 = mainString.charAt(right);
            mainStrMap.put(c1,mainStrMap.getOrDefault(c1,0)+1);
            result.add(c1);

            while(mainStrMap.size() > k){
                char c2 = mainString.charAt(left);
                if(mainStrMap.get(c2) == 1)
                    mainStrMap.remove(c2);
                else
                    mainStrMap.put(c2,mainStrMap.getOrDefault(c2,1)-1);
                result.remove(0);
            }
            if(mainStrMap.size() == k && result.size() > 0){
                System.out.println("Match Found");
                return true;
            }
        }
        return false;
    }


}
