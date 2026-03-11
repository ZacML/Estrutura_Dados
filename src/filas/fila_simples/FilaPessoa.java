package filas.fila_simples;

public class FilaPessoa {
    Pessoa inicio;
    Pessoa fim;

    boolean isEmpty(){
        return inicio == null && fim == null;
    }

}
