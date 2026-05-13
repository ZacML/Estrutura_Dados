package arvore.bst;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private Node raiz;

    private static class Node {
        int valor;
        Node esquerdo, direito;
        Node(int valor) { this.valor = valor; }
    }

    public void inserir(int valor) {
        System.out.println("\n=== Inserindo: " + valor + " ===");
        raiz = inserirRecursivo(raiz, valor);
        imprimirEstrutura();
    }

    private Node inserirRecursivo(Node atual, int valor) {
        // 1. Inserção normal de BST
        if (atual == null) return new Node(valor);

        if (valor < atual.valor) {
            atual.esquerdo = inserirRecursivo(atual.esquerdo, valor);
        } else if (valor > atual.valor) {
            atual.direito = inserirRecursivo(atual.direito, valor);
        } else {
            return atual; // Valores duplicados não permitidos na AVL padrão
        }

        // 2. Obter fator de balanceamento
        int fb = getFatorBalanceamento(atual);

        // 3. Casos de Desbalanceamento

        // Caso Esquerda-Esquerda (Simples Direita)
        if (fb > 1 && valor < atual.esquerdo.valor) {
            return rotacaodireita(atual);
        }

        // Caso Direita-Direita (Simples Esquerda)
        if (fb < -1 && valor > atual.direito.valor) {
            return rotacaoEsquerda(atual);
        }

        // Caso Esquerda-Direita (Dupla Direita)
        if (fb > 1 && valor > atual.esquerdo.valor) {
            atual.esquerdo = rotacaoEsquerda(atual.esquerdo);
            return rotacaodireita(atual);
        }

        // Caso Direita-Esquerda (Dupla Esquerda)
        if (fb < -1 && valor < atual.direito.valor) {
            atual.direito = rotacaodireita(atual.direito);
            return rotacaoEsquerda(atual);
        }

        return atual;
    }

    public void imprimirEstrutura() {
        int altura = getAltura(raiz);
        List<Node> nos = new ArrayList<>();
        nos.add(raiz);
        imprimirNivel(nos, 1, altura);
    }

    private void imprimirNivel(List<Node> nos, int nivel, int alturaMax) {
        if (nos.isEmpty() || eTudoNulo(nos)) return;

        int piso = alturaMax - nivel;
        int linhasEntreNiveis = (int) Math.pow(2, (Math.max(piso - 1, 0)));
        int espacosPrimarios = (int) Math.pow(2, (piso)) - 1;
        int espacosEntreNos = (int) Math.pow(2, (piso + 1)) - 1;

        imprimirEspacos(espacosPrimarios);

        List<Node> proximosNos = new ArrayList<>();
        for (Node no : nos) {
            if (no != null) {
                System.out.print(String.format("%2d", no.valor));
                proximosNos.add(no.esquerdo);
                proximosNos.add(no.direito);
            } else {
                System.out.print("  ");
                proximosNos.add(null);
                proximosNos.add(null);
            }
            imprimirEspacos(espacosEntreNos);
        }
        System.out.println();

        // Desenha as "pernas" conectoras (/, \)
        for (int i = 1; i <= linhasEntreNiveis; i++) {
            imprimirEspacos(espacosPrimarios - i);
            for (int j = 0; j < nos.size(); j++) {
                if (nos.get(j) == null) {
                    imprimirEspacos(espacosEntreNos + 2);
                    continue;
                }
                if (nos.get(j).esquerdo != null) System.out.print("/");
                else System.out.print(" ");

                imprimirEspacos(2 * i - 1);

                if (nos.get(j).direito != null) System.out.print("\\");
                else System.out.print(" ");

                imprimirEspacos(espacosEntreNos - 2 * i + 1);
            }
            System.out.println();
        }

        imprimirNivel(proximosNos, nivel + 1, alturaMax);
    }

    private void imprimirEspacos(int n) {
        for (int i = 0; i < n; i++) System.out.print(" ");
    }

    private int getAltura(Node no) {
        if (no == null) return -1;
        return 1 + Math.max(getAltura(no.esquerdo), getAltura(no.direito));
    }

    private boolean eTudoNulo(List<Node> lista) {
        for (Object o : lista) if (o != null) return false;
        return true;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] valores = {44, 33, 55, 22, 52, 60, 10};
        for (int v : valores) bst.inserir(v);
    }

    public void buscarEInformar(int valorProcurado) {
        System.out.println("\n--- Buscando valor: " + valorProcurado + " ---");
        // Chamamos a busca passando a raiz e o nível inicial (1)
        buscarRecursivoEImprimir(raiz, valorProcurado, 0);
    }

    private void buscarRecursivoEImprimir(Node atual, int valor, int nivel) {
        if (atual == null) {
            System.out.println("Valor " + valor + " não encontrado na árvore.");
            return;
        }

        if (valor == atual.valor) {
            int alturaNo = getAltura(atual); // Usa o seu método getAltura já existente
            System.out.println("Valor encontrado: " + atual.valor);
            System.out.println("Nível na árvore: " + nivel);
            System.out.println("Altura do nó (subárvore): " + alturaNo);
        } else if (valor < atual.valor) {
            buscarRecursivoEImprimir(atual.esquerdo, valor, nivel + 1);
        } else {
            buscarRecursivoEImprimir(atual.direito, valor, nivel + 1);
        }
    }

    public void remover(int valor) {
        System.out.println("\n=== Removendo: " + valor + " ===");
        raiz = removerRecursivo(raiz, valor);
        imprimirEstrutura();
    }

    private Node removerRecursivo(Node atual, int valor) {
        if (atual == null) return null;

        if (valor < atual.valor) {
            atual.esquerdo = removerRecursivo(atual.esquerdo, valor);
        } else if (valor > atual.valor) {
            atual.direito = removerRecursivo(atual.direito, valor);
        } else {
            if (atual.esquerdo == null || atual.direito == null) {
                Node temp = (atual.esquerdo != null) ? atual.esquerdo : atual.direito;
                if (temp == null) { // Caso sem filhos
                    atual = null;
                } else { // Caso com um filho
                    atual = temp;
                }
            } else {
                // Caso com dois filhos
                atual.valor = encontrarMinimo(atual.direito);
                atual.direito = removerRecursivo(atual.direito, atual.valor);
            }
        }

        if (atual == null) return null;

        // Rebalanceamento após remoção
        int fb = getFatorBalanceamento(atual);

        if (fb > 1 && getFatorBalanceamento(atual.esquerdo) >= 0)
            return rotacaodireita(atual);

        if (fb > 1 && getFatorBalanceamento(atual.esquerdo) < 0) {
            atual.esquerdo = rotacaoEsquerda(atual.esquerdo);
            return rotacaodireita(atual);
        }

        if (fb < -1 && getFatorBalanceamento(atual.direito) <= 0)
            return rotacaoEsquerda(atual);

        if (fb < -1 && getFatorBalanceamento(atual.direito) > 0) {
            atual.direito = rotacaodireita(atual.direito);
            return rotacaoEsquerda(atual);
        }

        return atual;
    }

    private int encontrarMinimo(Node no) {
        int min = no.valor;
        while (no.esquerdo != null) {
            min = no.esquerdo.valor;
            no = no.esquerdo;
        }
        return min;
    }

    public String caminho(TipoCaminho tipo) {
        StringBuilder sb = new StringBuilder();
        List<Integer> resultado = new ArrayList<>();

        switch (tipo) {
            case PRE_ORDER:
                percursoPreOrdem(raiz, resultado);
                sb.append("Pré-Ordem: ");
                break;
            case IN_ORDER:
                percursoEmOrdem(raiz, resultado);
                sb.append("Em-Ordem: ");
                break;
            case POS_ORDER:
                percursoPosOrdem(raiz, resultado);
                sb.append("Pós-Ordem: ");
                break;
        }

        sb.append(resultado.toString());
        return sb.toString();
    }

    // Raiz -> Esquerda -> Direita
    private void percursoPreOrdem(Node atual, List<Integer> lista) {
        if (atual == null) return;
        lista.add(atual.valor);
        percursoPreOrdem(atual.esquerdo, lista);
        percursoPreOrdem(atual.direito, lista);
    }

    // Esquerda -> Raiz -> Direita
    private void percursoEmOrdem(Node atual, List<Integer> lista) {
        if (atual == null) return;
        percursoEmOrdem(atual.esquerdo, lista);
        lista.add(atual.valor);
        percursoEmOrdem(atual.direito, lista);
    }

    // Esquerda -> Direita -> Raiz
    private void percursoPosOrdem(Node atual, List<Integer> lista) {
        if (atual == null) return;
        percursoPosOrdem(atual.esquerdo, lista);
        percursoPosOrdem(atual.direito, lista);
        lista.add(atual.valor);
    }

    // Calcula o fator de balanceamento: altura(esquerda) - altura(direita)
    private int getFatorBalanceamento(Node no) {
        if (no == null) return 0;
        return getAltura(no.esquerdo) - getAltura(no.direito);
    }

    // Rotação à Direita (Caso Esquerda-Esquerda)
    private Node rotacaodireita(Node y) {
        Node x = y.esquerdo;
        Node T2 = x.direito;

        x.direito = y;
        y.esquerdo = T2;

        return x; // Nova raiz
    }

    // Rotação à Esquerda (Caso Direita-Direita)
    private Node rotacaoEsquerda(Node x) {
        Node y = x.direito;
        Node T2 = y.esquerdo;

        y.esquerdo = x;
        x.direito = T2;

        return y; // Nova raiz
    }
}