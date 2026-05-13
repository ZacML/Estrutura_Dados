package ordenacao.heap_sort;

import ordenacao.GeraVetorUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class HeapSortAulaTest {

    int[] v11, v12, v13;
    int[] v21, v22, v23;
    HeapSortAula hs;

    @BeforeEach
    void setup() {
        hs = new HeapSortAula();

        // 5.000 elementos
        v11 = GeraVetorUtil.geraAleatorio(5000);
        v12 = GeraVetorUtil.geraOrdenado(5000);
        v13 = GeraVetorUtil.geraInverso(5000);

        // 50.000 elementos
        v21 = GeraVetorUtil.geraAleatorio(50_000);
        v22 = GeraVetorUtil.geraOrdenado(50_000);
        v23 = GeraVetorUtil.geraInverso(50_000);
    }

    private void validar(int[] vetorOriginal, String nomeTeste) {
        int[] esperado = vetorOriginal.clone();
        Arrays.sort(esperado);

        int[] resultado = hs.ordenar(vetorOriginal, nomeTeste);

        assertArrayEquals(esperado, resultado, "Erro na ordenação: " + nomeTeste);
        System.out.println("Check: " + nomeTeste + " validado!");
    }

    @Test
    void testarPerformanceEValidarHeap() {
        System.out.println("--- Resultados Heap Sort ---");

        validar(v11, "5000_aleatorio");
        validar(v12, "5000_ordenado");
        validar(v13, "5000_inverso");

        validar(v21, "50.000_aleatorio");
        validar(v22, "50.000_ordenado");
        validar(v23, "50.000_inverso");
    }
}