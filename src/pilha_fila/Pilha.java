package pilha_fila;

public class Pilha {

    Pessoa topo;

    public boolean isEmpty(){
        return topo == null;
    }

    public void push(Pessoa p){
        if (!isEmpty()){
            p.proximo = topo;
        }
        topo = p;
    }

    public Pessoa pop(){
        if (!isEmpty()){
            Pessoa saiu = topo;
            topo = topo.proximo;
            return saiu;
        }
        return null;
    }
}