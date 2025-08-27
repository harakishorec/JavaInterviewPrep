package Karat;


import com.sun.jdi.ArrayReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*
* we are trying to keep similar flowers close together, and want to see what the farthest apart pair fo the same flower are.
*
* */
public class DistantFlower {

    /*
    question to ask for clarification:
    1. what if garden has only one flower, do we need to return -1?

    */

    public static void main(String[] args) {
        String[] garden1 = {"I","R","I","Y","R","D","Ir","R","L"};
        String[] garden2 = {"R"};
        String[] garden3 = {"I","R","Y","A","D","Ir","L","Re","Ro"};
        String[] garden4 = {"S","Ro","S","Re","S","L","S","Ir","Do","S","Y","R","I"};
        String[] garden5 = {"D","Ar","Y","R","I","I","R","Y","A","D","I","L","R","Ro","S","D"};
        String[] garden6 = {"R","R","R","R","R","R"};
        String[] garden7 = {"I","I"};

        System.out.println(farthestDistance(garden1));
        System.out.println(farthestDistance(garden2));
        System.out.println(farthestDistance(garden3));
        System.out.println(farthestDistance(garden4));
        System.out.println(farthestDistance(garden5));
        System.out.println(farthestDistance(garden6));
        System.out.println(farthestDistance(garden7));

    }

    public static int farthestDistance(String[] flowers){

        if(flowers == null || flowers.length == 0) return -1;

        Map<String, List<Integer>> flowerPositionMap = new HashMap<>();
        List<Integer> positionList = null;
        for(int i=0; i< flowers.length; i++){
            if(flowerPositionMap.containsKey(flowers[i])){
                positionList = flowerPositionMap.get(flowers[i]);
            }else{
                positionList = new ArrayList<Integer>();
            }
            positionList.add(i);
            flowerPositionMap.put(flowers[i],positionList);
        }

        int result = -1;
        for(Map.Entry<String, List<Integer>> entryMap: flowerPositionMap.entrySet()){

            List<Integer> position = entryMap.getValue();

            int maxDistance = -1;
            if(!position.isEmpty()){
                maxDistance= position.get((position.size()-1)) - position.get(0);
            }

            result = Math.max(result,maxDistance);
        }

        return result > 0 ? result : -1;
    }



    /**
     * Time Complexity: O(n) --> Since there are two independent for loops
     * Space complexity: O(n) --> Since only one map was created to hold all the positions
     *
     * */
}