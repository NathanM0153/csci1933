// A utility function to swap two elements
public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
 
// Places all elements < pivot to the left of pivot and vice versa
static int partition(int[] arr, int min, int max) {
    int pivot = arr[max];
    int i = (min - 1);
    for(int j = min; j <= max - 1; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(arr, i, j);
        }
    }
    swap(arr, i+1, max);
    return (i+1);
}
 
static void quickSort(int[] arr, int min, int max) {
    if (min < max) {
        int pi = partition(arr, min, max);
        // Separately sort elements before partition and after partition, both exclusive
        quickSort(arr, min, pi - 1);
        quickSort(arr, pi + 1, max);
    }
}
