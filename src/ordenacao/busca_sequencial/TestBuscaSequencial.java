package ordenacao.busca_sequencial;

import ordenacao.GeraVetorUtil;

import java.util.Random;

public class TestBuscaSequencial {

    static class ResultadoBusca {
        int passadas;
        long tempoNanos;
        boolean encontrado;

        public ResultadoBusca(int passadas, long tempoNanos, boolean encontrado) {
            this.passadas = passadas;
            this.tempoNanos = tempoNanos;
            this.encontrado = encontrado;
        }
    }

    // Algoritmo de Busca Sequencial
    public static ResultadoBusca buscaSequencial(int[] vetor, int alvo) {
        int passadas = 0;
        boolean encontrado = false;

        long inicioTempo = System.nanoTime();

        for (int i = 0; i < vetor.length; i++) {
            passadas++; // Conta cada comparação feita
            if (vetor[i] == alvo) {
                encontrado = true;
                break; // Para a busca ao encontrar o número
            }
        }

        long fimTempo = System.nanoTime();
        long tempoGasto = fimTempo - inicioTempo;

        return new ResultadoBusca(passadas, tempoGasto, encontrado);
    }

    public static void main(String[] args) {
        int tamanhoVetor = 50000;
        int quantidadeBuscas = 10;

        System.out.println("Gerando vetor ALEATÓRIO de " + tamanhoVetor + " posições...");
        int[] vetor = GeraVetorUtil.geraAleatorio(tamanhoVetor);

        Random random = new Random();
        System.out.println("Iniciando as " + quantidadeBuscas + " buscas sequenciais...\n");
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("%-10s | %-15s | %-12s | %-10s | %-15s%n", "Busca Nº", "Número Alvo", "Encontrou?", "Passadas", "Tempo (ns)");
        System.out.println("-------------------------------------------------------------------------");

        for (int i = 1; i <= quantidadeBuscas; i++) {
            // Sorteia um número de 0 a 50.000 para ser buscado
            int numeroAlvo = random.nextInt(50001);

            ResultadoBusca resultado = buscaSequencial(vetor, numeroAlvo);

            String achou = resultado.encontrado ? "Sim" : "Não";

            System.out.printf("%-10d | %-15d | %-12s | %-10d | %-15d%n",
                    i, numeroAlvo, achou, resultado.passadas, resultado.tempoNanos);
        }
        System.out.println("-------------------------------------------------------------------------");
    }
}