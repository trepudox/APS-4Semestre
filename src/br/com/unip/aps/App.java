package br.com.unip.aps;

import br.com.unip.aps.exception.EmptyFileException;
import br.com.unip.aps.ordenacao.BubbleSort;
import br.com.unip.aps.ordenacao.InsertionSort;
import br.com.unip.aps.ordenacao.QuickSort;
import br.com.unip.aps.util.GeradorDeDados;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class App {

    private static final String PATH = "src\\br\\com\\unip\\aps\\txt\\";

    // Código fonte —> https://github.com/trepudox/APS-4Semestre

    public static void main(String[] args) {
        System.out.println("Bem vindo ao programa de ordenação.");

        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
            System.out.println("\nObrigado por usar nossa aplicação!");
            Thread.currentThread().interrupt();
        }

        System.out.println("\nOBS.: Dependendo do hardware, da quantidade de elementos do array e do algoritmo selecionado" +
                " o processo pode demorar um pouco.");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
            System.out.println("\nObrigado por usar nossa aplicação!");
            Thread.currentThread().interrupt();
        }

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
                    System.out.println("\nObrigado por usar a nossa aplicação!");
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

                case 5:
                    GeradorDeDados.gerarTxtComValoresAleatorios();
                    break;

                case 6:
                    GeradorDeDados.listarArquivosTxt();
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
        System.out.println("5. Gerar .txt com valores aleatórios");
        System.out.println("6. Listar os arquivos .txt disponíveis");
        System.out.println("0. Finaliza o programa");
    }

    private static void menuOpcoesSort(String sortOperation) {
        System.out.println();
        System.out.printf("MENU %s:%n", sortOperation.toUpperCase());
        System.out.println("1. Mostra esse menu");
        System.out.println("2. Gerar array com números ordenados (100 mil valores)");
        System.out.println("3. Gerar array com números aleatórios (100 mil valores)");
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
        System.out.println();
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

    private static int[] lerTxt() {
        GeradorDeDados.listarArquivosTxt();

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nInsira o nome do arquivo .txt armazenzado na pasta txt (não inclua o '.txt'!): ");
        String nome = scanner.nextLine().concat(".txt");

        try (FileReader file = new FileReader(PATH + nome); BufferedReader reader = new BufferedReader(file)) {
            List<Integer> integerList = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                integerList.add(Integer.valueOf(line));

                line = reader.readLine();
            }

            if (integerList.isEmpty())
                throw new EmptyFileException();


            int[] intArray = new int[integerList.size()];
            for (int i = 0; i < integerList.size(); i++)
                intArray[i] = integerList.get(i);

            return intArray;

        } catch (FileNotFoundException ex) {
            System.out.println("\nO arquivo não foi encontrado.");
            return new int[] {};
        } catch (IOException ex) {
            System.out.println("\nNão foi possível ler o arquivo.");
            return new int[] {};
        } catch (NumberFormatException ex) {
            System.out.println("\nNão foi possível converter os valores do arquivo em um array.");
            return new int[] {};
        } catch (EmptyFileException ex) {
            System.out.println("\nO arquivo não possui valores.");
            return new int[] {};
        }
    }

    private static void insertionSort() {
        menuOpcoesSort("Insertion Sort");
        int[] array;
        long tempo;
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

                    tempo = InsertionSort.sort(array);
                    System.out.printf("%nTempo necessário do InsertionSort: %d ms%n", tempo);

                    promptVerArrayDepoisDaOrdenacao(array);

                    return;

                case 3:
                    array = GeradorDeDados.gerarAleatorio();

                    promptVerArrayAntesDaOrdenacao(array);

                    tempo = InsertionSort.sort(array);
                    System.out.printf("%nTempo necessário do InsertionSort: %d ms%n", tempo);

                    promptVerArrayDepoisDaOrdenacao(array);

                    return;

                case 4:
                    array = lerTxt();

                    if (array.length == 0)
                        return;

                    promptVerArrayAntesDaOrdenacao(array);

                    tempo = InsertionSort.sort(array);
                    System.out.printf("%nTempo necessário do InsertionSort: %d ms%n", tempo);

                    promptVerArrayDepoisDaOrdenacao(array);

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
        long tempo;
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

                    tempo = BubbleSort.sort(array);
                    System.out.printf("%nTempo necessário do BubbleSort para ordenação: %d ms%n", tempo);

                    promptVerArrayDepoisDaOrdenacao(array);

                    return;

                case 3:
                    array = GeradorDeDados.gerarAleatorio();

                    promptVerArrayAntesDaOrdenacao(array);

                    tempo = BubbleSort.sort(array);
                    System.out.printf("%nTempo necessário do BubbleSort para ordenação: %d ms%n", tempo);

                    promptVerArrayDepoisDaOrdenacao(array);

                    return;

                case 4:
                    array = lerTxt();

                    if (array.length == 0)
                        return;

                    promptVerArrayAntesDaOrdenacao(array);

                    tempo = BubbleSort.sort(array);
                    System.out.printf("%nTempo necessário do BubbleSort para ordenação: %d ms%n", tempo);

                    promptVerArrayDepoisDaOrdenacao(array);

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
        long tempo = 0;
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

                    try {
                        tempo = QuickSort.sort(array, 0, array.length - 1);
                    } catch (StackOverflowError ex) {
                        System.out.print("\nO limite de memória para essa operação foi excedido!\n");
                        return;
                    }

                    System.out.printf("%nTempo necessário do QuickSort para ordenação: %d ms%n", tempo);

                    promptVerArrayDepoisDaOrdenacao(array);

                    return;

                case 3:
                    array = GeradorDeDados.gerarAleatorio();

                    promptVerArrayAntesDaOrdenacao(array);

                    try {
                        tempo = QuickSort.sort(array, 0, array.length - 1);
                    } catch (StackOverflowError ex) {
                        System.out.print("\nO limite de memória para essa operação foi excedido!\n");
                        return;
                    }

                    System.out.printf("%nTempo necessário do QuickSort para ordenação: %d ms%n", tempo);

                    promptVerArrayDepoisDaOrdenacao(array);

                    return;

                case 4:
                    array = lerTxt();

                    if (array.length == 0)
                        return;

                    promptVerArrayAntesDaOrdenacao(array);

                    try {
                        tempo = QuickSort.sort(array, 0, array.length - 1);
                    } catch (StackOverflowError ex) {
                        System.out.print("\nO limite de memória para essa operação foi excedido!\n");
                        return;
                    }

                    System.out.printf("%nTempo necessário do QuickSort para ordenação: %d ms%n", tempo);

                    promptVerArrayDepoisDaOrdenacao(array);

                    return;

                case 0:
                    return;

                default:
                    System.out.println("\nSelecione uma opção válida.\n");
            }
        }
    }

}
