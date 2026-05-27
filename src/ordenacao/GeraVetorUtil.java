package ordenacao;

import java.util.Random;

public class GeraVetorUtil {

    public static int[] geraOrdenado(int tamanho) {
        int[] v = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            v[i] = i + 1;
        }
        return v;
    }

    public static int[] geraInverso(int tamanho) {
        int[] v = new int[tamanho];
        for (int i = tamanho - 1; i >= 0; i--) {
            v[i] = tamanho - 1 - i;
        }
        return v;
    }

    public static int[] geraAleatorio(int tamanho) {
        int[] v = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            // Gera números de 0 até 50.000
            v[i] = random.nextInt(50001);
        }
        return v;
    }
}