package br.com.unip;

import java.util.Random;

public class GeradorDeDados {

    private GeradorDeDados() {}
    private static final Random random = new Random();


    public static int[] gerar() {
        int[] array = new int[100000];

        for (int i = 0; i < 100000; i++) {
            array[i] = random.nextInt(1, 10000);
        }

        return array;
    }
}
