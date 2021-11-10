package br.com.unip.aps.ordenacao;

public class BubbleSort {

    private BubbleSort() {}

    public static long sort(int[] array) {

        int aux;
        boolean tradeStillHappening;

        long startTime = System.currentTimeMillis();

        do {
            tradeStillHappening = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    aux = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = aux;
                    tradeStillHappening = true;
                }
            }
        } while (tradeStillHappening);

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

}
