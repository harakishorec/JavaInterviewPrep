package Karat;

import java.util.*;

public class GroupingByNumberOfConnections {


    public static void main(String[] args) {

        String[][] events = {
                {"Connect","Alice","Bob"},
                {"Disconnect","Bob","Alice"},
                {"Connect","Alice","Charlie"},
                {"Connect","Dennis","Bob"},
                {"Connect","Pam","Dennis"},
                {"Disconnect","Pam","Dennis"},
                {"Connect","Pam","Dennis"},
                {"Connect","Edward","Bob"},
                {"Connect","Dennis","Charlie"},
                {"Connect","Alice","Nicole"},
                {"Connect","Pam","Edward"},
                {"Disconnect","Dennis","Charlie"},
                {"Connect","Dennis","Edward"},
                {"Connect","Charlie","Bob"}


        };

        System.out.println(getConnectionGroups(events, 3));
        System.out.println(getConnectionGroups(events, 1));
        System.out.println(getConnectionGroups(events, 10));

    }

    public static Map<String, Set<String>> getConnectionGroups(String[][] events, int n){

        Map<String, Set<String>> finalUserConnectionMap= new HashMap<>();
        Map<String, Integer> userConnectionMap= new HashMap<>();
        Set<String> connectionsLessThanN = new HashSet<>();
        Set<String> connectionsEqOrMoreThanN = new HashSet<>();

        for(String[] event: events){
            String action = event[0];
            String user1 = event[1];
            String user2 = event[2];

            if(action.equalsIgnoreCase("Connect")){
                userConnectionMap.put(user1,userConnectionMap.getOrDefault(user1,0)+1);
                userConnectionMap.put(user2,userConnectionMap.getOrDefault(user2,0)+1);
            }else{
                userConnectionMap.put(user1,userConnectionMap.getOrDefault(user1,0)-1);
                userConnectionMap.put(user2,userConnectionMap.getOrDefault(user2,0)-1);
            }
        }

        for(Map.Entry<String,Integer> usersEntry: userConnectionMap.entrySet()){
            if(usersEntry.getValue() < n){
                connectionsLessThanN.add(usersEntry.getKey());
            }else{
                connectionsEqOrMoreThanN.add(usersEntry.getKey());
            }
        }

        finalUserConnectionMap.put("Connection Less than " + n,connectionsLessThanN);
        finalUserConnectionMap.put("Connection Eq or More than " + n,connectionsEqOrMoreThanN);
        return finalUserConnectionMap;
    }
}