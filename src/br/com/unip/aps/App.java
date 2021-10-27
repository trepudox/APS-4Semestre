package br.com.unip.aps;

import br.com.unip.aps.util.GeradorDeDados;

import java.util.Arrays;

public class App {

    // Bubble Sort
    // Insertion Sort
    // Quick Sort

    public static void main(String[] args) {
        int[] array = GeradorDeDados.gerar();
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.stream(array).count());
    }

}
