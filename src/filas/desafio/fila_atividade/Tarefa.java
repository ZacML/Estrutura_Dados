package filas.desafio.fila_atividade;

import filas.fila_prioridade.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tarefa {
    public String descricao;
    public Double valor;
    public int prioridade;
    public Tarefa proximo;
}
