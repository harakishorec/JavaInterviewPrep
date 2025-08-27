package Karat;

import java.util.*;

public class EntryWithoutExits {
/*
* Code which has an ordered list of entry and exit events fro employees and should return two lists:
* 1. List of all employees with only Entry ( and no exit)
* 2. List of all employees with only exits ( and no entries)
*sadfsd
* test fildsfesdf
* sdfs
* */
    public static void main(String[] args) {
        String[][] r1 = {
                {"Paul", "enter"},
                {"Pauline", "exit"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Martha", "exit"},
                {"Joe", "enter"},
                {"Martha", "enter"},
                {"Steve", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "enter"},
                {"Joe", "enter"},
                {"Curtis", "exit"},
                {"Curtis", "enter"},
                {"Joe", "exit"},
                {"Martha", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "exit"},
                {"Joe", "enter"},
                {"Joe", "enter"},
                {"Martha", "exit"},
                {"Joe", "exit"},
                {"Joe", "exit"}
        };

        String[][] r2 = {
                {"Paul", "enter"},
                {"Paul", "exit"}
        };

        String[][] r3 = {
                {"Paul", "enter"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"}
        };

        String[][] r4 = {
                {"Raj", "enter"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"},
                {"Paul", "enter"},
                {"Raj", "enter"}
        };

        System.out.println(getEntryExitLists(r1));
        System.out.println(getEntryExitLists(r2));
        System.out.println(getEntryExitLists(r3));
        System.out.println(getEntryExitLists(r4));

    }

    public static Map<String,Set<String>> getEntryExitLists(String[][] records){
        Map<String, Set<String>> resultMap = new HashMap<>();
        Set<String> entryWithoutExit = new HashSet<>();
        Set<String> exitWithoutEntry = new HashSet<>();

        // Track if an employee is currently "inside" (true) or "outside" (false)
        Map<String, Boolean> inside = new HashMap<>();

        for (String[] record : records) {
            String empName = record[0];
            String empAction = record[1];

            boolean isInside = inside.getOrDefault(empName, false);

            if (empAction.equalsIgnoreCase("enter")) {
                // Enter while already inside -> Entry without Exit
                if (isInside) {
                    entryWithoutExit.add(empName);
                }
                inside.put(empName, true);
            } else if (empAction.equalsIgnoreCase("exit")) {
                // Exit while already outside -> Exit without Entry
                if (!isInside) {
                    exitWithoutEntry.add(empName);
                } else {
                    inside.put(empName, false);
                }
            }
        }

        // Anyone still inside at the end -> Entry without Exit
        for (Map.Entry<String, Boolean> e : inside.entrySet()) {
            if (e.getValue()) {
                entryWithoutExit.add(e.getKey());
            }
        }

        resultMap.put("Entry Without Exit", entryWithoutExit);
        resultMap.put("Exit Without Entry", exitWithoutEntry);

        return resultMap;

    }

/*
* Input is a 2-D array of records and we will return List <List<String>>
*
* */



}