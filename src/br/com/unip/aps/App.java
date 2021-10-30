package br.com.unip.aps;

import br.com.unip.aps.ordenacao.BubbleSort;
import br.com.unip.aps.ordenacao.InsertionSort;
import br.com.unip.aps.ordenacao.QuickSort;
import br.com.unip.aps.util.GeradorDeDados;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    // Bubble Sort
    // Insertion Sort
    // Quick Sort

    public static void main(String[] args) {
        System.out.println("Bem vindo ao programa de ordenação.");
        menuInicial();
        int opcao = 1;

        while (opcao != 2) {
            opcao = entradaInt();

            switch (opcao) {
                case 1:
                    menuInicial();
                    break;

                case 2:
                    break;

                case 0:
                    System.out.println("\nObrigado por usar nossa aplicação!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nSelecione uma opção válida.\n");
            }
        }

        while (opcao != 0) {
            menuPrograma();
            opcao = entradaInt();

            switch (opcao) {
                case 1:
                    menuPrograma();
                    break;

                case 2:
                    bubbleSort();
                    break;

                case 3:
                    insertionSort();
                    break;

                case 4:
                    quickSort();
                    break;

                case 0:
                    System.out.println("\nObrigado por usar nossa aplicação!");
                    break;

                default:
                    System.out.println("\nSelecione uma opção válida.\n");
            }
        }

    }

    private static int entradaInt() {
        int opcao = 0;

        while (true) {
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.print("Selecione um dos números listados: ");
                opcao = scanner.nextInt();
                return opcao;
            } catch (InputMismatchException ex) {
                System.out.println("\nEntrada inválida, por favor insira apenas números\n");
            }
        }
    }

    private static void menuInicial() {
        System.out.println();
        System.out.println("MENU:");
        System.out.println("1. Mostra esse menu");
        System.out.println("2. Inicia o programa ");
        System.out.println("0. Finaliza o programa");
    }

    private static void menuPrograma() {
        System.out.println();
        System.out.println("MENU:");
        System.out.println("1. Mostra esse menu");
        System.out.println("2. Realiza o BubbleSort");
        System.out.println("3. Realiza o InsertionSort");
        System.out.println("4. Realiza o QuickSort");
        System.out.println("0. Finaliza o programa");
    }

    private static void menuOpcoesSort(String sortOperation) {
        System.out.println();
        System.out.printf("MENU %s:%n", sortOperation.toUpperCase());
        System.out.println("1. Mostra esse menu");
        System.out.println("2. Gerar array com números ordenados");
        System.out.println("3. Gerar array com números aleatórios");
        System.out.println("4. Usar .txt armazenado no projeto");
        System.out.println("0. Cancela a operação");
    }

    private static void menuOpcoesVerArrayAntesDaOrdenacao() {
        System.out.println();
        System.out.println("Deseja ver o array antes da ordenação?");
        System.out.println("1. Sim");
        System.out.println("2. Não");
    }

    private static void menuOpcoesVerArrayDepois() {
        System.out.println();
        System.out.println("Deseja ver o array depois da ordenação?");
        System.out.println("1. Sim");
        System.out.println("2. Não");
    }

    private static void verArray(int[] array) {
        System.out.println(Arrays.toString(array));
        System.out.println("Tamanho do array: " + array.length);
    }

    private static void promptVerArrayAntesDaOrdenacao(int[] array) {
        int opcao;

        do {
            menuOpcoesVerArrayAntesDaOrdenacao();
            opcao = entradaInt();
        } while (opcao != 1 && opcao != 2);

        if (opcao == 1)
            verArray(array);
    }

    private static void promptVerArrayDepoisDaOrdenacao(int[] array) {
        int opcao;

        do {
            menuOpcoesVerArrayDepois();
            opcao = entradaInt();
        } while (opcao != 1 && opcao != 2);

        if (opcao == 1)
            verArray(array);
    }

    private static void insertionSort() {
        menuOpcoesSort("Insertion Sort");
        int[] array;
        int opcao;

        while (true) {
            opcao = entradaInt();

            switch (opcao) {
                case 1:
                    menuOpcoesSort("Insertion Sort");
                    break;

                case 2:
                    array = GeradorDeDados.gerarOrdenado();

                    promptVerArrayAntesDaOrdenacao(array);

                    InsertionSort.sort(array);

                    promptVerArrayDepoisDaOrdenacao(array);

                    return;

                case 3:
                    array = GeradorDeDados.gerarAleatorio();

                    promptVerArrayAntesDaOrdenacao(array);

                    InsertionSort.sort(array);

                    promptVerArrayDepoisDaOrdenacao(array);

                    return;

                case 4:
                    System.out.println(".txt");
                    return;

                case 0:
                    return;

                default:
                    System.out.println("\nSelecione uma opção válida.\n");
            }
        }
    }

    private static void bubbleSort() {
        menuOpcoesSort("Bubble Sort");
        int[] array;
        int opcao;

        while (true) {
            opcao = entradaInt();

            switch (opcao) {
                case 1:
                    menuOpcoesSort("Bubble Sort");
                    break;

                case 2:
                    array = GeradorDeDados.gerarOrdenado();

                    promptVerArrayAntesDaOrdenacao(array);

                    BubbleSort.sort(array);

                    promptVerArrayDepoisDaOrdenacao(array);

                    return;

                case 3:
                    array = GeradorDeDados.gerarAleatorio();

                    promptVerArrayAntesDaOrdenacao(array);

                    BubbleSort.sort(array);

                    promptVerArrayDepoisDaOrdenacao(array);

                    return;

                case 4:
                    System.out.println(".txt");
                    return;

                case 0:
                    return;

                default:
                    System.out.println("\nSelecione uma opção válida.\n");
            }
        }
    }

    private static void quickSort() {
        menuOpcoesSort("Quick Sort");
        int[] array;
        int opcao;

        while (true) {
            opcao = entradaInt();

            switch (opcao) {
                case 1:
                    menuOpcoesSort("Quick Sort");
                    break;

                case 2:
                    array = GeradorDeDados.gerarOrdenado();

                    promptVerArrayAntesDaOrdenacao(array);

                    QuickSort.sort(array);

                    promptVerArrayDepoisDaOrdenacao(array);

                    return;

                case 3:
                    array = GeradorDeDados.gerarAleatorio();

                    promptVerArrayAntesDaOrdenacao(array);

                    QuickSort.sort(array);

                    promptVerArrayDepoisDaOrdenacao(array);

                    return;

                case 4:
                    System.out.println(".txt");
                    return;

                case 0:
                    return;

                default:
                    System.out.println("\nSelecione uma opção válida.\n");
            }
        }
    }

}
