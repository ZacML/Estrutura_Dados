package models;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilhaLivroTest {

    PilhaLivro pilha;
    Livro l1;
    Livro l2;
    Livro l3;

    @BeforeEach
    public void init(){
        pilha = PilhaLivro.builder().build();
        l1 = new Livro("titulo01",100,2010);
        l2 = new Livro("titulo02",200,2020);
        l3 = new Livro("titulo03",300,2030);
    }

    @Test
    @Description("Teste inserção com pilha vazia")
    void insereEmPilhaVazia(){
        pilha.push(l1);
        pilha.push(l2);
        pilha.push(l3);
        Livro topo = pilha.peek();
        assertEquals(l3.getTitulo(), topo.getTitulo());
    }

    @Test
    @Description("Teste remoção da pilha")
    public void popTest() {
        pilha.push(l1);
        pilha.push(l2);
        pilha.push(l3);
        pilha.pop();
        assertEquals(l2, pilha.peek());
        pilha.pop();
        assertEquals(l1, pilha.peek());
//        pilha.pop();
//        assertTrue(pilha.isEmpty());
    }
}