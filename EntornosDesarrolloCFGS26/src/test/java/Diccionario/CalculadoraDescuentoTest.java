package Diccionario;

import Calculadora.CalculadoraDescuento;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDescuentoTest {

    CalculadoraDescuento calc = new CalculadoraDescuento();

    @Test
    void testNormal() {
        assertEquals(90.0, calc.calcularPrecioFinal(100, 10, false));
    }

    @Test
    void testClienteVip() {
        assertEquals(75.0, calc.calcularPrecioFinal(100, 20, true));
    }

    @Test
    void testExcepcionPrecioNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.calcularPrecioFinal(-10, 10, false);
        });
    }

    @Test
    void testLimiteDescuentoMaximo() {
        assertEquals(45.0, calc.calcularPrecioFinal(100, 50, false));
    }
}