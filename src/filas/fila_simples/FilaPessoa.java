package filas.fila_simples;

public class FilaPessoa {
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

    public void dequeue(){
        if (!isEmpty()) {
            if (inicio == fim){
                inicio = null;
                fim = null;
            } else {
                inicio = inicio.proximo;
            }
        }
    }

    public String view(){
        if (isEmpty())
            return "";

        FilaPessoa aux = clone();
        String ret = "";
        do {
            ret += aux.inicio.getNome() + " | ";
            aux.inicio = aux.inicio.proximo;
        } while(aux.inicio != null);
        return ret;
    }

    @Override
    public FilaPessoa clone(){
        FilaPessoa nova = new FilaPessoa();
        nova.inicio = this.inicio;
        nova.fim = this.fim;
        return nova;
    }

}
