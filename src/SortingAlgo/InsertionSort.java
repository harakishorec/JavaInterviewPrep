package SortingAlgo;

//Deck of Card:
//Cards in our hand in sorted form
//Pick card from Deck and place the second card accordingly
//Divide array in two parts: 1 - Sorted, 2 - Unsorted
//Compare and sort array in ascending order
// --------------Sorted Array | UnSorted Array -------------

public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] arr = {5,3,8,4,2};

        System.out.println("Before Sorting: ");
        insertionSort.printArray(arr);

        System.out.println("After Sorting: ");
        int[] finalArray = insertionSort.InsertionSortArray(arr);
        insertionSort.printArray(finalArray);
    }

    public void printArray(int[] arr){
        int n = arr.length;
        for(int i =0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public int[] InsertionSortArray(int[] arr){

        for(int i =1; i<arr.length;i++){

            int temp = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = temp;
        }
        return arr;
    }

}
