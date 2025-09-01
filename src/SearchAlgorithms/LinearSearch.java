package SearchAlgorithms;

public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = {10,35,7,6,2,8,9,3,5};

        for(int i =0; i<arr.length;i++){
            if(arr[i] == 35){
                System.out.println("Element found at index: " + i);
                break;
            }
        }
    }
}
