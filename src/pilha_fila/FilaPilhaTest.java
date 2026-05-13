package pilha_fila;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilaPilhaTest {

    Fila fila;
    Pilha pilha;

    Pessoa pA;
    Pessoa pB;
    Pessoa pC;
    Pessoa pD;

    @BeforeEach
    void init(){
        fila = new Fila();
        pilha = new Pilha();
        pA = new Pessoa();
        pB = new Pessoa();
        pC = new Pessoa();
        pD = new Pessoa();
    }

    @Test
    void deFilaParaPilha(){
        fila.enqueue(pA);
        fila.enqueue(pB);
        fila.enqueue(pC);
        fila.enqueue(pD);
        assertEquals("A", fila.inicio.nome);
        assertEquals("D", fila.fim.nome);
        pilha.push(fila.dequeue());
        pilha.push(fila.dequeue());
        pilha.push(fila.dequeue());
        pilha.push(fila.dequeue());
        assertTrue(fila.isEmpty());
        assertEquals("D", pilha.topo.nome);
    }
}