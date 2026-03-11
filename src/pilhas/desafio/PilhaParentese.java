package pilhas.desafio;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PilhaParentese {

    private Parentese topo;

    public boolean isEmpty(){
        return topo == null;
    }

    public void push(Parentese p){
        if (!isEmpty()){
            p.proximo = topo;
        }
        topo = p;
    }

    public Parentese pop(){
        if (!isEmpty()){
            Parentese saiu = topo;
            topo = topo.proximo;
            return saiu;
        }
        return null;
    }

    public Parentese peek(){
        if (isEmpty()) {
            return null;
        }
        return topo;
    }
}
