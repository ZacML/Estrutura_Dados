package ordenacao.quick_sort;

import ordenacao.GeraVetorUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QuickSortAulaTest {

    int[] v11, v12, v13; // Vetores de tamanho 5.000
    int[] v21, v22, v23; // Vetores de tamanho 50.000
    QuickSortAula qs;

    @BeforeEach
    void setup() {
        qs = new QuickSortAula();

        // Inicialização para 5.000 elementos
        v11 = GeraVetorUtil.geraAleatorio(5000);
        v12 = GeraVetorUtil.geraOrdenado(5000);
        v13 = GeraVetorUtil.geraInverso(5000);

        // Inicialização para 50.000 elementos
        v21 = GeraVetorUtil.geraAleatorio(50_000);
        v22 = GeraVetorUtil.geraOrdenado(50_000);
        v23 = GeraVetorUtil.geraInverso(50_000);
    }

    private void validar(int[] vetorOriginal, String nomeTeste) {
        // Criamos uma cópia para comparar com o Arrays.sort nativo
        int[] esperado = vetorOriginal.clone();
        Arrays.sort(esperado);

        // Executa o seu algoritmo Quick Sort
        int[] resultado = qs.ordenar(vetorOriginal, nomeTeste);

        // Verifica se a ordenação foi feita corretamente
        assertArrayEquals(esperado, resultado, "Erro na ordenação do conjunto: " + nomeTeste);
        System.out.println("Check: " + nomeTeste + " validado!");
    }

    @Test
    void testarPerformanceEValidarQuick() {
        System.out.println("--- Resultados Quick Sort ---");

        // Testes de 5.000 elementos
        validar(v11, "5000_aleatorio");
        validar(v12, "5000_ordenado");
        validar(v13, "5000_inverso");

        // Testes de 50.000 elementos
        validar(v21, "50.000_aleatorio");
        validar(v22, "50.000_ordenado");
        validar(v23, "50.000_inverso");
    }
}