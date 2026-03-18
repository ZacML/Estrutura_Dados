package filas.fila_prioridade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilaPrioridadePessoaTest {

    FilaPrioridadePessoa fila;
    Pessoa p1;
    Pessoa p2;
    Pessoa p3;
    Pessoa p4;

    @BeforeEach
    void init(){
        fila = new FilaPrioridadePessoa();
        p1 = new Pessoa("JOAO", 1, null);
        p2 = new Pessoa("PEDRO", 5, null);
        p3 = new Pessoa("MARIA", 3, null);
        p4 = new Pessoa("LARA", 5, null);
    }

    @Test
    void deveRemoverPorPrioridadeMantendoFIFOEmEmpate() {
        FilaPrioridadePessoa fila = new FilaPrioridadePessoa();

        fila.enqueue(p1);
        fila.enqueue(p2);
        fila.enqueue(p3);
        fila.enqueue(p4);

        // 1ª remoção -> maior prioridade (5), primeiro da fila com essa prioridade (B)
        Pessoa p1 = fila.dequeue();
        assertEquals("PEDRO", p1.getNome());

        // 2ª remoção -> próximo com prioridade 5 (D)
        Pessoa p2 = fila.dequeue();
        assertEquals("LARA", p2.getNome());

        // 3ª remoção -> prioridade 3 (C)
        Pessoa p3 = fila.dequeue();
        assertEquals("MARIA", p3.getNome());

        // 4ª remoção -> prioridade 1 (A)
        Pessoa p4 = fila.dequeue();
        assertEquals("JOAO", p4.getNome());

        // fila deve estar vazia
        assertTrue(fila.isEmpty());
    }
}