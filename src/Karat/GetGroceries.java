package Karat;

import java.util.*;

public class GetGroceries {

    public static void main(String[] args) {
        String[][] products = {
                {"Cheese","Dairy"},
                {"Carrots","Produce"},
                {"Potatoes","Produce"},
                {"Canned Tuna","Pantry"},
                {"Romaine Lettuce","Produce"},
                {"Chocolate Milk","Dairy"},
                {"Flour","Pantry"},
                {"Iceberg Lettuce","Produce"},
                {"Coffee","Pantry"},
                {"Pasta","Pantry"},
                {"Milk","Dairy"},
                {"Blueberries","Produce"},
                {"Pasta Sauce","Pantry"}
        };

        String[] list1 = {"Blueberries","Milk","Coffee","Flour","Cheese","Carrots"};
        String[] list2 = {"Blueberries","Carrots","Coffee","Milk","Flour","Cheese"};
        String[] list3 = {"Blueberries","Carrots","Romaine Lettuce","Iceberg Lettuce"};
        String[] list4 = {"Milk","Flour","Chocolate Milk","Pasta Sauce"};
        String[] list5 = {"Cheese","Potatoes","Blueberries","Canned Tuna"};


        System.out.println(shopping(products,list1));
        System.out.println(shopping(products,list2));
        System.out.println(shopping(products,list3));
        System.out.println(shopping(products,list4));
        System.out.println(shopping(products,list5));
    }

    public static int shopping(String[][] products, String[] list){

        Map<String,String> seqMap = new HashMap<String, String>();
        Set<String> deptSet = new HashSet<String>();
        for(String[] s: products){
            seqMap.put(s[0],s[1]);
        }

        int seqCount = 0;
        int effCount;
        String currDept = "";
        for(String item: list){
            if(!currDept.equalsIgnoreCase(seqMap.get(item))){
                currDept = seqMap.get(item);
                seqCount++;
            }
            deptSet.add(seqMap.get(item));
        }
        effCount = deptSet.size();

        return seqCount-effCount;
    }
}