package lista.lista_linear;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ListaLinearTest {

    ListaLinear lista;

    @BeforeEach
    void init() {
        lista = new ListaLinear(10);
    }

    @Test
    void addTest() {
        assertTrue(lista.isEmpty());
        lista.add("A");
        lista.add("B");
        lista.add("C");
        lista.add("D");

        assertFalse(lista.isEmpty());
        assertEquals(4, lista.getQtd());
        assertEquals("A|B|C|D|", lista.view());
    }

    @Test
    void addPosMeio() {
        lista.add("A"); // pos 0
        lista.add("B"); // pos 1
        lista.add("C"); // pos 2
        lista.add("E", 1);

        assertEquals("A|E|B|C|", lista.view());
    }

    @Test
    void removeTest() {
        lista.add("A");
        lista.add("B");
        lista.add("C");
        lista.remove(0);

        assertEquals("B|C|", lista.view());
    }

    @Test
    void buscaLinearTest() {
        lista.add("A");
        lista.add("B");
        lista.add("C");

        assertEquals(1, lista.buscaLinear("B"));
        assertEquals(-1, lista.buscaLinear("Z"));
    }
}