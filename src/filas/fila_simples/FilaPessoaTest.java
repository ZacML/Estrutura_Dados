package filas.fila_simples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilaPessoaTest {

    FilaPessoa fila;
    Pessoa p1;
    Pessoa p2;
    Pessoa p3;

    @BeforeEach
    void init(){
        fila = new FilaPessoa();
        p1 = new Pessoa("JOAO", null);
        p2 = new Pessoa("PEDRO", null);
        p3 = new Pessoa("MARIA", null);
    }

    @Test
    void insere(){
        fila.enqueue(p1);
        fila.enqueue(p2);
        fila.enqueue(p3);
        assertEquals("JOAO", fila.inicio.getNome());
        assertEquals("MARIA", fila.fim.getNome());
    }

    @Test
    void remove(){
        fila.enqueue(p1);
        fila.enqueue(p2);
        fila.enqueue(p3);
        fila.dequeue();
        assertEquals("PEDRO", fila.inicio.getNome());
        assertEquals("MARIA", fila.fim.getNome());
        fila.dequeue();
        assertEquals("MARIA", fila.inicio.getNome());
        assertEquals("MARIA", fila.fim.getNome());
        fila.dequeue();
        assertTrue(fila.isEmpty());
    }

    @Test
    void view(){
        fila.enqueue(p2);
        fila.enqueue(p3);
        fila.enqueue(p1);
        assertEquals("PEDRO | MARIA | JOAO | ", fila.view());
    }
}