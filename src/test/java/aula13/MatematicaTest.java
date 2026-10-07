package aula13;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class MatematicaTest {

    private static Matematica matematica;
    private static ServicoCambio servicoCambio;

    @BeforeAll
    static void preparar(){
        servicoCambio = mock(ServicoCambio.class);
        matematica = new Matematica(servicoCambio);
    }

    @Test
    void deveSomarDoisNumeros(){
        assertEquals(11, matematica.somar(8 , 3));
    }

    @Test
    void deveSubtrairDoisNumeros(){
        assertEquals(5, matematica.subtrair(8 , 3));
    }

    @Test
    void deveMultiplicarDoisNumeros(){
        assertEquals(24, matematica.multiplicar(8 , 3));
    }

    @Test
    void deveDividirDoisNumeros(){
        assertEquals(4, matematica.dividir(8 , 2));
    }

    @ParameterizedTest
            (name = "{0} em reais {1} com taxa {2} = {3}")
    @CsvSource({"100.0, USD, 0.10, 10.0",
                    "100.0, EUR, 0.16, 16.0"
    })

    void deveConverterMoedaUsandoTaxaDoSevico(
            double valor, String moeda, double taxa,
            double valorEsperado
    ){
        when(servicoCambio.obterTaxa(moeda)).thenReturn(taxa);
        double resultado = matematica.converterMoeda(valor, moeda);

        assertEquals(valorEsperado, resultado, 0.001);
        verify(servicoCambio).obterTaxa(moeda);
        verifyNoMoreInteractions(servicoCambio);
    }



}
