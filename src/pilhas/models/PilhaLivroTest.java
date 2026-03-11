package pilhas.models;

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
        l1 = new Livro("titulo01",100,2010,null);
        l2 = new Livro("titulo02",200,2020,null);
        l3 = new Livro("titulo03",300,2030,null);
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
    void removePilhaTest() {
        pilha.push(l1);
        pilha.push(l2);
        pilha.push(l3);
        pilha.pop();
        assertEquals(l2.getTitulo(), pilha.peek().getTitulo());
        pilha.pop();
        assertEquals(l1.getTitulo(), pilha.peek().getTitulo());
        pilha.pop();
        System.out.println(pilha.peek());
        assertTrue(pilha.isEmpty());
    }

    @Test
    @Description("Teste de view")
    void viewPilhaTest(){
        pilha.push(l1);
        pilha.push(l2);
        pilha.push(l3);
        String r = pilha.view();
        System.out.println(r);
        assertEquals("titulo03\ntitulo02\ntitulo01\n", r);
    }
}