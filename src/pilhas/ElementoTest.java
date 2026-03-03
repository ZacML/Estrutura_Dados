package pilhas;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoTest {

    Elemento pilha;

    @BeforeEach
    public void inicializa(){
        pilha = new Elemento(0);
    }

    @Test
    @Description("Verifica a inclusão correta")
    public void pushTest(){
        pilha.push(1);
        pilha.push(5);
        pilha.push(8);
        int valorTopo = pilha.peek();
        assertEquals(8, valorTopo);
        String view = pilha.view();
        assertEquals("8-5-1", view);
    }

    @Test
    @Description("Verifica a remoção correta")
    public void popTest(){
        pilha.push(1);
        pilha.push(2);
        pilha.pop();
        assertEquals(1, pilha.peek());
        pilha.pop();
        assertTrue(pilha.isEmpty());
    }

    @Test
    @Description("Verifica o topo de uma pilha vazia")
    public void peekTest(){
        int valor = pilha.peek();
        assertEquals(0, valor);
    }

    @Test
    @Description("Remove de uma pilha vazia")
    public void popVaziaTest(){
        pilha.pop();
    }



}