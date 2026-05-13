package ordenacao.bubble_sort;

import ordenacao.GeraVetorUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BubbleSortAulaTest {
    int[] v21 = new int [500];
    int[] v22 = new int [500];
    int[] v23 = new int [500];

    int[] v31 = new int [50_000];
    int[] v32 = new int [50_000];
    int[] v33 = new int [50_000];

    @BeforeEach
    void gerarDados(){
        v21 = GeraVetorUtil.geraOrdenado(500);
        v22 = GeraVetorUtil.geraAleatorio(500);
        v23 = GeraVetorUtil.geraInverso(500);

        v31 = GeraVetorUtil.geraOrdenado(50_000);
        v32 = GeraVetorUtil.geraAleatorio(50_000);
        v33 = GeraVetorUtil.geraInverso(50_000);
    }


    @Test
    void testarPerformance() {
        BubbleSortAula bs = new BubbleSortAula();

        System.out.println("--- Iniciando Testes de Ordenação ---");

        // Testando com 500 elementos
        bs.ordenar(v21, "500_ordenado");
        bs.ordenar(v22, "500_aleatorio");
        bs.ordenar(v23, "500_inverso");

        bs.ordenar(v31, "50.000_ordenado");
        bs.ordenar(v32, "50.000_aleatorio");
        bs.ordenar(v33, "50.000_inverso");
    }

}