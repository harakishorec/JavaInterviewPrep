package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlidingWindowSubstringWithKDistinctChar {

    public static void main(String[] args) {
        SlidingWindowSubstringWithKDistinctChar dstch = new SlidingWindowSubstringWithKDistinctChar();

        System.out.println(dstch.longestSubstringWithKDistinct("eeeba", 2)); // 4
        System.out.println(dstch.longestSubstringWithKDistinct("abcaab", 2)); // 3
        System.out.println(dstch.longestSubstringWithKDistinct("aaa", 2));   // 0
    }

    public int longestSubstringWithKDistinct(String mainString, int k){

        if(mainString == null || mainString.length() == 0 || k == 0) return 0;

        int maxCharLength = 0;
        Map<Character,Integer> mapCh = new HashMap<>();
        int left = 0;
        List<Character> res = new ArrayList<>();
        String longestSubstring = "";

        for(int right = 0; right < mainString.length(); right++){
            char c1 = mainString.charAt(right);
            mapCh.put(c1, mapCh.getOrDefault(c1,0)+1);
            res.add(c1);

            while(mapCh.size() > k){
                char c2 = mainString.charAt(left);
                if(mapCh.get(c2) == 1)
                    mapCh.remove(c2);
                else
                    mapCh.put(c2, mapCh.getOrDefault(c2,1)-1);
                res.remove(0);
                left++;
            }
            if(mapCh.size() == k && res.size() > maxCharLength){
                maxCharLength = res.size();

                StringBuilder stringBuilder = new StringBuilder();
                for(char ch: res){
                    stringBuilder.append(ch);
                }
                longestSubstring = stringBuilder.toString();
            }
        }

        System.out.println("Longest Substring: "+ longestSubstring);
        return maxCharLength;

    }
}
