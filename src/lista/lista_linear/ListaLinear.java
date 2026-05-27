package lista.lista_linear;

public class ListaLinear {

    private String[] elementos;
    private int qtd = 0;

    public ListaLinear(int capacidade) {
        this.elementos = new String[capacidade];
    }

    public boolean isEmpty() {
        return qtd == 0;
    }

    public boolean isFull() {
        return qtd == elementos.length;
    }

    public int buscaLinear(String valorProcurado) {
        for (int i = 0; i < qtd; i++) {
            if (elementos[i] != null && elementos[i].equals(valorProcurado)) {
                return i;
            }
        }
        return -1;
    }

    public void add(String novoValor) {
        if (!isFull()) {
            elementos[qtd] = novoValor;
            qtd++;
        } else {
            System.out.println("Lista cheia!");
        }
    }

    public void add(String novoValor, int pos) {
        if (isFull()) {
            System.out.println("Lista cheia!");
            return;
        }

        if (pos >= 0 && pos <= qtd) {
            for (int i = qtd; i > pos; i--) {
                elementos[i] = elementos[i - 1];
            }
            elementos[pos] = novoValor;
            qtd++;
        }
    }

    public void remove(int pos) {
        if (!isEmpty() && pos >= 0 && pos < qtd) {
            for (int i = pos; i < qtd - 1; i++) {
                elementos[i] = elementos[i + 1];
            }
            elementos[qtd - 1] = null;
            qtd--;
        }
    }

    public String view() {
        String ret = "";
        for (int i = 0; i < qtd; i++) {
            ret += elementos[i] + "|";
        }
        return ret;
    }

    public int getQtd() {
        return this.qtd;
    }
}