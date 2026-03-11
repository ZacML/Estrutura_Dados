package pilhas.desafio;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Parentese {

    private char valor;
    public Parentese proximo;

}
