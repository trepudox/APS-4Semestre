package br.com.unip.aps.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GeradorDeDados {

    private GeradorDeDados() {}
    private static final Random random = new Random();

    public static int[] gerarAleatorio() {
        int[] array = new int[100000];

        for (int i = 0; i < 100000; i++) {
            array[i] = random.nextInt(9999) + 1;
        }

        return array;
    }

    public static int[] gerarOrdenado() {
        int[] array = new int[100000];

        for (int i = 0; i < 100000; i++) {
            array[i] = i;
        }

        return array;
    }

    public static void gerarTxtComValoresAleatorios() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEscolha um nome para o arquivo: ");
        String nome = scanner.next();

        try (FileWriter file = new FileWriter(String.format("C:\\Users\\marco\\GitHub\\APS-4Semestre\\src\\br\\com\\unip\\aps\\txt\\%s.txt", nome));
             PrintWriter fileArq = new PrintWriter(file)) {
            Random random = new Random();

            System.out.print("\nEscolha a quantidade de elementos do arquivo: ");
            int quantidade = scanner.nextInt();

            for (int i = 0; i < quantidade; i++)
                fileArq.println(random.nextInt(9999) + 1);

        } catch (IOException ex) {
            System.out.println("\nNão foi possível concluir a operação.");
        } catch (InputMismatchException ex) {
            System.out.println("\nApenas números são aceitos na quantidade de elementos.");
            File file = new File(String.format("C:\\Users\\marco\\GitHub\\APS-4Semestre\\src\\br\\com\\unip\\aps\\txt\\%s.txt", nome));
            file.delete();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void listarArquivosTxt() {
        try {
            File folder = new File("src\\br\\com\\unip\\aps\\txt");

            if (folder.listFiles() == null) {
                throw new NullPointerException();
            }

            if (folder.listFiles().length == 0) {
                System.out.println("\nNão há arquivos na pasta txt.");
                return;
            }

            System.out.println("\nARQUIVOS DISPONÍVEIS:");
            for (File file : folder.listFiles()) {
                if (!file.isDirectory()) {
                    System.out.println(file.getName());
                }
            }
        } catch (NullPointerException ex) {
            System.out.println("\nA pasta txt não existe!");
        }
    }
}
