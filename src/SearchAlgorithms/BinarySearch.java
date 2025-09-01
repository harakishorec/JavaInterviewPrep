package SearchAlgorithms;

//Array must be in sorted order
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {2,3,5,7,9,10,11,12,14,15,16,19,20,25,29,34,35,37,40,55,77,85,90,99,100};

        BinarySearch bs = new BinarySearch();
        int target = 10;
        int result = bs.BinarySearchAlgo(arr,target);
        if(result == -1){
            System.out.println("Element not found");
        }else
            System.out.println("Element found at index: " + result);

    }

    public int BinarySearchAlgo(int[] arrList, int targetValue){

        if(arrList == null || arrList.length == 0){
            return -1;
        }

        int low = 0;
        int high = arrList.length - 1;
        while(low <= high){

            int mid = low + (high - low) / 2; // To avoid overflow
            if(arrList[mid] == targetValue) {
                return mid;
            }

            if(targetValue < arrList[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1; // Element not found

    }
}
