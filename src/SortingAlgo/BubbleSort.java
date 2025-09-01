package SortingAlgo;

//compare two elements in a bubble and swap if ar[0] > ar[1]
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5,3,8,4,2};
        BubbleSort bs = new BubbleSort();
        System.out.println("Array before sorting:");
        bs.printArray(arr);
        System.out.println("\nArray after sorting:");
        int[] sortedArr = bs.sortArrayViaBubbleSort(arr);
        bs.printArray(sortedArr);

    }

    public void printArray(int[] arr){
        int n = arr.length;
        for(int i =0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public int[] sortArrayViaBubbleSort(int[] arrValue){

        int n = arrValue.length;

        boolean isSwapped;

        for(int i =0; i<n-1; i++){

            isSwapped = false;
            for(int j =0; j<n-1-i; j++){
                if(arrValue[j] > arrValue[j+1]){
                    int temp = arrValue[j];
                    arrValue[j] = arrValue[j+1];
                    arrValue[j+1] = temp;
                    isSwapped = true;
                }
            }
            if(isSwapped == false) break;
        }
        return arrValue;
    }
}
