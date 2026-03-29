package filas.desafio.fila_atividade;

public class FilaPrioridadeTarefa {
    Tarefa inicio;
    Tarefa fim;

    boolean isEmpt(){return inicio == null && fim == null;}

    private int definirPrioridade(Double valor) {
        if (valor >= 100) {
            return 3; // alta prioridade
        } else if (valor >= 50) {
            return 2; // média prioridade
        } else {
            return 1; // baixa prioridade
        } 
    }
    
    public void enqueue(Tarefa nova){
    nova.prioridade = definirPrioridade(nova.valor);

    if (isEmpt()) {
        inicio = nova;
        fim = nova;
        return;
    }

    if (nova.prioridade > inicio.prioridade) {
        nova.proximo = inicio;
        inicio = nova;
        return;
    }

    Tarefa atual = inicio;

    while (atual.proximo != null && atual.proximo.prioridade >= nova.prioridade) {
        atual = atual.proximo;
    }

    nova.proximo = atual.proximo;
    atual.proximo = nova;

    if (nova.proximo == null) {
        fim = nova;
    }
}
}
