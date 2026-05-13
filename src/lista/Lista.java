package lista;

public class Lista {

    int qtd = 0;
    No pontoInicial;

    boolean isEmpty(){
        return qtd == 0;
    }

    void remove(int pos){
        if (!isEmpty() && pos <= qtd){
            No remover = buscaPos(pos);
            if (remover == null)
                return;
            if (remover.anterior != null)
                remover.anterior.proximo = remover.proximo;
            if (remover.proximo != null)
                remover.proximo.anterior = remover.anterior;
            if (remover == pontoInicial)
                pontoInicial = remover.proximo;
            qtd --;
        }
    }

    void add(No novo, int pos){
        if (isEmpty()){
            pontoInicial = novo;
        } else {
            No atual = buscaPos(pos);

            novo.proximo = atual;
            novo.anterior = atual.anterior;

            if (atual.anterior != null){
                atual.anterior.proximo = novo;
            } else {
                pontoInicial = novo;
            }

            atual.anterior = novo;
        }
        qtd++;
    }

    void add(No novo){
        if (isEmpty()){
            pontoInicial = novo;
        } else {
            No ultimo = buscaUltimo();
            ultimo.proximo = novo;
            novo.anterior = ultimo;
        }

        qtd++;
    }

    String view(){
        String ret = "";
        No atual = pontoInicial;
        for(int i=0; i< qtd; i++){
            ret += atual.valor + "|";
            atual = atual.proximo;
        }
        return ret;
    }

    private No buscaUltimo(){
        No ultimo = pontoInicial;
        for (int i=0; i< qtd-1; i++){
            ultimo = ultimo.proximo;
        }
        return ultimo;
    }

    private No buscaPos(int pos){
        No noPos = pontoInicial;
        for (int i=0; i<pos; i++){
            noPos = noPos.proximo;
        }
        return noPos;
    }

}
