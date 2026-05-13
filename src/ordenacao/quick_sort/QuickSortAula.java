package ordenacao.quick_sort;

import java.util.Random;

public class QuickSortAula {

    private Random random = new Random();

    public int[] ordenar(int[] dados, String nomeConjunto) {
        long tempoInicial = System.currentTimeMillis();

        quickSort(dados, 0, dados.length - 1);

        long tempoFinal = System.currentTimeMillis();
        System.out.println("QuickSort - [" + nomeConjunto + "] Tempo: " + (tempoFinal - tempoInicial) + " ms");

        return dados;
    }

    private void quickSort(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = particionarAleatorio(array, inicio, fim);

            quickSort(array, inicio, indicePivo - 1);
            quickSort(array, indicePivo + 1, fim);
        }
    }

    private int particionarAleatorio(int[] array, int inicio, int fim) {
        // Seleciona um índice aleatório entre inicio e fim
        int indiceAleatorio = random.nextInt(fim - inicio + 1) + inicio;

        // Troca o elemento aleatório com o último (o pivô padrão do seu código)
        int temp = array[indiceAleatorio];
        array[indiceAleatorio] = array[fim];
        array[fim] = temp;

        return particionar(array, inicio, fim);
    }

    private int particionar(int[] array, int inicio, int fim) {
        int pivo = array[fim];
        int i = (inicio - 1);

        for (int j = inicio; j < fim; j++) {
            if (array[j] <= pivo) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[fim];
        array[fim] = temp;

        return i + 1;
    }
}