package Karat;

import java.util.*;

public class Password {

    public static void main(String[] args) {

        String password1 = "Stringpwd9999#abc";
        String password2 = "Less10#";
        String password3 = "Password@";
        String password4 = "#PassWord011111112222223x";
        String password5 = "password#1111111";
        String password6 = "aaaapassword$$";
        String password7 = "LESS10#";
        String password8 = "SsSSSt#passWord";
        String password9 = "SsSSSt#passWordpassword";
        String password10 = "aZ*";

        System.out.println(rulesNotMet(password1));
        System.out.println(rulesNotMet(password2));
        System.out.println(rulesNotMet(password3));
        System.out.println(rulesNotMet(password4));
        System.out.println(rulesNotMet(password5));
        System.out.println(rulesNotMet(password6));
        System.out.println(rulesNotMet(password7));
        System.out.println(rulesNotMet(password8));
        System.out.println(rulesNotMet(password9));
        System.out.println(rulesNotMet(password10));
    }

    public static List<Integer> rulesNotMet(String password){

        List<Integer> rulesNotMetList = new ArrayList<>();

        if(password.length() == 0 || password == null) return new ArrayList<>();

        if(password.length() >0 && password.length() < 16) rulesNotMetList.add(1);

        if(password.toLowerCase().contains("password")) rulesNotMetList.add(2);

        Map<Character, Integer> charCountMap = new HashMap<>();
        for(char c: password.toCharArray()){
            charCountMap.put(c,charCountMap.getOrDefault(c,0)+1);
        }
        for(int i: charCountMap.values()){
            if(i>4){
                rulesNotMetList.add(3);
                break;
            }
        }

        boolean hasLower = false;
        boolean hasUpper = false;
        for(char c1: charCountMap.keySet()){
            if(hasUpper && hasLower) {
                break;
            }else{
                if(Character.isUpperCase(c1)) hasUpper = true;
                if(Character.isLowerCase(c1)) hasLower = true;
            }
        }
        if(!hasLower || !hasUpper) rulesNotMetList.add(4);

        Set<Character> specialCharSet = Set.of('*','#','@');
        boolean hasSpecialChar = false;
        for(char c1: charCountMap.keySet()){
            if(specialCharSet.contains(c1)) hasSpecialChar = true;
        }
        if(!hasSpecialChar) rulesNotMetList.add(5);

        return rulesNotMetList;
    }

}