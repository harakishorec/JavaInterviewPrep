package SortingAlgo;


//Divide and Conquer Algorithm

public class MergeSort {

    public static void main(String[] args) {

        MergeSort mergeSort = new MergeSort();
        int[] arr = {5,3,8,4,2,12,15,17,23,45,36,29,65,76,88};
        System.out.println("Before Sorting: ");
        mergeSort.printArray(arr);

        System.out.println("After Sorting: ");
        mergeSort.sort(arr,new int[arr.length],0,arr.length-1);
        mergeSort.printArray(arr);

    }

    public void printArray(int[] arr){
        int n = arr.length;
        for(int i =0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public void sort(int[] arr, int[] temp, int low, int high){
        if(low < high){
            int mid = low + (high - low)/2;
            sort(arr, temp, low,mid);
            sort(arr, temp, mid+1, high);
            merge(arr,temp,low,mid,high);
        }
    }

    public void merge(int[] arr, int[] temp, int low, int mid, int high){
        for(int i = low; i<= high; i++){
            temp[i] = arr[i];
        }
        int i = low; // traverse left sorted array
        int j = mid + 1; // traverse right sorted array
        int k = low; // merge both arrays

        while(i <= mid && j <= high){
            if(temp[i] <= temp[j]){
                arr[k] = temp[i];
                i++;
            }else{
                arr[k]= temp[j];
                j++;
            }
            k++;
        }

        while (i <= mid){
            arr[k] = temp[i];
            k++;
            i++;
        }
    }
}
