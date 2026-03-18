package filas.fila_simples;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pessoa {
    public String nome;
    public Pessoa proximo;
}
