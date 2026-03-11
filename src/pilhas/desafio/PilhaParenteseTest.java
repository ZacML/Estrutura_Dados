package pilhas.desafio;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PilhaParenteseTest {

    PilhaParentese pilha;
    List<String> expressoes;

    @BeforeEach
    public void init() {
        pilha = new PilhaParentese();
        expressoes = List.of(
                "((1+2) - 3 + (5-5-6) + (b-v))",
                "(1+2) + (b-v)",
                "((()(())))",
                "(((1+2 - 3 + (5-5-6) + (b-v))",
                "(1+2) + (b-v",
                "((((())))"
        );
    }

    @Test
    @Description("Avalia as 6 expressoes")
    void avaliaExpressaoTest(){
        assertTrue(avaliaExpressao(expressoes.get(0)));
        pilha = new PilhaParentese();
        assertTrue(avaliaExpressao(expressoes.get(1)));
        pilha = new PilhaParentese();
        assertTrue(avaliaExpressao(expressoes.get(2)));
        pilha = new PilhaParentese();
        assertFalse(avaliaExpressao(expressoes.get(3)));
        pilha = new PilhaParentese();
        assertFalse(avaliaExpressao(expressoes.get(4)));
        pilha = new PilhaParentese();
        assertFalse(avaliaExpressao(expressoes.get(5)));
    }

    private boolean avaliaExpressao(String expressao){
        char[] caracteres = expressao.toCharArray();
        for (char c: caracteres){
            if (c == '('){
                Parentese p = new Parentese('(', null);
                pilha.push(p);
            }
            if (c == ')') {
                pilha.pop();
            }
        }

        return pilha.isEmpty();

    }

}