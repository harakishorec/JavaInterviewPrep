package SortingAlgo;


// Divide array in two parts
// ---------Sorted Part | Unsorted Part
// No element in the sorted part at first.
// Find Minimum element from the right side and add it to the left part

public class SelectionSort {

    public static void main(String[] args) {

        SelectionSort selectionSort = new SelectionSort();
        int[] arr = {5,3,8,4,2};
        System.out.println("Before Sorting: ");
        selectionSort.printArray(arr);
        int[] sortedArray = selectionSort.selectionSortArray(arr);
        System.out.println();
        System.out.println("After Sorting: ");
        selectionSort.printArray(sortedArray);

    }

    public void printArray(int[] arr){
        int n = arr.length;
        for(int i =0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public int[] selectionSortArray(int[] arrValue){

        int n = arrValue.length;
        for(int i = 0; i < n - 1; i++){
            int min = i;
            for(int j = i + 1; j < n; j++){
                if(arrValue[j] < arrValue[min]){
                    min = j;
                }
            }
            int temp = arrValue[min];
            arrValue[min] = arrValue[i];
            arrValue[i] = temp;
        }
        return arrValue;
    }
}
