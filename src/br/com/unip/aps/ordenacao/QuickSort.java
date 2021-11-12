package br.com.unip.aps.ordenacao;

public class QuickSort {

    private QuickSort() {}

    public static long sort(int[] array, int begin, int end) {
        long startTime = System.currentTimeMillis();

        if (begin < end) {
            int partitionIndex = partition(array, begin, end);
            sort(array, begin, partitionIndex - 1);
            sort(array, partitionIndex + 1, end);
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static int partition(int[] array, int begin, int end) {
        int pivot = array[begin];
        int i = begin + 1;
        int f = end;

        while (i <= f) {
            if (array[i] <= pivot)
                i++;
            else if (pivot < array[f])
                f--;
            else {
                int aux = array[i];
                array[i] = array[f];
                array[f] = aux;
                i++;
                f--;
            }
        }

        array[begin] = array[f];
        array[f] = pivot;

        return f;
    }

}
