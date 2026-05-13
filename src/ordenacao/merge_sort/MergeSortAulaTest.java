package ordenacao.merge_sort;

import ordenacao.GeraVetorUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortAulaTest {

    int[] v11, v12, v13;
    int[] v21, v22, v23;
    MergeSortAula ms;

    @BeforeEach
    void setup() {
        ms = new MergeSortAula();

        // Tamanho 5.000
        v11 = GeraVetorUtil.geraAleatorio(5000);
        v12 = GeraVetorUtil.geraOrdenado(5000);
        v13 = GeraVetorUtil.geraInverso(5000);

        // Tamanho 50.000
        v21 = GeraVetorUtil.geraAleatorio(50_000);
        v22 = GeraVetorUtil.geraOrdenado(50_000);
        v23 = GeraVetorUtil.geraInverso(50_000);
    }

    private void validar(int[] vetorOriginal, String nomeTeste) {
        int[] esperado = vetorOriginal.clone();
        Arrays.sort(esperado);

        int[] resultado = ms.ordenar(vetorOriginal, nomeTeste);

        assertArrayEquals(esperado, resultado, "Erro na ordenação: " + nomeTeste);
        System.out.println("Check: " + nomeTeste + " validado!");
    }

    @Test
    void testarPerformanceEValidarMerge() {
        System.out.println("--- Resultados Merge Sort ---");

        // Testes para 5.000 elementos
        validar(v11, "5000_aleatorio");
        validar(v12, "5000_ordenado");
        validar(v13, "5000_inverso");

        // Testes para 50.000 elementos
        validar(v21, "50.000_aleatorio");
        validar(v22, "50.000_ordenado");
        validar(v23, "50.000_inverso");
    }
}