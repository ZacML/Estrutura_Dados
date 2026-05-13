package lista;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class No {

    String valor;
    No anterior;
    No proximo;

    public No(String valor){
        this.valor = valor;
    }

}
