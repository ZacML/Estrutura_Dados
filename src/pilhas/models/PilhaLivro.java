package pilhas.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PilhaLivro {

    private Livro topo;

    public boolean isEmpty(){
        return topo == null;
    }

    public void push(Livro l){
        if (!isEmpty()){
            l.proximo = topo;
        }
        topo = l;
    }

    public Livro pop(){
        if (!isEmpty()){
            Livro saiu = topo;
            topo = topo.proximo;
            return saiu;
        }
        return null;
    }

    public Livro peek(){
        if (isEmpty()) {
            return null;
        }
        return topo;
    }

    public String view(){
        if (isEmpty())
            return "";

        PilhaLivro aux = this;
        StringBuilder retorno = new StringBuilder();

        while (aux.topo != null){
            retorno.append(aux.topo.getTitulo()).append("\n");
            aux.topo = topo.proximo;
        }
        return retorno.toString();
    }
}