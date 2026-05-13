package ordenacao.selection_sort;

public class SelectionSortAula {

    public int[] ordenar(int[] dados, String nomeConjunto) {
        // Captura o tempo inicial
        long tempoInicial = System.currentTimeMillis();

        int n = dados.length;

        for (int i = 0; i < n - 1; i++) {
            // Assume que o menor é o primeiro elemento da parte não ordenada
            int indiceMenor = i;

            for (int j = i + 1; j < n; j++) {
                if (dados[j] < dados[indiceMenor]) {
                    indiceMenor = j;
                }
            }

            // Troca o menor encontrado com o elemento da posição i
            int temp = dados[indiceMenor];
            dados[indiceMenor] = dados[i];
            dados[i] = temp;
        }

        long tempoFinal = System.currentTimeMillis();
        System.out.println("SelectionSort - [" + nomeConjunto + "] Tempo: " + (tempoFinal - tempoInicial) + " ms");

        return dados;
    }
}