package ordenacao.selection_sort;

import ordenacao.GeraVetorUtil; // Importando o utilitário que você criou
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SelectionSortAulaTest {

    int[] v11, v12, v13;
    int[] v21, v22, v23;
    int[] v31, v32, v33;
    SelectionSortAula ss;

    @BeforeEach
    void setup() {
        ss = new SelectionSortAula();

        v11 = GeraVetorUtil.geraAleatorio(500);
        v12 = GeraVetorUtil.geraOrdenado(500);
        v13 = GeraVetorUtil.geraInverso(500);

        v21 = GeraVetorUtil.geraAleatorio(50_000);
        v22 = GeraVetorUtil.geraOrdenado(50_000);
        v23 = GeraVetorUtil.geraInverso(50_000);

        v31 = GeraVetorUtil.geraAleatorio(500_000);
        v32 = GeraVetorUtil.geraOrdenado(500_000);
        v33 = GeraVetorUtil.geraInverso(500_000);
    }

    @Test
    void testarPerformanceSelection() {
        SelectionSortAula ss = new SelectionSortAula();

        System.out.println("--- Resultados Selection Sort ---");
        ss.ordenar(v11, "500_aleatorio");
        ss.ordenar(v12, "500_ordenado");
        ss.ordenar(v13, "500_inverso");

        ss.ordenar(v21, "50.000_aleatorio");
        ss.ordenar(v22, "50.000_ordenado");
        ss.ordenar(v23, "50.000_inverso");

        ss.ordenar(v31, "500.000_aleatorio");
        ss.ordenar(v32, "500.000_ordenado");
        ss.ordenar(v33, "500.000_inverso");
    }

    private void validar(int[] vetorOriginal, String nomeTeste) {
        // Criamos uma cópia para não alterar o original antes do seu algoritmo rodar
        int[] esperado = vetorOriginal.clone();
        Arrays.sort(esperado);

        // Executa o seu Selection Sort
        int[] resultado = ss.ordenar(vetorOriginal, nomeTeste);

        // Compara se o seu resultado é igual ao esperado pelo Java
        assertArrayEquals(esperado, resultado, "Falha na ordenação do conjunto: " + nomeTeste);
        System.out.println("Check: " + nomeTeste + " ordenado corretamente!");
    }

    @Test
    void testarPerformanceEValidarSelection() {
        System.out.println("--- Iniciando Testes de Validação e Performance ---");

        validar(v11, "500_aleatorio");

        validar(v12, "500_ordenado");

        validar(v13, "500_inverso");
    }
}