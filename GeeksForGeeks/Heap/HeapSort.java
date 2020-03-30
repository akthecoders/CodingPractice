/**
 * HeapSort
 */
public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {2, 4, 65,1, 3,34,12};
        int size = arr.length;

        for (int i : arr) {
            System.out.print(i + " ");
        }

        heapSort(arr, size);

        System.out.println("Sorted Array is : ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void heapSort(int[] arr, int size) {
        for(int i = size / 2 - 1; i >= 0; i--) {
            heapify(arr, size, i);
        }
        for (int i=size-1; i>=0; i--) 
        { 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
            heapify(arr, i, 0); 
        } 
    }

    public static void heapify(int[] arr, int size, int element) {
        int largest = element;
        int l = ((2 * element) + 1);
        int r = ((2 * element) + 2);

        if(l < size && arr[l] > arr[largest]) {
            largest = l;
        }
        if(r < size && arr[r] > arr[largest]) {
            largest = r;
        }
        if(largest != element) {
            int temp = arr[largest];
            arr[largest] = arr[element];
            arr[element] = temp;
            heapify(arr, size, largest);
        }
    }
}