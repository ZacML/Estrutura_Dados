package pilhas.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Livro {

    private String titulo;
    private int nrPaginas;
    private int anoLancamento;
    public Livro proximo;

}