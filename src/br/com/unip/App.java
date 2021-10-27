package br.com.unip;

import java.util.Arrays;

public class App {

    // Bubble Sort
    // Quick Sort
    // Shell Sort .

    public static void main(String[] args) {
        int[] array = GeradorDeDados.gerar();
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.stream(array).count());
    }

}
