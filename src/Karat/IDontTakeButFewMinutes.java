package Karat;

import java.util.*;

public class IDontTakeButFewMinutes {

    public static void main(String[] args) {

        String[][] song_times_1 = {
                {"Stairway to Heaven", "8:05"},
                {"Immigrant Song", "2:27"},
                {"Rock and Roll", "3:41"},
                {"Communication Breakdown", "2:29"},
                {"Good Times Bad Times", "2:48"},
                {"Hot Dog", "3:19"},
                {"The Crunge", "3:18"},
                {"Achilles Last Stand", "10:26"},
                {"Black Dog", "4:55"}
        };

        String[][] song_times_2 = {
                {"Stairway to Heaven", "8:05"},
                {"Immigrant Song", "2:27"},
                {"Rock and Roll", "3:41"},
                {"Communication Breakdown", "2:29"},
                {"Good Times Bad Times", "2:48"},
                {"Black Dog", "4:55"},
                {"The Crunge", "3:18"},
                {"Achilles Last Stand", "10:26"},
                {"The Ocean", "4:31"},
                {"Hot Dog", "3:19"}
        };

        String[][] song_times_3 = {
                {"Stairway to Heaven", "8:05"},
                {"Immigrant Song", "2:27"},
                {"Rock and Roll", "3:41"},
                {"Communication Breakdown", "2:29"},
                {"Hey Hey What Can I Do", "4:00"},
                {"Poor Tom", "3:00"},
                {"Black Dog", "4:55"}
        };

        String[][] song_times_4 = {
                {"Hey Hey What Can I Do", "4:00"},
                {"Rock and Roll", "3:41"},
                {"Communication Breakdown", "2:29"},
                {"Going To California", "3:30"},
                {"On The Run", "3:50"},
                {"The Wrestler", "3:50"},
                {"Black Mountain Side", "2:00"},
                {"Black Dog", "4:55"}
        };

        String[][] song_times_5 = {
                {"Celebration Day", "3:30"},
                {"Going To California", "3:30"},
        };

        String[][] song_times_6 = {
                {"Rock and Roll", "3:41"},
                {"If I Lived Here", "3:59"},
                {"Day and Night", "5:03"},
                {"Tempo Song", "1:57"}
        };

        System.out.println(getSongsAddUpSevenMinutes(song_times_1));
        System.out.println(getSongsAddUpSevenMinutes(song_times_2));
        System.out.println(getSongsAddUpSevenMinutes(song_times_3));
        System.out.println(getSongsAddUpSevenMinutes(song_times_4));
        System.out.println(getSongsAddUpSevenMinutes(song_times_5));
        System.out.println(getSongsAddUpSevenMinutes(song_times_6));
    }

    public static List<String> getSongsAddUpSevenMinutes(String[][] listOfSongs){

        ArrayList<String> finalPair = new ArrayList<>();
        if(listOfSongs == null || listOfSongs.length < 2) return finalPair;

        Map<Integer,String> songTimeMap = new HashMap<>();
        for(String[] songMap: listOfSongs){
            songTimeMap.put(convertToSeconds(songMap[1]),songMap[0]);
        }
        int timeToFind =  convertToSeconds("7:00");

        for (String[] song : listOfSongs) {
            int currentTime = convertToSeconds(song[1]);
            int timeNeeded = timeToFind - currentTime;
            if (songTimeMap.containsKey(timeNeeded) && !songTimeMap.get(timeNeeded).equals(song[0])) {
                finalPair.add(song[0]);
                finalPair.add(String.valueOf(songTimeMap.get(timeNeeded)));
                break;
            }
        }
        return finalPair;
    }

    public static int convertToSeconds(String time){

        int timeInSeconds = 0;
        String[] timeParts = time.split(":");

        if(timeParts.length == 2){
            int minutes = Integer.parseInt(timeParts[0]);
            int seconds = Integer.parseInt(timeParts[1]);

            timeInSeconds = (minutes * 60) + seconds;
        }
        return timeInSeconds;
    }

}