package ordenacao.bubble_sort;

public class BubbleSortAula {

    public int[] ordenar(int[] dados, String nomeConjunto) {
        // Captura o tempo inicial em milissegundos
        long tempoInicial = System.currentTimeMillis();

        int n = dados.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (dados[j] > dados[j + 1]) {
                    // Troca os elementos
                    int temp = dados[j];
                    dados[j] = dados[j + 1];
                    dados[j + 1] = temp;
                }
            }
        }

        // Captura o tempo final e calcula a diferença
        long tempoFinal = System.currentTimeMillis();
        System.out.println("Conjunto [" + nomeConjunto + "] - Tempo de execução: " + (tempoFinal - tempoInicial) + " ms");

        return dados;
    }
}