package filas.fila_prioridade;

public class FilaPrioridadePessoa {
    Pessoa inicio;
    Pessoa fim;

    boolean isEmpty(){
        return inicio == null && fim == null;
    }

    public void enqueue(Pessoa entrarNaFila){
        if (isEmpty()) {
            inicio = entrarNaFila;
            fim = entrarNaFila;
        } else {
            fim.proximo = entrarNaFila;
            fim = entrarNaFila;
        }
    }

    public Pessoa dequeue() {
        if (isEmpty()) return null;

        Pessoa atual = inicio;
        Pessoa anterior = null;

        Pessoa maior = inicio;
        Pessoa anteriorMaior = null;

        while (atual != null) {
            if (atual.prioridade > maior.prioridade) {
                maior = atual;
                anteriorMaior = anterior;
            }
            anterior = atual;
            atual = atual.proximo;
        }

        // Remover o maior encontrado
        if (maior == inicio) {
            inicio = inicio.proximo;
        } else {
            anteriorMaior.proximo = maior.proximo;
        }

        // Atualiza fim se necessário
        if (maior == fim) {
            fim = anteriorMaior;
        }

        // limpa referência
        maior.proximo = null;

        return maior;
    }

    public String view(){
        if (isEmpty())
            return "";

        FilaPrioridadePessoa aux = clone();
        String ret = "";
        do {
            ret += aux.inicio.getNome() + " | ";
            aux.inicio = aux.inicio.proximo;
        } while(aux.inicio != null);
        return ret;
    }

    @Override
    public FilaPrioridadePessoa clone(){
        FilaPrioridadePessoa nova = new FilaPrioridadePessoa();
        nova.inicio = this.inicio;
        nova.fim = this.fim;
        return nova;
    }

}
