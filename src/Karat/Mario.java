package Karat;

import java.util.*;

public class Mario {

    public static void main(String[] args) {

        String ins1 = "RRRJJRRR";
        String ins2 = "RRRLJ";
        String ins3 = "RRRJJRRRL";
        String ins4 = "RRRLRJJRRR";
        String ins5 = "RRRRRRRRRR";
        String ins6 = "RRJJJJ";
        String ins7 = "RLRRRJJRRLLJJJLRRRJJRRR";
        String ins8 = "RRRJJRLJJJRRR";
        String ins9 = "R";
        String ins10 = "RJJJJR";
        String ins11 = "RJJRRRJ";

        int[] obs1 = {4, 6};
        int[] obs2 = {2, 9, 4};
        int[] obs3 = {};

        System.out.println(reachEnd(obs1, ins1));
        System.out.println(reachEnd(obs1, ins2));
        System.out.println(reachEnd(obs1, ins3));
        System.out.println(reachEnd(obs1, ins4));
        System.out.println(reachEnd(obs1, ins5));
        System.out.println(reachEnd(obs1, ins6));
        System.out.println(reachEnd(obs1, ins7));
        System.out.println(reachEnd(obs1, ins8));
        System.out.println(reachEnd(obs1, ins9));
        System.out.println(reachEnd(obs1, ins10));
        System.out.println(reachEnd(obs2, ins11));
        System.out.println(reachEnd(obs3, ins9));
    }

    public static boolean reachEnd(int[] options, String instructions) {

        if (instructions == null || instructions.length() == 0) return false;

        int i = 0;
        char prevPosition = 'R';

        Set<Integer> optionsSet = new HashSet<>();
        if (optionsSet != null && options.length > 0) {
            for (int opt : options) {
                optionsSet.add(opt);
            }

            for (char c : instructions.toCharArray()) {
                if (options != null && optionsSet.contains(i)) {
                    return false;
                }
                if (c == 'R') {
                    i++;
                    prevPosition = 'R';
                }
                if (c == 'L') {
                    i--;
                    prevPosition = 'L';
                }
                if (c == 'J') {
                    i = prevPosition == 'R' ? i + 2 : i - 2;
                }
                if (i == 10) {
                    return true;
                }
            }
        }
        return false;
    }
}