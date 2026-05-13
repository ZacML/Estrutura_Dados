package arvore.bst;

public class Node {
    int valor;
    Node esquerdo;
    Node direito;

    public Node(int valor) {
        this.valor = valor;
        this.esquerdo = null;
        this.direito = null;
    }
}