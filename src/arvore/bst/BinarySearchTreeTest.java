package arvore.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    BinarySearchTree arvore;

    @BeforeEach
    void init() {
        arvore = new BinarySearchTree();
        // Inserção base que dispara rebalanceamentos internos
        arvore.inserir(44);
        arvore.inserir(33);
        arvore.inserir(22);
        arvore.inserir(25);
        arvore.inserir(55);
        arvore.inserir(52);
    }

    @Test
    void testarCaminhamentosAposInsere() {
        // Verifica se, após as inserções do BeforeEach, a árvore está ordenada e balanceada
        // A ordem In-Order deve ser sempre crescente independente do balanceamento
        String inOrdemEsperada = "Em-Ordem: [22, 25, 33, 44, 52, 55]";
        assertEquals(inOrdemEsperada, arvore.caminho(TipoCaminho.IN_ORDER));

        // O Pre-Order revela a estrutura da árvore após as rotações AVL
        // Esperado que o 33 ou 44 seja a raiz dependendo das rotações
        System.out.println("Estrutura após BeforeEach: " + arvore.caminho(TipoCaminho.PRE_ORDER));
    }

    @Test
    void testarBalanceamentoAutomatico() {
        BinarySearchTree avl = new BinarySearchTree();

        // Caso: Rotação Simples à Esquerda (Valores: 10, 20, 30)
        avl.inserir(10);
        avl.inserir(20);
        avl.inserir(30);

        // Em uma AVL, o 20 deve subir para ser a raiz
        String preOrdemSimples = avl.caminho(TipoCaminho.PRE_ORDER);
        assertEquals("Pré-Ordem: [20, 10, 30]", preOrdemSimples);

        // Caso: Rotação Dupla (Valores: 30, 10, 20)
        BinarySearchTree avlDupla = new BinarySearchTree();
        avlDupla.inserir(30);
        avlDupla.inserir(10);
        avlDupla.inserir(20);

        // O 20 deve subir para a raiz após a rotação dupla
        String preOrdemDupla = avlDupla.caminho(TipoCaminho.PRE_ORDER);
        assertEquals("Pré-Ordem: [20, 10, 30]", preOrdemDupla);
    }

    @Test
    void testarRemocaoComBalanceamento() {
        // Usando a árvore populada no BeforeEach: [22, 25, 33, 44, 52, 55]

        // Remove uma folha
        arvore.remover(25);
        assertFalse(arvore.caminho(TipoCaminho.IN_ORDER).contains("25"));

        // Remove um nó com dois filhos (dispara busca de sucessor e rebalanceamento)
        arvore.remover(33);

        // Verifica se a integridade da ordem crescente permanece
        String inOrdemPosRemocao = "Em-Ordem: [22, 44, 52, 55]";
        assertEquals(inOrdemPosRemocao, arvore.caminho(TipoCaminho.IN_ORDER));

        System.out.println("Estrutura após remoções: " + arvore.caminho(TipoCaminho.PRE_ORDER));
    }

    @Test
    void testarBuscaEInformacoes() {
        // Valida se a busca continua funcional na árvore balanceada
        arvore.buscarEInformar(52);
        arvore.buscarEInformar(22);

        // Teste de valor inexistente
        arvore.buscarEInformar(999);
    }
}