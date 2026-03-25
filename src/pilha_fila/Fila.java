package pilha_fila;


public class Fila {
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

    public Pessoa dequeue(){
        if (!isEmpty()) {
            Pessoa saiu = inicio;
            if (inicio == fim){
                inicio = null;
                fim = null;
            } else {
                inicio = inicio.proximo;
            }
            return saiu;
        }
        return null;
    }
}
