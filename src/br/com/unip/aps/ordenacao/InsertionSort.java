package br.com.unip.aps.ordenacao;

public class InsertionSort {

    private InsertionSort() {}

    public static long sort(int[] array) {
        int i, j, key;

        long inicio = System.currentTimeMillis();

        for (i = 1; i < array.length; i++) {
            key = array[i];
            for (j = i - 1; j >= 0 && array[j] > key; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }

        long fim = System.currentTimeMillis();
        return fim - inicio;
    }

}
