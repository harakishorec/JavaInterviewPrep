package Karat;

import java.util.*;

public class IJustCannotChoose {

    public static void main(String[] args) {

        List<Integer> endings1 = List.of(6,15,21,30);
        int[][] choices1_1 = {
                {3,7,8},
                {9,4,2}
        };
        int[][] choices1_2 = {
                {3,14,2}
        };
        int[][] choices1_3 = {
                {5,11,28},
                {9,19,29},
                {14,16,20},
                {18,7,22},
                {25,6,30}
        };
        int[][] choices1_4 = {
                {2,10,15},
                {3,4,10},
                {4,3,15},
                {10,3,15}
        };

        List<Integer> endings2 = List.of(11);
        int[][] choices2_1= {
                {2,3,4},
                {5,10,2}
        };
        int[][] choices2_2= {
                {}
        };

        List<Integer> endings3 = List.of(4,11);
        int[][] choices3_1= {
                {10,6,8}
        };

        System.out.println(choose(endings1,choices1_1,1));
        System.out.println(choose(endings1,choices1_1,2));
        System.out.println(choose(endings1,choices1_2,1));
        System.out.println(choose(endings1,choices1_2,2));
        System.out.println(choose(endings1,choices1_3,1));
        System.out.println(choose(endings1,choices1_3,2));
        System.out.println(choose(endings1,choices1_4,1));
        System.out.println(choose(endings1,choices1_4,2));
        System.out.println(choose(endings2,choices2_1,1));
        System.out.println(choose(endings2,choices2_1,2));
        System.out.println(choose(endings2,choices2_2,1));
        System.out.println(choose(endings2,choices2_2,2));
        System.out.println(choose(endings3,choices3_1,1));
        System.out.println(choose(endings3,choices3_1,2));
    }

    public static int choose(List<Integer> endings, int[][] choices,int option){

        if(choices == null || choices.length == 0){
            return -1;
        }

        Map<Integer, List<Integer>> choiceMap = new HashMap<>();

        for(int[] choice: choices){
            if(choice.length >= 3){
                choiceMap.put(choice[0],List.of(choice[1],choice[2]));
            }
        }
        Set<Integer> pagesCompleted = new HashSet<>();
        int i =1;

        while(true){

            if(endings.contains(i)){
                return i;
            }
            if(pagesCompleted.contains(i)){
                return -1;
            }
            pagesCompleted.add(i);

            if(choiceMap.containsKey(i)){
                i = (option == 1) ? choiceMap.get(i).get(0) : choiceMap.get(i).get(1);
            }else{
                i++;
            }
        }
    }
}