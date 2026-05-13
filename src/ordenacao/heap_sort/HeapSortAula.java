package ordenacao.heap_sort;

public class HeapSortAula {

    public int[] ordenar(int[] dados, String nomeConjunto) {
        long tempoInicial = System.currentTimeMillis();
        int n = dados.length;

        // Passo 1: Constroi o Heap (reorganiza o array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(dados, n, i);
        }

        // Passo 2: Extrai elementos do heap um por um
        for (int i = n - 1; i > 0; i--) {
            // Move a raiz atual (maior elemento) para o fim
            int temp = dados[0];
            dados[0] = dados[i];
            dados[i] = temp;

            // Chama o heapify na árvore reduzida
            heapify(dados, i, 0);
        }

        long tempoFinal = System.currentTimeMillis();
        System.out.println("HeapSort - [" + nomeConjunto + "] Tempo: " + (tempoFinal - tempoInicial) + " ms");

        return dados;
    }

    // Para transformar uma subárvore com nó raiz i em um heap
    private void heapify(int[] array, int n, int i) {
        int maior = i; // Inicializa o maior como raiz
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        // Se o filho da esquerda é maior que a raiz
        if (esquerda < n && array[esquerda] > array[maior]) {
            maior = esquerda;
        }

        // Se o filho da direita é maior que o maior até agora
        if (direita < n && array[direita] > array[maior]) {
            maior = direita;
        }

        // Se o maior não for a raiz
        if (maior != i) {
            int troca = array[i];
            array[i] = array[maior];
            array[maior] = troca;

            // Recursivamente faz o heapify na subárvore afetada
            heapify(array, n, maior);
        }
    }
}