package aula13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatematicaTeste {

    @Test
    void deveSomarDoisNumeros(){
        assertEquals(11, Matematica.somar(8 , 3));
    }

    @Test
    void deveSubtrairDoisNumeros(){
        assertEquals(5, Matematica.subtrair(8 , 3));
    }

    @Test
    void deveMultiplicarDoisNumeros(){
        assertEquals(24, Matematica.multiplicar(8 , 3));
    }

    @Test
    void deveDividirDoisNumeros(){
        assertEquals(4, Matematica.dividir(8 , 2));
    }
}
