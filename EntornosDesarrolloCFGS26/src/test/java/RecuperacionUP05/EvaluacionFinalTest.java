package RecuperacionUP05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EvaluacionFinalTest {

    private EvaluacionFinal evaluacion;

    @BeforeEach
    public void setUp() {
        evaluacion = new EvaluacionFinal();
    }

    @Test
    public void testCalcularNotaFinalCasoCorrecto() {
        double resultado = evaluacion.calcularNotaFinal(6, 7, 8);
        assertEquals(6.9, resultado, 0.0001);
    }

    @Test
    public void testObtenerResultadoSuspenso() {
        assertEquals("Suspenso", evaluacion.obtenerResultado(3.0));
    }

    @Test
    public void testObtenerResultadoAprobado() {
        assertEquals("Aprobado", evaluacion.obtenerResultado(5.5));
    }

    @Test
    public void testObtenerResultadoNotable() {
        assertEquals("Notable", evaluacion.obtenerResultado(7.5));
    }

    @Test
    public void testObtenerResultadoSobresaliente() {
        assertEquals("Sobresaliente", evaluacion.obtenerResultado(9.5));
    }

    @Test
    public void testLimite4_9() {
        assertEquals("Suspenso", evaluacion.obtenerResultado(4.9));
    }

    @Test
    public void testLimite5_0() {
        assertEquals("Aprobado", evaluacion.obtenerResultado(5.0));
    }

    @Test
    public void testLimite6_9() {
        assertEquals("Notable", evaluacion.obtenerResultado(6.9));
    }

    @Test
    public void testLimite7_0() {
        assertEquals("Notable", evaluacion.obtenerResultado(7.0));
    }

    @Test
    public void testLimite8_9() {
        assertEquals("Notable", evaluacion.obtenerResultado(8.9));
    }

    @Test
    public void testLimite9_0() {
        assertEquals("Sobresaliente", evaluacion.obtenerResultado(9.0));
    }

    @Test
    public void testEstaAprobado() {
        assertTrue(evaluacion.estaAprobado(5.0));
        assertTrue(evaluacion.estaAprobado(7.5));
        assertFalse(evaluacion.estaAprobado(4.9));
    }

    @Test
    public void testCalcularMedia() {
        double[] notas = {5.0, 7.0, 9.0};
        assertEquals(7.0, evaluacion.calcularMedia(notas), 0.0001);
    }

    @Test
    public void testExcepcionNotaNegativa() {
        assertThrows(IllegalArgumentException.class,
                () -> evaluacion.calcularNotaFinal(-1, 7, 8));
    }

    @Test
    public void testExcepcionNotaMayorQue10() {
        assertThrows(IllegalArgumentException.class,
                () -> evaluacion.calcularNotaFinal(6, 11, 8));
    }

    @Test
    public void testExcepcionArrayVacio() {
        double[] notas = {};
        assertThrows(IllegalArgumentException.class,
                () -> evaluacion.calcularMedia(notas));
    }
}
