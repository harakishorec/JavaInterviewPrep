package Karat;

import java.util.*;

public class SharedCourses {

    public static void main(String[] args) {

        String[][] enrollments1 = {
                {"58", "Linear Algebra"},
                {"94", "Art History"},
                {"94", "Operating Systems"},
                {"17", "Software Design"},
                {"58", "Mechanics"},
                {"58", "Economics"},
                {"17", "Linear Algebra"},
                {"17", "Political Science"},
                {"94", "Economics"},
                {"25", "Economics"},
                {"58", "Software Design"}
        };

        String[][] enrollments2 = {
                {"0", "Advanced Mechanics"},
                {"0", "Art History"},
                {"1", "Course 1"},
                {"1", "Course 2"},
                {"2", "Computer Architecture"},
                {"3", "Course 1"},
                {"3", "Course 2"},
                {"4", "Algorithms"}
        };

        String[][] enrollments3 = {
                {"23", "Software Design"},
                {"3", "Advanced Mechanics"},
                {"2", "Art History"},
                {"33", "Another"}
        };

        System.out.println(findSharedCourses(enrollments1));
        System.out.println(findSharedCourses(enrollments2));
        System.out.println(findSharedCourses(enrollments3));
    }

    public static Map<String, ArrayList<String>> findSharedCourses(String[][] enrollments){

        Map<String,ArrayList<String>> sharedCoursesMap = new HashMap<>();
        Map<String,ArrayList<String>> studentCoursesMap = new HashMap<>();

        for(String[] enrollment: enrollments){
            String studentId = enrollment[0];
            String course = enrollment[1];

            ArrayList<String> existingCoursesMap;

            if(studentCoursesMap.containsKey(studentId)){
                existingCoursesMap = studentCoursesMap.get(studentId);
                existingCoursesMap.add(course);
                studentCoursesMap.put(studentId, existingCoursesMap);
            }else{
                existingCoursesMap = new ArrayList<>();
                existingCoursesMap.add(course);
            }
            studentCoursesMap.put(studentId, existingCoursesMap);
        }

        for(String studentId1: studentCoursesMap.keySet()){
            for(String studentId2: studentCoursesMap.keySet()){
                if(studentId1 != studentId2){
                    ArrayList<String> sharedCourses1 = new ArrayList<>(studentCoursesMap.get(studentId1));
                    ArrayList<String> sharedCourses2 = new ArrayList<>(studentCoursesMap.get(studentId2));

                    sharedCourses1.retainAll(sharedCourses2);

                    String key = studentId1 + "," + studentId2;
                    Collections.sort(sharedCourses1);

                    if(sharedCoursesMap.containsKey(studentId1+ "," + studentId2) || sharedCoursesMap.containsKey(studentId2+ "," + studentId1)){
                    }else{
                        sharedCoursesMap.put(key, sharedCourses1);
                    }

                }
            }
        }
        return sharedCoursesMap;
    }

}