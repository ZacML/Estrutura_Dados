package filas.fila_simples;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pessoa {
    private String nome;
    Pessoa proximo;
}
