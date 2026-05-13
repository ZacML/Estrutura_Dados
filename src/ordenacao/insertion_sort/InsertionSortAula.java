package ordenacao.insertion_sort;

public class InsertionSortAula {

    public int[] ordenar(int[] dados, String nomeConjunto) {
        long tempoInicial = System.currentTimeMillis();
        int n = dados.length;

        for (int i = 1; i < n; i++) {
            int chave = dados[i];
            int j = i - 1;

            // Move os elementos de dados[0..i-1] que são maiores que a chave
            // para uma posição à frente de sua posição atual
            while (j >= 0 && dados[j] > chave) {
                dados[j + 1] = dados[j];
                j = j - 1;
            }
            dados[j + 1] = chave;
        }

        long tempoFinal = System.currentTimeMillis();
        System.out.println("InsertionSort - [" + nomeConjunto + "] Tempo: " + (tempoFinal - tempoInicial) + " ms");

        return dados;
    }
}