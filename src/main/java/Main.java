import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] array = {10, 2, 10, 3, 1, 2, 5};
        boolean needIteration = true;
        int right = array.length - 1;

        System.out.println(Arrays.toString(array));

                    //BUBBLE SORT

        /*for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                swap(array, i, i-1);
            }
        }

        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i-1);
                    needIteration = true;
                }
            }
        }
        */

                            //SELECTION SORT
       /* for (int left = 0; left < array.length; left++) {
            int minInd = left;
            for (int i = left; i < array.length; i++) {
                if (array[i] < array[minInd]) {
                    minInd = i;
                }
            }
            swap(array, left, minInd);
        }
        */
                        //INSERTION SORT
        /*for (int left = 0; left < array.length; left++) {
            // getting the value of element
            int value = array[left];
            // Move through elements before value
            int i = left - 1;
            for (; i >= 0; i--) {
                // if value of element is smaller - move larger element forward
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    //If element which was taken is larger - stop
                    break;
                }
            }
            // Put taken element in vacated place
            array[i + 1] = value;
        }
        */
                        //SHUTTLE SORT
        /*for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                swap(array, i, i - 1);
                for (int z = i - 1; (z - 1) >= 0; z--) {
                    if (array[z] < array[z - 1]) {
                        swap(array, z, z - 1);
                    } else {
                        break;
                    }
                }
            }
        }
       */
                        //SHELL SORT

        /*int gap = array.length / 2;
        // While there is difference between elements
        while (gap >= 1) {
            for (int right = 0; right < array.length; right++) {
                // Move right index until we can find one
                //that between it and element before we can find the gap

                for (int c = right - gap; c >= 0; c -= gap) {
                    if (array[c] > array[c + gap]) {
                        swap(array, c, c + gap);
                    }
                }
            }
            // Recounting the gap
            gap = gap / 2;
        }
        */
                    //MERGE SORT

       // mergeSort(array, 0, right);


                //COUNTING SORT
       // countingSort(array, 10);
                //RADIX SORT
      //  Radix.radixsort(array, array.length);
                //QUICK SORT
        quickSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }



    private static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }

    public static void mergeSort(int[] source, int left, int right) {
        // Choose thr delimiter, divide "source" into 2 parts
        int delimiter = left + ((right - left) / 2) + 1;
        // Make recursive call for both parts (if its possible to divide(
        if (delimiter > 0 && right > (left + 1)) {
            mergeSort(source, left, delimiter - 1);
            mergeSort(source, delimiter, right);
        }
        // make temporary arrray with size we need
        int[] buffer = new int[right - left + 1];
        // Iterate through every element starting with the left border
        int cursor = left;
        for (int i = 0; i < buffer.length; i++) {
            // We use delimeter to point the element from the right part
            // If delimeter > right, it means that there are all elements in the right part added
            if (i == buffer.length - 1 && right == delimiter) {
                buffer[i] = source[delimiter];
                break;
            } else if (delimiter > right || source[cursor] < source[delimiter]){
                buffer[i] = source[cursor];
                cursor++;
            } else {
                buffer[i] = source[delimiter];
                delimiter++;
            }
        }
        System.arraycopy(buffer, 0, source, left, buffer.length);
    }

    public static int[] countingSort(int[] theArray, int maxValue) {
        // Array with "counts"  and size from 0 to maxValue
        int numCounts[] = new int[maxValue + 1];
        // In a relevant ceel (index = value) В соответствующей ячейке (индекс = значение) increasing count
        for (int num : theArray) {
            numCounts[num]++;
        }
        // Preparing an array for sorted result
        int[] sortedArray = new int[theArray.length];
        int currentSortedIndex = 0;
        // Iterate through an array with "counts"
        for (int n = 0; n < numCounts.length; n++) {
            int count = numCounts[n];
            // Iterate through amount of values
            for (int k = 0; k < count; k++) {
                sortedArray[currentSortedIndex] = n;
                currentSortedIndex++;
            }
        }
        System.out.println(Arrays.toString(sortedArray));
        return sortedArray;
    }

    public static void quickSort(int[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];
        do {
            // Move left marker from left to right while element is smaller than pivot
            while (source[leftMarker] < pivot) {
                leftMarker++;
            }
            // Move right marker while element is larger than pivot
            while (source[rightMarker] > pivot) {
                rightMarker--;
            }
            //Check if it's needed to switch pointed with marker elements
            if (leftMarker <= rightMarker) {
                // Left marker will be smaller than right only if we need to swap
                if (leftMarker < rightMarker) {
                    int tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }
                // Moving markers to get new borders
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Use recursion both parts
        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
    }
}
