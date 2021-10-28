package br.com.unip.aps.util;

import java.util.Random;

public class GeradorDeDados {

    private GeradorDeDados() {}
    private static final Random random = new Random();


    public static int[] gerar() {
        int[] array = new int[100000];

        for (int i = 0; i < 100000; i++) {
            array[i] = random.nextInt(9999) + 1;
        }

        return array;
    }
}
